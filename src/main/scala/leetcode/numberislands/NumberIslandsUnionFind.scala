package leetcode.numberislands

import scala.collection.mutable.ArrayBuffer

case class UnionFind(n: Int) {

  val parents: Array[Int] = (0 until n).toArray
  val ranks: Array[Int] = Array.fill(n)(0)
  var count: Int = 0

  def count(grid: ArrayBuffer[ArrayBuffer[Char]]): Unit = {
    grid.foreach(row => row.foreach(el => if (el == '1') count += 1))
  }

  def getNumberOfGroups: Int = {
    Set(parents).size
  }

  def isConnected(a: Int, b: Int): Boolean = {
    getParent(a) == getParent(b)
  }

  def union(a: Int, b: Int): Unit = {
    val parentOfA = getParent(a)
    val parentOfB = getParent(b)
    if (parentOfA == parentOfB) {
      return
    }

    val rankOfA = ranks(parentOfA)
    val rankOfB = ranks(parentOfB)
    if (rankOfA > rankOfB)
      parents(parentOfB) = parentOfA
    else if (rankOfA < rankOfB) {
      parents(parentOfA) = parentOfB
    } else {
      parents(parentOfB) = parentOfA
      ranks(a) += 1
    }
    count -= 1;
  }

  @scala.annotation.tailrec
  private def getParent(element: Int): Int = {
    val parent = parents(element)
    if (element == parent) {
      return parent
    }
    getParent(parent)
  }

}

/**
 * @author vvinnyk on 3/28/20.
 */
object NumberIslandsUnionFind extends BaseNumberIslands {
  def elementByIndex(matrix: ArrayBuffer[ArrayBuffer[Char]], index: Int): Char = {
    val row = index / matrix.length
    val col = index % matrix(0).length

    matrix(row)(col)
  }

  def isValid(coordinate: (Int, Int), grid: ArrayBuffer[ArrayBuffer[Char]]): Boolean = {
    val (r, c) = coordinate
    val max_r = grid.length
    val max_c = grid(0).length

    r >= 0 && r < max_r &&
      c >= 0 && c < max_c &&
      grid(r)(c) == '1'
  }

  override protected def numIslandsImpl(grid: ArrayBuffer[ArrayBuffer[Char]]): Int = {
    val length = grid.length * grid(0).length
    val unionFind = UnionFind(length)
    unionFind.count(grid)
    for (
      (a, r) <- grid.zipWithIndex;
      (_, c) <- a.zipWithIndex
    ) yield {
      val elem = grid(r)(c)
      grid(r)(c) = '0'
      val (lr, lc) = (r, c - 1)
      val (rr, rc) = (r, c + 1)
      val (ur, uc) = (r - 1, c)
      val (dr, dc) = (r + 1, c)
      if (elem == '1') {
        if (isValid(lr -> lc, grid)) {
          unionFind.union(r * grid(0).length + c, lr * grid(0).length + lc)
        }
        if (isValid(rr -> rc, grid)) {
          unionFind.union(r * grid(0).length + c, rr * grid(0).length + rc)
        }
        if (isValid(ur -> uc, grid)) {
          unionFind.union(r * grid(0).length + c, ur * grid(0).length + uc)
        }
        if (isValid(dr -> dc, grid)) {
          unionFind.union(r * grid(0).length + c, dr * grid(0).length + dc)
        }
      }
    }

    unionFind.count
  }

}
