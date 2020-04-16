package algs.heap

/**
 * @author vvinnyk on 4/5/20.
 */

case class Node(var value: Int, var l: Node = null, var r: Node = null, var parent: Node = null)

object Heap {
  private var top: Node = _
  private var bottom: Node = _

  private def rebalanceHeap(): Unit = {

  }

  private def appendToNode(parent: Node, nodeToAppend: Node): Node = {
    if (parent.l == null) {
      parent.l = nodeToAppend
    } else if (parent.l == null) {
      parent.r = nodeToAppend
    } else {
      throw new Exception("Can't add node to parent, because parent don't have any free slots")
    }
    nodeToAppend.parent = parent

    nodeToAppend
  }

  def addNode(value: Int): Node = {
    var nodeToAdd = Node(value)
    if (top == null && bottom == null) {
      top = nodeToAdd
      bottom = nodeToAdd
    } else {
      nodeToAdd = appendToNode(bottom, nodeToAdd)
      bottom = nodeToAdd
    }

    nodeToAdd
  }

  def main(args: Array[String]): Unit = {


  }
}
