/*
* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
* Find the largest palindrome made from the product of two 3-digit numbers.
*/

import scala.collection.immutable.IndexedSeq

def isPalindrome(text: String) : Boolean = {
  (for {
    i <- 0 to text.length / 2
    isSame = text.charAt(i) == text.charAt(text.length -1 - i)
  } yield isSame).reduce(_ && _)
}

def products(lowerBound: Int, upperBound: Int) : IndexedSeq[Int] = {
  for {
    x <- lowerBound to upperBound
    y <- x to upperBound
  } yield x * y
}

val maxPalindrome = products(100, 999)
  .filter(n => isPalindrome(n.toString))
  .max
