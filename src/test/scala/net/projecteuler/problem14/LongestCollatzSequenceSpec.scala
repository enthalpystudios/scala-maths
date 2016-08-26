package net.projecteuler.problem14

import org.scalatest.{Matchers, WordSpec}

/**
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
  */
class LongestCollatzSequenceSpec extends WordSpec with Matchers  {

  "Collatz Sequence" should {
    "return 10 numbers" when {

      "called with first number as 13" in {

        val expectedCollatzSequence = List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)

        val collatzSequence = new LongestCollatzSequence().collatzSequence(13)

        collatzSequence should be(expectedCollatzSequence)

      }

    }

    "return 20 numbers" when {

      "called with first number as 9" in {

        val expectedCollatzSequence = List(9, 28, 14, 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1)

        val collatzSequence = new LongestCollatzSequence().collatzSequence(9)

        collatzSequence should be(expectedCollatzSequence)

      }

    }

    "return 9 as the longest sequence for numbers starting in 13" when {

      "asked for the number with the longest sequence starting with 13" in {

        val collatzSequence: CollatzSequenceInfo = new LongestCollatzSequence().findLongestCollatzSequeceFrom(13)

        collatzSequence should be(CollatzSequenceInfo(9, 20))

      }

    }

    "return x as the longest sequence for numbers starting in y" when {

      "asked for the number with the longest sequence starting with 1000000" in {

        val collatzSequence: CollatzSequenceInfo = new LongestCollatzSequence().findLongestCollatzSequeceFrom(1000000)

        collatzSequence should be(CollatzSequenceInfo(837799, 525))

      }

    }

  }

}
