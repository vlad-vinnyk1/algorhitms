package leetcode.rottenoranges

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * @author vvinnyk on 3/29/20.
 */
object RottenOranges {

  private def toBuffer(grid: Array[Array[Int]]): ArrayBuffer[ArrayBuffer[Int]] = {
    val res = ArrayBuffer[ArrayBuffer[Int]]()
    grid.foreach(arr => res += ArrayBuffer(arr: _*))

    res
  }

  private def find(grid: ArrayBuffer[ArrayBuffer[Int]], el: Int): ArrayBuffer[(Int, Int)] = {
    val res = for (
      (rows, rowIndex) <- grid.zipWithIndex;
      (element, columnIndex) <- rows.zipWithIndex
      if element == el
    ) yield (rowIndex, columnIndex)

    res
  }

  private def getFreshIfValidCoordinates(grid: ArrayBuffer[ArrayBuffer[Int]], row: Int, column: Int): Option[(Int, Int)] =
    if (row >= 0 && row < grid.length &&
      column >= 0 && column < grid(row).length &&
      grid(row)(column) == 1) Some(row, column)
    else {
      None
    }

  def orangesRotting(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) {
      return -1
    }
    val gridBuffer = toBuffer(grid)
    val rottedArray = find(gridBuffer, 2).toArray
    if (rottedArray.isEmpty) {
      if (find(gridBuffer, 1).nonEmpty) return -1 else return 0
    }
    val queue = mutable.Queue[(Int, Int)](rottedArray: _*)
    var counter = -1
    while (queue.nonEmpty) {
      val thisLayer: Array[(Int, Int)] = queue.dequeueAll(_ => true).toArray
      counter += 1
      thisLayer.foreach { entry =>
        val (row, column) = entry
        val element = gridBuffer(row)(column)
        if (element == 2) {
          List(
            getFreshIfValidCoordinates(gridBuffer, row - 1, column),
            getFreshIfValidCoordinates(gridBuffer, row + 1, column),
            getFreshIfValidCoordinates(gridBuffer, row, column - 1),
            getFreshIfValidCoordinates(gridBuffer, row, column + 1)
          ).foreach { coordinateOption =>
            coordinateOption.foreach { coordinate =>
              gridBuffer(coordinate._1)(coordinate._2) = 2
              queue.enqueue(coordinate)
            }
          }
        }
      }
    }
    if (find(gridBuffer, 1).nonEmpty) -1 else counter
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(
      Array(2, 1, 1),
      Array(1, 1, 0),
      Array(0, 1, 1)
    )

    val grid2 = Array(
      Array(2, 1, 1),
      Array(0, 1, 1),
      Array(1, 0, 1)
    )

    val grid3 = Array(
      Array(0, 2)
    )

    val grid4 = Array(
      Array.empty[Int]
    )
    val grid5 = Array(
      Array(0)
    )
    val grid6 = Array(
      Array(1)
    )

    val grid7 = Array(
      Array(2, 2, 2, 1, 1)
    )
    println(orangesRotting(grid))
//    println(orangesRotting(grid2))
//    println(orangesRotting(grid3))
//    println(orangesRotting(grid4))
//    println(orangesRotting(grid5))
//    println(orangesRotting(grid6))
//    println(orangesRotting(grid7))
  }

}