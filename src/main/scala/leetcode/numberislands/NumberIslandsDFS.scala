package leetcode.numberislands

import utils.Assert._

import scala.collection.mutable.ArrayBuffer

/**
 * @author vvinnyk on 3/28/20.
 */
object NumberIslandsDFS extends BaseNumberIslands {

  private def dfs(grid: ArrayBuffer[ArrayBuffer[Char]], r: Int, c: Int): Unit = {
    val rowLength = grid.length
    val columnLength = grid(0).length

    if (r < 0 || r >= rowLength || c < 0 || c >= columnLength || grid(r)(c) == '0')
      return

    grid(r)(c) = '0'
    dfs(grid, r, c - 1)
    dfs(grid, r, c + 1)
    dfs(grid, r - 1, c)
    dfs(grid, r + 1, c)
  }

  protected def numIslandsImpl(grid: ArrayBuffer[ArrayBuffer[Char]]): Int = {
    var counter = 0
    for (
      (a, i) <- grid.zipWithIndex;
      (_, j) <- a.zipWithIndex
    ) yield {
      if (grid(i)(j) == '1')
        counter += 1
      dfs(grid, i, j)
    }
    counter
  }

}
