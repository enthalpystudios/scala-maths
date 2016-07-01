package net.projecteuler.problem12

import java.lang.Math._

object HighlyDivisibleTriangleNumberFinder {

  def containingNumberOfDivisors(numberOfDivisors: Int): Int = {

    def loop(n: Int, nth: Int, current: Int): Int = {

      if (n % 100 == 0)
        println(current + " " + n)

      if (current > numberOfDivisors)
        nth
      else {
        val newN = n + 1
        val newNth = find(newN)
        loop(newN, newNth, countFactors(newNth))
      }
    }

    loop(0, 0, 0)

  }

  def find(nth: Int) : Int = {
    (1 to nth).sum
  }

  def factorsOf(nth: Int): List[List[Int]] = {
    (1 to nth).map( n => factors(find(n))).toList
  }

  def countFactors(i: Int) : Int = {
    (1 to i).count(n => i % n == 0)
  }

  def factors(i: Int) : List[Int] = {
    (1 to i).filter(n => i % n == 0).toList
  }

}
