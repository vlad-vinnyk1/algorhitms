package algs.graph.matrixpath

import algs.graph.Searcher

/**
 * @author vvinnyk on 3/24/20.
 */
object PathBetweenMatrixUnionFind {
  private val matrix1 = Array(
    Array(0, 1, 0, 0, 0),
    Array(1, 1, 1, 0, 1),
    Array(0, 1, 0, 0, 1),
    Array(0, 0, 0, 0, 0),
    Array(0, 1, 0, 0, 1)
  )

  def elementByIndexInMatrix[A](matrix: Array[Array[A]], index: Int): Int = {
    val column = index % matrix1.length
    val row = index / matrix1.length

    matrix1(row)(column)
  }

  def main(args: Array[String]): Unit = {
    print(isPath(matrix1, 9, 14))
  }

  def isPath(matrix: Array[Array[Int]], a: Int, b: Int): Boolean = {
    val length = matrix1.length
    val totalElNumb = (length * length) - 1
    val searcher = Searcher(totalElNumb)

    (0 to totalElNumb).toList.foreach(index => {
      if (elementByIndexInMatrix(matrix1, index) == 1) {
        List(index - length, index + length, index - 1, index + 1)
          .foreach(i =>
            if (i > 0 && i < totalElNumb && elementByIndexInMatrix(matrix1, i) == 1) searcher.union(index, i)
          )
      }
    }
    )

    searcher.isConnected(a, b)
  }
}
