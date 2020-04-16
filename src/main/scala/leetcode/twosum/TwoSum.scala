package leetcode.twosum

import scala.collection.mutable

/**
 * @author vvinnyk on 3/27/20.
 */
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val set = mutable.Set[Int]()
    val moreThanOnce = mutable.Set[Int]()
    nums.foreach(n => if(set.contains(n)) moreThanOnce.add(n) else set.add(n))

    var result: Array[Int] = Array.empty
    nums.indices.foreach { index =>
      val thisElem = nums(index)
      val expected = target - thisElem
      if (set.contains(expected) && expected != thisElem || moreThanOnce.contains(expected)) {
        result = Array(index, nums.indexOf(expected))
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2, 7, 11, 15), 9))
  }

}
