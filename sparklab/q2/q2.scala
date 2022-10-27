import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object specificWordLength {
	def main(args: Array[String]) = {
		val sc = getSC()
		val length = doSpecificWordLength(sc)
		saveit(length)
	}

	def getSC() = {
		val conf = new SparkConf().setAppName("swl")
		val sc = new SparkContext(conf)
		sc
	}

	def doSpecificWordLength(sc: SparkContext) = {
		val input = sc.tetxFile("/datasets/wap")
		val words = input.flatMap(-.split(" "))
		val wordLength = words.flatMap(-.split(" "))
		val kv = wordLength.map(word => (word,1))
		val length = kv.reduceByKey((x,y) => x+y>1)
		length
	}
	
	def saveit(length: org.apache.spark.rdd.RDD[(Int, Int)]) = {
		length.saveAsTextFile("result")
	}
}
