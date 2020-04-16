package leetcode.mergeintervals

import scala.collection.mutable.ArrayBuffer

/**
 * @author vvinnyk on 4/4/20.
 */
object BruteMergeIntervals {

  def mergeTwo(thisInterval: Array[Int], bufferedInterval: Array[Int]): ArrayBuffer[Array[Int]] = {
    if (bufferedInterval(1) >= thisInterval(0)) {
      val start = Math.min(thisInterval(0), bufferedInterval(0))
      val end = Math.max(thisInterval(1), bufferedInterval(1))
      ArrayBuffer(Array(start, end))
    } else {
      ArrayBuffer(bufferedInterval, thisInterval)
    }
  }

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val merged = ArrayBuffer[Array[Int]]()
    val sortedIntervals = intervals.sortBy(interval => interval(0))
    var idx = 0
    while (idx < sortedIntervals.length) {
      val thisInterval = sortedIntervals(idx)
      if (merged.isEmpty) {
        merged += thisInterval
      } else {
        merged ++= mergeTwo(thisInterval, merged.remove(merged.length - 1))
      }
      idx += 1
    }

    merged.toArray
  }

  def main(args: Array[String]): Unit = {
    val a = Array(Array(15, 18), Array(2, 6), Array(1, 3), Array(8, 10))
    printGyu(a)

    println("-----------------------------------------------")

    printGyu(Array(Array(1, 4), (Array(4, 5))))
  }

  private def printGyu(a: Array[Array[Int]]) = {
    for (interval: Array[Int] <- merge(a)) {
      println(interval(0) + " ======>>>>> " + interval(1))
    }
  }
}
