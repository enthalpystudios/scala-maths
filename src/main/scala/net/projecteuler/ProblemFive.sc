/*
* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
* What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

def smallestDivisibleBy(numbers: List[Int]): Option[Int] = {

  def isDivisible(number: Int, by: Int): Boolean = number % by == 0

  def loop(number : Int): Option[Int] = {
    val nonDivisibleOfNumber = numbers.filterNot(n => isDivisible(number, n))
    if (nonDivisibleOfNumber.isEmpty)
      Some(number)
    else
      if (number == Integer.MAX_VALUE)
        None
      else
        loop(number + 1)
  }

  loop(numbers.max)

}


smallestDivisibleBy((1 to 20).toList)