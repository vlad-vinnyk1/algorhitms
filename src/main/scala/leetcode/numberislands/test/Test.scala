package leetcode.numberislands.test

import leetcode.numberislands.{NumberIslandsDFS, NumberIslandsUnionFind}
import utils.Assert.assert

/**
 * @author vvinnyk on 3/28/20.
 */
object Test {
  def main(args: Array[String]): Unit = {
    val in: Array[Array[Char]] = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )

    val in2: Array[Array[Char]] = Array(
      Array('1', '1', '0'),
      Array('0', '0', '1'),
      Array('1', '1', '0')
    )

    val in3: Array[Array[Char]] = Array(
      Array('1', '0', '1', '1', '0', '1', '1')
    )

    val in4: Array[Array[Char]] = Array(
      Array('0')
    )

    val in5: Array[Array[Char]] = Array(
      Array('1', '1', '1', '1', '1', '1', '1'),
      Array('0', '0', '0', '0', '0', '0', '1'),
      Array('1', '1', '1', '1', '1', '0', '1'),
      Array('1', '0', '0', '0', '1', '0', '1'),
      Array('1', '0', '1', '0', '1', '0', '1'),
      Array('1', '0', '1', '1', '1', '0', '1'),
      Array('1', '1', '1', '1', '1', '1', '1')
    )

//    testDfs(in, in2, in3, in4, in5)
    testUnionFind(in, in2, in3, in4, in5)
  }

  private def testDfs(in: Array[Array[Char]], in2: Array[Array[Char]], in3: Array[Array[Char]],
                      in4: Array[Array[Char]], in5: Array[Array[Char]]): Unit = {
    assert(NumberIslandsDFS.numIslands(in) == 1)
    assert(NumberIslandsDFS.numIslands(in2) == 3)
    assert(NumberIslandsDFS.numIslands(in3) == 3)
    assert(NumberIslandsDFS.numIslands(in4) == 0)
    assert(NumberIslandsDFS.numIslands(in5) == 1)
  }

  private def testUnionFind(in: Array[Array[Char]], in2: Array[Array[Char]], in3: Array[Array[Char]],
                            in4: Array[Array[Char]], in5: Array[Array[Char]]): Unit = {
    assert(NumberIslandsUnionFind.numIslands(in) == 1)
    assert(NumberIslandsUnionFind.numIslands(in2) == 3)
    assert(NumberIslandsUnionFind.numIslands(in3) == 3)
    assert(NumberIslandsUnionFind.numIslands(in4) == 0)
    assert(NumberIslandsUnionFind.numIslands(in5) == 1)
  }
}
