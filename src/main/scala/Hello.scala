import org.apache.spark.{SparkConf, SparkContext}

object Hello {

    def main(args: Array[String]) {
      println("Hello World")

      val conf = new SparkConf()
        .setAppName("OT2BDataPrep")
      //.setMaster("local")
      val sc = new SparkContext(conf)
      val sqlCtx = new org.apache.spark.sql.hive.HiveContext(sc)
      import sqlCtx.implicits._

      //Read some example file to a test RDD
      val test = sc.textFile("input.txt")
      println("No of lines=",test.count());

      val masterDataDate=sqlCtx.sql("SELECT DATE_ID FROM   MASTER_DATA.DATE_DIM WHERE DATE_ID BETWEEN '2017-07-17' AND '2017-08-17'");
      val recCnt=masterDataDate.count();
      println("No of records in dataframe"+recCnt);
}

}
