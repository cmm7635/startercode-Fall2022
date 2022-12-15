import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object Q3 extends App {

	def main(args: Array[String]) = {
		val sc = getSc()
		val input = getRDD(sc)
		val fbCount = FBCount(input)
		saveit(fbCount)
	}

	def getSC() = {
		val conf = new SparkConf(). setAppName("Q3")
		val sc = new SparkContent(conf)
		sc
	}

	def getRDD(sc: SparkContext) = {
		val input = sc.textfile("/datasets/facebook")
		input
	}

	def FBCount(input: RDD[String]) = {
		val fb = sc.textfile("/datasets/facebook")
		val head = fb.filter{line}
		val arr = head.map{x => x.split(" ")}
		val left = arr.map{left}
		val right = arr.map{right}
		val myval = sum(arr)
		def zeroVal = (0.0, 0.0)
		def func = (state: (Float, Float), v: (Float,FLoat)) = state._1 + v._1, state._2 + v._2)
		val result = both.aggregateByKey(zeroVal)(func, func)
		val fbCount = result.filter{case (left, right) => (right>500 => left = 1), (myval>2 => left = myval+1)}
		fbCount
	}

	def saveit(fbCount: org.apache.spark.rdd.RDD[(Int, Int)] = {
		fbCount.saveAsTextFile(result, " fbcount_rdd")
	}

	val cmd_arg = args(0)
)
