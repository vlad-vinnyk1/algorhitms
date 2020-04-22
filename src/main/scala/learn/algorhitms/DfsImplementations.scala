package learn.algorhitms

import com.sun.xml.internal.xsom.XSWildcard.Union
import utils.Graph

import scala.collection.mutable

/**
 * @author vvinnyk on 3/27/20.
 */
object DfsImplementations {
  def dfsUsingStack(vertex: Vertex): Unit = {
    val lifo = mutable.Stack[Vertex]()
    val visited = mutable.Set[Int]()
    lifo.push(vertex)

    while (lifo.nonEmpty) {
      val curElem = lifo.pop()
      if (!visited.contains(curElem.value)) {
        visited.add(curElem.value)
        println(curElem.value)
      }
      curElem.edges.foreach(e => {
        val dest = e.dest
        if(!visited.contains(dest.value))
          lifo.push(dest)
      }
      )
    }
  }

  def dfsRec(vertex: Vertex): Unit = {

  }

  def main(args: Array[String]): Unit = {
    val graph = Graph.createTheGraph()
    dfsUsingStack(graph(4))
  }
}

case class Edge(dest: Vertex)

case class Vertex(value: Int, edges: mutable.Buffer[Edge] = mutable.Buffer[Edge]())
