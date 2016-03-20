package net.projecteuler

import org.scalatest.{Matchers, WordSpec}

/*
* Problem 8
* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
* What is the 10 001st prime number?
*/
class FindNthPrimeSpec extends WordSpec with Matchers {

  "Nth prime finder" should {

    "return 13" when {

       "asked for the 6th prime" in {
         val result = PrimeFinder.findNth(6)

         result should be (13)
       }

    }

    "return 104743" when {

      "asked for the 10001th prime" in {
        val result = PrimeFinder.findNth(10001)

        result should be (104743)
      }

    }

    "return 2 and make everyone cry" when {

      "asked for the 1st prime" in {
        val result = PrimeFinder.findNth(1)

        result should be (2)
      }

    }

  }

}
