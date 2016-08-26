package net.projecteuler.problem14

/**
  * The following iterative sequence is defined for the set of positive integers:
  **
  *n → n/2 (n is even)
  *n → 3n + 1 (n is odd)
  **
  *Using the rule above and starting with 13, we generate the following sequence:
  **
  *13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
*It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
  **
 *Which starting number, under one million, produces the longest chain?
  **
 *NOTE: Once the chain starts the terms are allowed to go above one million.
  *
  *
  * Implemented this using memoization so it can be faster
  */
class LongestCollatzSequence {

  var collatzCache = Map[Double, List[Double]]()

  def findLongestCollatzSequeceFrom(from: Int): CollatzSequenceInfo = {
    var collatzSequenceInfo = CollatzSequenceInfo(0, 0)
    (1 to from).foreach { n =>
      val sequence: List[Double] = memoize(collatzSequence(n))
      if (sequence.size > collatzSequenceInfo.size)
        collatzSequenceInfo = CollatzSequenceInfo(sequence.head, sequence.size)
    }
    collatzSequenceInfo
  }

  private def memoize(collatzSequence: List[Double]): List[Double] = {
    if (collatzSequence.nonEmpty) {
      def loop(head: Double, tail: List[Double]): Any = {
        if (tail.nonEmpty) {
          if (!collatzCache.contains(head))
            collatzCache = collatzCache + (head -> tail)
          loop(tail.head, tail.tail)
        }
      }
      loop(collatzSequence.head, collatzSequence.tail)
    }
    collatzSequence
  }

  def collatzSequence(starting: Double): List[Double] = {

    def loop(n: Double, collatzSequence: List[Double]): List[Double] = {
      if (n <= 1)
        collatzSequence :+ 1d
      else if (collatzCache.contains(n))
        (collatzSequence :+ n) ::: collatzCache.getOrElse(n, List())
      else
        if (n % 2 == 0)
          loop(n / 2, collatzSequence :+ n)
        else
          loop(n * 3 + 1, collatzSequence :+ n)
    }

    loop(starting, List[Double]())

  }

}

case class CollatzSequenceInfo(number: Double, size: Double)
