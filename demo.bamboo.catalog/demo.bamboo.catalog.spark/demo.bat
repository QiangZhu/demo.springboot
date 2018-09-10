::#! 
@echo off 
call scala %0 %* 
goto :eof 
::!#

import java.util.regex.{Matcher, Pattern}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}
import kafka.serializer.StringDecoder
import org.apache.spark.streaming.kafka._


object StreamingKafkaWeblog {

  def apacheLogPattern():Pattern = {
    val ddd = "\\d{1,3}"
    val ip = s"($ddd\\.$ddd\\.$ddd\\.$ddd)?"
    val client = "(\\S+)"
    val user = "(\\S+)"
    val dateTime = "(\\[.+?\\])"
    val request = "\"(.*?)\""
    val status = "(\\d{3})"
    val bytes = "(\\S+)"
    val referer = "\"(.*?)\""
    val agent = "\"(.*?)\""
    val regex = s"$ip $client $user $dateTime $request $status $bytes $referer $agent"
    Pattern.compile(regex)
  }

  def main(args: Array[String]) {

    // Logger.getLogger("org").setLevel(Level.ERROR)


    // Create the context with a 1 second batch size
    val ssc = new StreamingContext("local[*]", "KafkaStreamingDemo", Seconds(1))

    val kafkaParams = Map("metadata.broker.list" -> "kafka100:9092")
    val topics = List("demo").toSet
    val lines = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc,
      kafkaParams, topics).map(_._2)

    // val pattern = apacheLogPattern()
    //val requests = lines.map(x => {val matcher:Matcher = pattern.matcher(x); if (matcher.matches()) matcher.group(5)})
    // val urls = requests.map(x => {val arr = x.toString().split(" "); if (arr.size == 3) arr(1) else "[err]"})

    // Reduce by URL over a 5-minute window sliding every second, reduce and reverse reduce as url leaves sliding window
    // val urlCounts = urls.map(x => (x, 1)).reduceByKeyAndWindow(_ + _, _ - _, Minutes(5), Seconds(1))
    // val sortedResults = urlCounts.transform(rdd => rdd.sortBy(x => x._2, false))

    //print out top 10
    // sortedResults.print()
    
    val replacedData = data.getLines().map(_.split(",")).map(array => array.init.mkString(",")+",")
    new PrintWriter("path to output file"){write(replacedData.mkString("\n")); close}


    ssc.checkpoint("./checkpoint")
    ssc.start()
    ssc.awaitTermination()
  }
}

StreamingKafkaWeblog.main(args)