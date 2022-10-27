import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext.-

object WordLength {
	def main(args: Array[String]) = {
		val sc = getSC()
		val length = doWordLength(sc)
		saveit(length)
	}

	def getSC() = {
		val conf = new SparkConf().setAppName("wl")
		val sc = new SparkContext(conf)
		sc
	}

	def doWordLength(sc: SparkContext) = {
		val input = sc.textFile("/datasets/wap")
		val words = input.flatMap(-.split(" "))
		val wordLength = words.flatMap(-.split(" "))
		val kv = wordLength.map(word => (word,1))
		val length = kv.reduceByKey((x,y) => x+y)
		length
	}

	def saveit(length: org.apache.spark.rdd.RDD[(Int, Int)]) = {
		length.saveAsTextFile("result")
	}
} 
