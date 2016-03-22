package net.projecteuler

import org.scalatest.{Matchers, WordSpec}

class SummationOfPrimesSpec extends WordSpec with Matchers {

  "The sum of Primes" should {

    "return 17" when {

      "primes are less than 10" in {

        val summationOfPrimes = new SummationOfPrimes(10)

        val result = summationOfPrimes.sum()

        result should be (17)

      }

      "primes are less than 2.000.000" in {

        val summationOfPrimes = new SummationOfPrimes(2000000)

        val result = summationOfPrimes.sum()

        result should be (142913828922L)

      }


    }

  }

}
