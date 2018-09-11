name := "Spark Kafka Project"
version := "1.0"
scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.3.1",
    "org.apache.spark" %% "spark-streaming" % "2.3.1",
    "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.3.1"
)

mergeStrategy in assembly := {
  case PathList("org", "apache", "spark", "unused", "UnusedStubClass.class") => MergeStrategy.first
  case x => (mergeStrategy in assembly).value(x)
}