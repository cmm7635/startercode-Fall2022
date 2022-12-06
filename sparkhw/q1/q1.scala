import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object Q1 extends App {
  def main(args: Array[String]) = {
    val sc = getSC()
    val input = getRDD(sc)
    val pCount = popularAirport(input)
    saveit(pCount) 
  }

  def getSC() = {
    val conf = new SparkConf().setAPPName("Q1")
    val sc = new SparkContent(conf)
    sc
  }

  def getRDD(sc: SparkContext) = {
    val input = sc.textFile("/datasets/flight")
    input
  } 

  def popularAirport(input: RDD[String]) = {
      val flights = sc.textfile("/datasets/flight")
      val noheader = flights.filter{line => !line.startsWith("ITIN_ID")}
      val records = noheader.map{x => x.split(",")}
      val outgoing = records.map{record => (records(3), -record(7).toFloat)}
      val incoming = records.map{record => (records(5), record(7).toFloat)}
      val count = incoming - outgoing
      def zeroVal = (0.0,0.0)
      def func = (state: (Float, Float), v: (Float, Float)) = state._1 + v._1, state._2 + v._2)
      val result = both.aggregateByKey(zeroVal)(func, func)
      val pCount = result.filter{case (airport, (incoming, outgoing)) => count >= x}
      pCount
    }

  def saveit(pCount: org.apache.spark.rdd.RDD[(String, Int)} = {
      pCount.saveAsTextFile(result, "sparkhw-q1")
  }

  val cmd_arg = args(0)
}
