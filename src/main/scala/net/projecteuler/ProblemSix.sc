/*
* The sum of the squares of the first ten natural numbers is,
* 12 + 22 + ... + 102 = 385
* The square of the sum of the first ten natural numbers is,
* (1 + 2 + ... + 10)2 = 552 = 3025
* Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
* Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/



def differenceOfSquares(naturalNumbers: Seq[Int]) : Int = {

  def square(n: Int) : Int = n * n
  def squares : Seq[Int] = naturalNumbers.map(square)

  square(naturalNumbers.sum) - squares.sum
}

differenceOfSquares((1 to 100))

