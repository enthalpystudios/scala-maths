package net.projecteuler


class LargestProductInSeries(number: String, size: Int) {


  def largest(): Long = {

    def findLargest(nth: Int, largest: Long): Long = {
      def larger(multiply: Long): Long = {
        if (multiply > largest) multiply else largest
      }

      if (nth >= number.length - size)
        largest
      else {
        val multiply = multiplyNth(nth + 1)
        findLargest(nth + 1, larger(multiply))
      }
    }

    findLargest(0, multiplyNth(0))

  }

  def multiplyNth(nth: Int): Long = {
    val adjacentDigits: String = adjacent(nth)
    adjacentDigits.map(l => l.asDigit.toLong).foldLeft(1L)((a,b) => a * b)
  }

  def adjacent(nth: Int): String = {
    number.drop(nth).take(size)
  }


}
