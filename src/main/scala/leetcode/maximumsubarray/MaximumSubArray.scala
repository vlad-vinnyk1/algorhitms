package leetcode.maximumsubarray

/**
 * @author vvinnyk on 3/29/20.
 */
object MaximumSubArray {

  def maxProduct(nums: Array[Int]): Int = {
    var max = nums(0)
    var bestMin = nums(0)
    var bestMax = nums(0)
    for (i <- 1 until nums.length) {
      val element = nums(i)
      val maxA = Math.max(bestMax * element, element)
      val maxB = Math.max(bestMin * element, element)

      val mina = Math.min(bestMax * element, element)
      val minB = Math.min(bestMin * element, element)

      bestMax = Math.max(maxA, maxB)
      bestMin = Math.min(mina, minB)
      max = Math.max(bestMax, max)
    }
    max
  }


  def maxSubArray(nums: Array[Int]): Int = {
    var max = nums(0)
    var bestPrev = nums(0)
    for (i <- 1 until nums.length) {
      val element = nums(i)
      bestPrev = Math.max(bestPrev + element, element)
      max = Math.max(bestPrev, max)
    }
    max
  }

  def main(args: Array[String]): Unit = {
    //    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    //    println(maxSubArray(Array(1)))


    println(maxProduct(Array(2, 3, -2, 4)))
    println(maxProduct(Array(-2, 0, -1)))
    println(maxProduct(Array(-2, 3, -4)))
  }
}
