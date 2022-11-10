case class Neumaier(sum: Double, c: Double)

object HW {

   def q1_countsorted(x: Int, y: Int, z:Int) = {
      val n = 0
      if x < y {
      	n++
      }

      elif y < z {
	n++
      }

      elif x < z (
	n++
      }

      println(n)
      -1
   }

   def q2_interpolation(name: String, age: Int) = {
      if age < 21 {
	val ans = ("howdy",name)
      }

      else {
	val ans = ("hello",name)
      }

      return ans
      ""
   }

   def q3_polynomial(arr: Seq[Double]) = {
      val x = 0.0
      for x in arr:
	val y = arr.foldLeft(x)(_+_)
      
      println(y)
      0.0
   }

   def q4_application(x: Int, y: Int, z: Int)(f: (Int, Int) => Int) = {
      f: (x,y) => a
      f: (a,z) => b
      
      println(b) 
      1
   }

   def q5_stringy(start: Int, n: Int): Vector[String] = {
      val i = 0
      Vector.tabulate(n)(i => (start + i).toString
      
      println(i)

   }

   def q6_modab(a: Int, b: Int, c: Seq[Int]) = Seq[Int]{
      val x = c.filter(_<a)
      val y = x.filter(b%_!=0)
      
      println(y)
   }

   def q7_count(arr: Vector[Int])(f: (Int, Int) => Boolean) = {
      

   }

   def q8_count_tail(arr: Vector[Int])(f: (Int, Int) => Boolean) {

   }

   def q9_neumaier() {
      var sum = 0.0
      var c = 0.0
      
      for i = 1 to input.length do
	var t = sum + input[i]
      
      if |sum| >= |input[i]| then
        c += (sum - t) + input[i]
      
      else
        c += (input[i] - t) + sum 
      
      endif
        sum = t

      val x = arr.foldLeft(i)(c+sum)

      println(x)
   }
}
