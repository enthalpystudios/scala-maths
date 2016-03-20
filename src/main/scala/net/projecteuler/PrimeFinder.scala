package net.projecteuler

/*
* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
* What is the 10 001st prime number?
*/
object PrimeFinder {

  private def factorsOf(number: Int, primes: List[Int]): Seq[Int] = {
    primes
      .filter( n => n < number)
      .filter( n => number % n == 0)
  }

  private def isPrime(number: Int, primes: List[Int]): Boolean = {
    factorsOf(number, primes) == List.empty
  }

  def findNth(nth: Int): Int = {

    def nextPrime(n: Int, primes: List[Int]): Int = {
      if (isPrime(n, primes)) {
        if (primes.length == nth)
          primes.head
        else
          nextPrime(n + 1, n :: primes)
      }
      else
        nextPrime(n + 1, primes)
    }

    nextPrime(2, List())

  }

}
