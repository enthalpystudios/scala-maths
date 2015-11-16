import scala.collection.immutable.IndexedSeq
import Math._
/*
* The prime factors of 13195 are 5, 7, 13 and 29.
* What is the largest prime factor of the number 600851475143 ?
*/

def factors(i: Long) : IndexedSeq[Long] = {
  (1L to sqrt(i).toLong).filter(n => i % n == 0)
}

def isPrime(i: Long): Boolean = {
  factors(i).diff(List(1, i)).isEmpty
}

factors(600851475143L).filter(isPrime).max


