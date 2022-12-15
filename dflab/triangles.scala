import org.apache.spark.sql.{Dataset, DataFrame, SparkSession, Row}
import org.apache.spark.sql.catalyst.expressions.aggregate._
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.functions._

object DFlab {

    def getTestDataFrame(spark) = {
      List((1,2,3), (4,5,6)).toDF("a", "b", "c")
      val myseq = List.tabulate(20){x => Row(s"row$x", x*x.toLong)}
      val mySchema = new StructType().add("List", StringType, true)
      val df = spark.sparkContext.textFile("/datasets/facebook").schema(mySchema).map{x => x.trim()}.map{x => x.split(" ")}
      val length = df.map{x => x.length}
      val filter_len = length.filter{x => x!=2}
      val num = filter_len.count()
      num != 0             
    }

    def is_redundsnt(fb: df[(String, String)]): Boolean = {
      val clean_df = df.distinct()
      val flipped = clean_df.map{case (a,b) => (b, a}
      val common = flipped.intersection(clean_df)
      val count_org = clean_df.count()
      val count_common = common.count()
      count_org == count_common
    }

    def to_non_redundant(fb: df[(String, String)]): df[(String, String)] = {
      val result = df.filter{case (a,b) => a < b}.distinct()
      result
    }

}

YOOOOOOOOOOOOOOOOOOOOO
~
