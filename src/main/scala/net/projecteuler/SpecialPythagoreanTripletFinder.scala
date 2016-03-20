package net.projecteuler

/**
  * Created by mrodrigues on 20/03/2016.
  */
object SpecialPythagoreanTripletFinder {

  def multiplyPythagoreanTripletThatSums(total: Int): Long = findPythagoreanTripletThatSums(total).foldLeft(1.0)((a, b) => a * b).toLong

  def findPythagoreanTripletThatSums(total: Int): List[Double] = {

    def findPythagoreanTriplet(a: Int, b: Int): List[Double] = {
      val c = findC(a, b)
      if (sumTriplet(a, b, c) == total && isPythagoreanTriplet(a, b, c))
        List(a, b, findC(a, b))
      else
        if (b > total / 2)
        List()
        else
          findPythagoreanTriplet(a, b + 1)
    }

    (1 to total/2).map(a => findPythagoreanTriplet(a, a + 1)).filterNot(s => s.isEmpty).flatten.toList

  }

  def findC(a: Double, b: Double): Double = Math.round(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)))

  def isPythagoreanTriplet(a: Double, b: Double, c: Double): Boolean = {
    Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
  }

  def sumTriplet(a: Double, b: Double, c: Double): Double = a + b + c


}
