package net.projecteuler.largestproduct

/**
  * Created by mfernandesrodr on 13/05/2016.
  */
object CoordinatesProductCalculator {

  def calculate(grid: Map[(Int, Int), Int])(compassCoordinates: Seq[Seq[(Int, Int)]]): Seq[Int] = {
    compassCoordinates.map(multiplyCompassCoordinates(grid))
  }

  private def multiplyCompassCoordinates(grid: Map[(Int, Int), Int])(coords: Seq[(Int, Int)]): Int = {
    coords.map(grid.getOrElse(_, 1)).product
  }

}
