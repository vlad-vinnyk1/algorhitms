package algs.graph.representation

import algs.graph.representation.Graph.{Edge, Vertex}

import scala.collection.mutable

/**
 * @author vvinnyk on 3/26/20.
 */
object AdjacencyList {
  def main(args: Array[String]): Unit = {
    val graph = (0 to 4).map(Vertex(_))

    graph(0).edges += Edge(graph(1)) += Edge(graph(2))
    graph(1).edges += Edge(graph(3))
    graph(2).edges += Edge(graph(3))
    graph(3).edges += Edge(graph(0)) += Edge(graph(4))

    dfs(graph(0))
    println()
  }

  private val visited = mutable.Set[Int]()

  def dfs(graph: Vertex): Unit = {
    graph match {
      case Vertex(value, edges) =>
        if(visited.contains(value))
          return
        visited += value
        println(value)
        edges.foreach(edge => dfs(edge.dest))
    }
  }
}


//Adjacency List
object Graph {

  case class Edge(dest: Vertex)

  case class Vertex(value: Int, edges: mutable.Buffer[Edge] = mutable.Buffer[Edge]())

}
