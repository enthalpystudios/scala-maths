package net.projecteuler.largestproduct

/**
  * Created by mfernandesrodr on 13/05/2016.
  */
object GridCompassExtractor {

  val compass = List(
    (-1, 0), // NORTH
    (1, 0), // SOUTH
    (0, -1), // WEST
    (0, 1), // EAST
    (1, 1), // SOUTH EAST
    (1, -1), // SOUTH WEST
    (-1, 1), // NORTH EAST
    (-1, -1) // NORTH WEST
  )

  def extract(longitude: Seq[Int])(point: (Int, Int)): Seq[Seq[(Int, Int)]] = {
    compass.map(cardinalDirection =>
      longitude.flatMap(generateNewPoint(cardinalDirection, point))
    )
  }

  def generateNewPoint(cardinalDirection: (Int, Int), point: (Int, Int))(longitudeStep: Int): Seq[(Int, Int)] = {
    Seq((point._1 + longitudeStep * cardinalDirection._1, point._2 + longitudeStep * cardinalDirection._2))
  }

}

