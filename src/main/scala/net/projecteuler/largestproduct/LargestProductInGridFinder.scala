package net.projecteuler.largestproduct

/**
  * Created by mfernandesrodr on 13/05/2016.
  */
class LargestProductInGridFinder(grid: Map[(Int, Int), Int], size: Int) {

  def findLargest(): Int = {
    grid.flatMap(coordinate =>
      calculateProductForCoordinates(coordinate._1)
    ).max
  }

  private def getCompassCoordinatesForPoint = GridCompassExtractor.extract(0 until size) _
  private def calculateCoordinatesProduct = CoordinatesProductCalculator.calculate(grid) _

  private def calculateProductForCoordinates(point: (Int, Int)): Seq[Int] = {
    val compassCoordinatesForPoint = getCompassCoordinatesForPoint(point)
    calculateCoordinatesProduct(compassCoordinatesForPoint)
  }


}
