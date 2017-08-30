name := "ScalaDemo"

version := "0.1"

scalaVersion := "2.10.6"
//val sparkVer = "1.6.0-cdh5.9.0"
val sparkVer = "1.6.1"
val sparkLibScope = "compile"

//resolvers +="Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

libraryDependencies ++= {
  Seq(
   // "org.apache.spark" %% "spark-core" % sparkVer  withSources(),
  "org.apache.spark" %% "spark-core" % sparkVer ,
  "org.apache.spark" %% "spark-sql" % sparkVer ,
  "org.apache.spark" %% "spark-hive" % sparkVer
  )
}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
        