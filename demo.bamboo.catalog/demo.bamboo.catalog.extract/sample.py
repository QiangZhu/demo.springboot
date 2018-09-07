#!/usr/bin/env python
# -*- coding: utf-8 -*-
__author__ = 'zq'

import threading
from  datetime  import  * 
from random import randint

"""
    12345678,Engine,1,2018/8/7 15:19
"""

filename = 'sample.csv'
max_row = 1000000
components = ['engine','gear','radio','window']
values_engine = 10
values_gear = 10
values_radio = ['off','on']
values_window = ['off','on']
values_window_position = ['front','left-front','left-back' \
                          'right-front','right-back','back','top']
                          

def get_key() :
    import time
    millis = str(int(round(time.time() * 1000)))+str(randint(1,100000))+','
    return millis   

def get_datetime():
    datetime_now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    return datetime_now
    


def get_random_components(idx_components):
    info = get_key()
    if idx_components == 0 :
        info += components[0]+','+str(randint(0, values_engine))+',' \
            +get_datetime()
    elif idx_components == 1 :
        info += (components[1])+',' + str(randint(0, values_gear))+','\
        + get_datetime()
    elif idx_components == 2 :
        info += components[2]+',' \
        + values_radio[randint(0, len(values_radio)-1)]+','+ get_datetime()
    elif idx_components == 3 :
        info +=components[3]+'-' \
        + values_window_position[randint(0, len(values_window_position)-1)]+','\
        + values_window[randint(0, len(values_window)-1)]+','+ get_datetime()
    else:
        info = get_random_components(randint(0,3))
        info = info[:randint(1,len(info)-1)]
    return info

class LogThread ( threading.Thread ):
    
    def run(self):
        num_row = 0
        with open(filename, "a") as file:
            while num_row < max_row :
                file.write(get_random_components(randint(0,10))+'\n')
                #file.writelines(get_random_components(0))
                num_row +=1
if __name__ == '__main__' :

   LogThread().start()