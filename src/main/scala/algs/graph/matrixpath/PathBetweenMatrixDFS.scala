package algs.graph.matrixpath

import algs.graph.representation.Graph.{Edge, Vertex}

import scala.collection.immutable

/**
 * @author vvinnyk on 3/24/20.
 */
object PathBetweenMatrixDFS {
  private val matrix1 = Array(
    Array(0, 1, 0, 0, 0),
    Array(1, 1, 1, 0, 1),
    Array(0, 1, 0, 0, 1),
    Array(0, 0, 0, 0, 0),
    Array(0, 1, 0, 0, 1)
  )

  def main(args: Array[String]): Unit = {
    arrayToGraph(matrix1)
  }

  type Coordinates = (Int, Int)

  def indexToCoordinates(index: Int, length: Int): Coordinates = {
    val row = index % length
    val column = index / length

    row -> column
  }

  sealed trait Connection {
    val thisIndex: Int
  }

  case class NotConnected(thisIndex: Int) extends Connection

  case class AdjacentConnections(thisIndex: Int,
                                 left: Option[Int],
                                 right: Option[Int],
                                 up: Option[Int],
                                 down: Option[Int]) extends Connection {
  }

  def getAdjacentConnections(matrix: Array[Array[Int]], thisIndex: Int): Connection = {
    val length = matrix.length
    val (row, column) = indexToCoordinates(thisIndex, length)
    val thisElement = matrix(row)(column)
    if (thisElement == 1) {
      def validate(index: Int): Option[Int] = {
        val (row, column) = indexToCoordinates(thisIndex, length)
        if (index >= 0 && index < length && matrix(row)(column) == 1)
          Some(index)
        else
          None
      }

      val left = thisIndex - 1
      val right = thisIndex + 1
      val upper = thisIndex - length
      val lower = thisIndex + length

      AdjacentConnections(thisIndex, validate(left), validate(right), validate(upper), validate(lower))
    } else {
      NotConnected(thisIndex)
    }
  }

  def addEdges(graph: immutable.Seq[Vertex], matrix: Array[Array[Int]], con: Connection): Unit = {
    val thisVertex = graph(con.thisIndex)
    con match {
      case AdjacentConnections(_, left, right, up, down) =>
        List(left, right, up, down).foreach { coordinate =>
          coordinate.foreach { idx =>
            val (adj_row, adj_column) = indexToCoordinates(idx, matrix.length)
            thisVertex.edges += Edge(graph(matrix(adj_row)(adj_column)))
          }
        }

      case _ =>
    }
  }


  def arrayToGraph(matrix: Array[Array[Int]]): Vertex = {
    val adjacentConnections = getAdjacentConnections(matrix, _: Int)
    val length = matrix.length
    val vertexNumber = length * length - 1
    var graph: immutable.Seq[Vertex] = (0 to vertexNumber)
      .map(idx => Vertex(idx))
    val addEdgesLoc = addEdges(graph, matrix, _: Connection)
    graph.foreach(ver => addEdgesLoc(adjacentConnections(ver.value)))
    graph(0)
  }
}
