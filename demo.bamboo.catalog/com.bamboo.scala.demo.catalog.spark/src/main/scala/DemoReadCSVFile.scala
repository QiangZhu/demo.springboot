package com.bamboo.scala.demo.catalog.spark
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object DemoReadCSVFile {


  def  readcvsfile: Unit ={
    val conf = new SparkConf().setMaster("spark://spark114:7077").setAppName("DemoReadCSVFile")
    val sc = new SparkContext(conf)
    val sparkSession = SparkSession.builder
      .config(conf = conf)
      .appName("spark session example")
      .getOrCreate()

    val path = "/home/centos/upload/smallsample.csv"
    val base_df = sparkSession.read.option("header", "true").csv(path)
    base_df.show()
  }

  def main(args: Array[String]): Unit = {

  }
}