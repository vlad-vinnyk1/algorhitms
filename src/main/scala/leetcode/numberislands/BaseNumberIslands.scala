package leetcode.numberislands

import scala.collection.mutable.ArrayBuffer

/**
 * @author vvinnyk on 3/28/20.
 */
trait BaseNumberIslands {
  protected def toBuffer(grid: Array[Array[Char]]): ArrayBuffer[ArrayBuffer[Char]] = {
    val res = ArrayBuffer[ArrayBuffer[Char]]()
    grid.foreach(arr => res += ArrayBuffer(arr: _*))

    res
  }

  protected def numIslandsImpl(grid: ArrayBuffer[ArrayBuffer[Char]]): Int

  def numIslands(grid: Array[Array[Char]]): Int = {
    numIslandsImpl(toBuffer(grid))
  }
}
