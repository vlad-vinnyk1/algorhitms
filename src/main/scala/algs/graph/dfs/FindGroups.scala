package algs.graph.dfs

import algs.graph.representation.Graph.{Edge, Vertex}

import scala.collection.mutable

/**
 * @author vvinnyk on 3/26/20.
 */
object FindGroups {
  def createGraph(): Seq[Vertex] = {
    val graph = (0 to 18).map(Vertex(_))
    graph(0).edges += Edge(graph(4)) += Edge(graph(8)) += Edge(graph(13)) += Edge(graph(14))
    graph(4).edges += Edge(graph(0)) += Edge(graph(8))
    graph(8).edges += Edge(graph(0)) += Edge(graph(4))
    graph(13).edges += Edge(graph(0)) += Edge(graph(14))
    graph(14).edges += Edge(graph(13)) += Edge(graph(0))


    graph(6).edges += Edge(graph(7)) += Edge(graph(11))
    graph(7).edges += Edge(graph(6)) += Edge(graph(11))

    graph(1).edges += Edge(graph(5))
    graph(5).edges += Edge(graph(1)) += Edge(graph(16)) += Edge(graph(17))
    graph(16).edges += Edge(graph(5))
    graph(17).edges += Edge(graph(5))

    graph(2).edges += Edge(graph(9)) += Edge(graph(15))
    graph(3).edges += Edge(graph(9))
    graph(9).edges += Edge(graph(3)) += Edge(graph(15)) += Edge(graph(2))
    graph(15).edges += Edge(graph(2)) += Edge(graph(9)) += Edge(graph(10))
    graph(10).edges += Edge(graph(15))

    graph
  }

//  def dfs(visited: mutable.Set[Int], components: mutable.Set[Int], head: Vertex, count: Int): (Int, mutable.Set[Int]) = {
////    visited()
//  }

  def main(args: Array[String]): Unit = {
    val graph = createGraph()(0)
    val visited: mutable.Set[Int] = mutable.Set.empty
    val components: mutable.Set[Int] = mutable.Set.empty

    val n = 18
//    (0 to n).foreach { i =>
//      if (!visited.contains(i))
//        dfs(visited, components, graph, 1)
    }
//  }
}
