package net.projecteuler

import org.scalatest.{Matchers, WordSpec}

/**
  * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  **
  * a^2 + b^2 = c^2
  * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
  **
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  * Find the product abc.
  */
class SpecialPythagoreanTripletSpec extends WordSpec with Matchers {

  "A pythagorean triplet finder" should {

    "return true" when {

      "a = 3, b = 4" in {

        val isPythagoreanTriplet = SpecialPythagoreanTripletFinder.isPythagoreanTriplet(3, 4, 5)

        isPythagoreanTriplet should be (true)

      }

    }

    "find a, b and c" when {

      "expected sum is 1000" in {

        val triplet = SpecialPythagoreanTripletFinder.findPythagoreanTripletThatSums(1000)

        triplet should be (List(200.0, 375.0, 425.0))

      }

      "expected multiplication of a, b and c where its sum is 1000" in {

        val result = SpecialPythagoreanTripletFinder.multiplyPythagoreanTripletThatSums(1000)

        result should be (31875000)

      }

    }

  }

}
