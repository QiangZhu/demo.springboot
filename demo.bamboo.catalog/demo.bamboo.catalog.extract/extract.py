#!/usr/bin/env python
# -*- coding: utf-8 -*-
__author__ = 'zq'

import sys
import yaml
import socket
import os
from kafka import KafkaProducer
from  datetime  import  * 

"""
    filepath : sample.csv
    offset : 0
    interval : 7
    learning : 100
    column : 1,2
    url : http://localhost:8080/health
"""
yaml_filename = 'extract.yaml'
f = open(yaml_filename)
config = yaml.load(f)
       
def refresh_yaml() :
    with open(yaml_filename, 'w') as yaml_file:
        yaml.dump(config, yaml_file, default_flow_style=False)
    
def get_column_by_max(filepath,learning = 0):
    """
       returns normal number of columns by guess
    """
    max_column = 0
    num_line = 0
    with open(filepath) as f:
        for lines in f:
            line = lines.rstrip('\n') 
            num_column = len(line.split(","))
            max_column =  num_column if num_column > max_column else max_column
            num_line +=1
            if num_line > learning :
                break
    return max_column
	
def get_column_by_score(filepath,offset = 0 , learning = 1):
    """
       returns normal number of columns by guess
    """
    score = {}
    num_line = 0
    with open(filepath) as f:
        f.seek(offset)
        for lines in f:
            line = lines.rstrip('\n') 
            num_column = len(line.split(","))
            print(" num_column %s " % num_column)
            key = num_column
            if key not in score :
                score[key] = 1
            else :
                count = score[key]
                count += 1
                score[key] = count				
            num_line +=1
            if num_line > learning :
                break
    column_score = 0
    max_score = 0
    for (k,v) in score.items() : 
        if v > max_score :
            max_score = v
            column_score = int(k)
    return column_score
    				
   
def request(data):
    print(data)
    
def get_error_path(fin_path) :
    return '$' + fin_path
    
def get_fout_path(fin_path) :
    return '_'+ fin_path

def get_final_ok_path(fin_path) :
    return 'ok_'+ fin_path
    
def get_final_error_path(fin_path) : 
    return 'error_'+fin_path
    
def rename(source_filename,target_filename) :
    if os.path.exists(target_filename) and os.path.isfile(target_filename):
        os.remove(target_filename)     
    os.rename(source_filename,target_filename) 
    
def error(fin_path,error_path,final_error_path,error_number) :
    if error_number > 1 : 
        final_error_path = get_final_error_path(fin_path)
        rename(error_path,final_error_path)
    else :
        os.remove(error_path)


def extract(fin_path,offset = 0,interval = 10000 , recommend = 1):
    line_number = 0
    error_number = 0
    current_offset = offset
    fout_path  = get_fout_path(fin_path)
    error_path = get_error_path(fin_path)
    with open(fin_path) as fin,open(fout_path, "a") as fout, \
        open(error_path,'a') as ferror:
        fin.seek(offset)
        for raw_line in fin:
            current_offset += len(raw_line)
            config['offset'] = current_offset
            print("offset : %s" % current_offset)
            line = raw_line.rstrip('\n') 
            num_column = len(line.split(","))
            if num_column >= recommend :
                    fout.write(raw_line)
            else:
                error_number += 1
                ferror.write(raw_line)
            if line_number < interval :
                line_number += 1
            else :
                refresh_yaml()
                line_number = 0
    rename(fout_path,get_final_ok_path(fin_path))
    error(fin_path,error_path,get_final_error_path(fin_path),error_number)

    
def extract_to_kafka(fin_path,offset = 0,interval = 10000 , recommend = 1) :
    line_number = 0
    error_number = 0
    current_offset = offset
    fout_path  = get_fout_path(fin_path)
    error_path = get_error_path(fin_path)
    producer = KafkaProducer(bootstrap_servers='192.168.1.7:9092')
    with open(fin_path) as fin,open(error_path,'a') as ferror:
        fin.seek(offset)
        for raw_line in fin:
            current_offset += len(raw_line)
            config['offset'] = current_offset
            print("offset : %s" % current_offset)
            line = raw_line.rstrip('\n') 
            num_column = len(line.split(","))
            if num_column >= recommend :
                    producer.send('demo', raw_line.encode('utf-8'))
            else:
                error_number += 1
                ferror.write(raw_line)
            if line_number < interval :
                line_number += 1
            else :
                refresh_yaml()
                line_number = 0
    error(fin_path,error_path,get_final_error_path(fin_path),error_number) 

def get_local_ip():
    try:
        csock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        csock.connect(('8.8.8.8', 80))
        (addr, port) = csock.getsockname()
        csock.close()
        return addr
    except socket.error:
        return "127.0.0.1"
    
def get_datetime():
    datetime_now = datetime.now()
    return datetime_now
    
def get_data():
    data = "ip:%s,starttime:%s,filepath:%s,learning:%s,offset:%s,column:%s" % \
        (get_local_ip(),get_datetime(),config['filepath'],config['learning'], \
        config['offset'],config['column'])
    return {"status":"error","data":data} 
    
def init():
    print(config)
    # validate file path
    filepath = config['filepath']
    url = config['url']
    if url is None:
        sys.exit(0)
    if filepath is None :
        error = {"status":"error","data":"filepath is none"}
        request(error)
        sys.exit(0)
    params = sys.argv
    if len(params) > 1:
       offset = params[1]
       config['offset'] = int(offset)
    if len(params) > 2:
        interval = params[2]
        config['interval'] = int(interval)
    if len(params) > 3:
       learning = params[3]
       config['learning'] = int(learning)  
    if len(params) > 4:
       column = params[4]
       config['column'] = column
    print(config)

    
def run() :
    init()
    fin_path = config['filepath']
    offset = config['offset']
    interval = config['interval']
    recommend = get_column_by_score(fin_path)
    extract_to_kafka(fin_path,offset,interval,recommend)

if __name__ == "__main__" : 

    run()
    
    