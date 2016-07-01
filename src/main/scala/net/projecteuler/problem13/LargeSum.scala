package net.projecteuler.problem13

/**
  * Created by mfernandesrodr on 10/06/2016.
  */
object LargeSum {
  def sum(number: String): String = {
    number
      .sliding(50,50)
      .map(n => BigInt(n))
      .foldLeft(BigInt(0))(_.+(_))
      .toString()
  }

}
