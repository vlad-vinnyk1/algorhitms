package leetcode.productofarrayexeptself

/**
 * @author vvinnyk on 3/30/20.
 */
object ProductExceptSelf {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val res = Array.ofDim[Int](nums.length)
    res(0) = 1
    for (i <- 1 until nums.length) {
      res(i) = res(i - 1) * nums(i - 1)
    }

    var buffer = 1
    for (i <- nums.length - 2 to 0 by -1) {
      buffer *= nums(i + 1)
      res(i) *= buffer
    }

    res
  }

  def main(args: Array[String]): Unit = {
    println(productExceptSelf(Array(1, 2, 3, 4)).mkString(","))
  }
}
