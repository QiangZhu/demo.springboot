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

    val path = "/home/centos/demo/sample.csv"
    val base_df = sparkSession.read.option("header", "true").csv(path)
    base_df.show()
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("spark://spark114:7077").setAppName("DemoReadCSVFile")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder
      .config(conf = conf)
      .appName("spark session example")
      .getOrCreate()

    val path = "/home/centos/demo/  sample.csv"
    val df = spark.read.option("header", "true").csv(path)
    df.createOrReplaceTempView("catalog")
    val sqlDF = spark.sql(" SELECT key,value FROM catalog  where key is not null and value is not null group by key,value order by key")
    sqlDF.show(1000)
  }
}