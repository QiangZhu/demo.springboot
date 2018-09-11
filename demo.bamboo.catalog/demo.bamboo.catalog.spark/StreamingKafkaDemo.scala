package com.bamboo.demo.catalog.spark
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}
import org.apache.spark._


object StreamingKafkaDemo {
  
  def main(args: Array[String]) {

    var master = "spark://spark114:7077"
    var appName = "demoCatalog"
    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val ssc = new StreamingContext(conf, Seconds(1))

    val kafkaParams = Map[String, Object](
        "bootstrap.servers" -> "kafka100:9092",
        "key.deserializer" -> classOf[StringDeserializer],
        "value.deserializer" -> classOf[StringDeserializer],
        "group.id" -> "demo",
        "auto.offset.reset" -> "latest",
        "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("demo")
    
    val stream = KafkaUtils.createDirectStream[String, String](
        streamingContext,
        PreferConsistent,
        Subscribe[String, String](topics, kafkaParams)
    )
    
    stream.map(record => (record.key, record.value))
    stream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}