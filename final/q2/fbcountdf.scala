import org.apache.spark.sql.{Dataset, DataFrame, SparkSession, Row}
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.functions._

object FBCount {

	def getFBCount(spark: df[(String, String)]) = {
		List((left),(right)
		val mydataset = mydf.as[FBCount]
		val mySchema = new StructType().add("List", StringType,true)
		val df = spark.saprkContext.textFile("/datasets/facebook").schema(mySchema).map{x => x.split(" ")}
		val length = df.map{x => x.length}
		val filter_df = length.filter{x => (x(right)>500) => (x(left)=1 }
		val myval = sum(length)
		val filter_myval = myval.filter{x => (x>2) => (x(left) = myval+1)}
		val mydf = df.parallelize(left,right)
		mydf		
	}

}
