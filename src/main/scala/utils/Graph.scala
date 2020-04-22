package utils

import learn.algorhitms.{Edge, Vertex}

/**
 * @author vvinnyk on 3/27/20.
 */
object Graph {
  def createTheGraph(): Seq[Vertex] = {
    val graph = (0 to 5).map(item => Vertex(item))
    graph(0).edges += Edge(graph(5)) += Edge(graph(2))
    graph(1).edges += Edge(graph(2))
    graph(2).edges += Edge(graph(0)) += Edge(graph(3))
    graph(3).edges += Edge(graph(2)) += Edge(graph(4))
    graph(4).edges += Edge(graph(3))
    graph(5).edges += Edge(graph(0))

    graph
  }

}
