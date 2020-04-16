package leetcode.besttimetobuy

/**
 * @author vvinnyk on 4/4/20.
 */
object BestTimeToBuyStock {

  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) {
      return 0
    }

    var res = 0
    var rightMax = 0

    for (i <- prices.length - 1 to 0 by - 1) {
      val thisElement = prices(i)
      rightMax = Math.max(rightMax, thisElement)
      res = Math.max(rightMax - thisElement, res)
    }

    res
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
    println(maxProfit(Array(7, 6, 4, 3, 1)))
  }

}
