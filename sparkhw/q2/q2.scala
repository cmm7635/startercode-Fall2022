import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object Q2 extends App {
  def main(args: Array[String]) = {
    val sc = getSC()
    val input = getRDD(sc)
    val hCount = hubAirport(input)
    saveit(hCount) 
  }

  def getSC() = {
    val conf = new SparkConf().setAPPName("Q2")
    val sc = new SparkContent(conf)
    sc
  }

  def getRDD(sc: SparkContext) = {
    val input = sc.textFile("/datasets/flight")
    input
  } 

  def hubAirport(input: RDD[String]) = {
      val flights = sc.textfile("/datasets/flight")
      val noheader = flights.filter{line => !line.startsWith("ITIN_ID")}
      val records = noheader.map{x => x.split(",")}
      val outgoing = records.map{record => (records(3), -record(7).toFloat)}
      def zeroVal = (0.0,0.0)
      def func = (state: (Float, Float), v: (Float, Float)) = state._1 + v._1, state._2 + v._2)
      val result = both.aggregateByKey(zeroVal)(func, func)
      val hCount = result.filter{case (airport, outgoing) => outgoing >= y}
      hCount
    }

  def saveit(hCount: org.apache.spark.rdd.RDD[(String, Int)} = {
      hCount.saveAsTextFile(result, "sparkhw-q2")
  }

  val cmd_arg = args(0)
}
