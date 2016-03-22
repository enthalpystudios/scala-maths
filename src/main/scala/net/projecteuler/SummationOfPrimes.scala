package net.projecteuler

/**
  * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  **
  *Find the sum of all the primes below two million.
  */
class SummationOfPrimes(maxPrimeUpTo: Long) {

  private def factorsOf(number: Long): List[Int] = {
    (2 to Math.sqrt(number).toInt)
      .filter(n => number % n == 0).toList
  }

  private def isPrime(number: Long): Boolean = {
    factorsOf(number).isEmpty
  }

  def sum(): Long = {

    def findPrimes(number: Long, primes: List[Long]): List[Long] = {
      if (number >= maxPrimeUpTo)
        primes
      else if (isPrime(number))
        findPrimes(number + 1, number :: primes)
      else
        findPrimes(number + 1, primes)
    }

    findPrimes(3, List(2)).sum

  }


}
