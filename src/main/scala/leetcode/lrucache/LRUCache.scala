package leetcode.lrucache

import scala.collection.mutable

/**
 * @author vvinnyk on 3/28/20.
 */
class LRUCache(_capacity: Int) {
  case class Node(var key: Int = 0, var value: Int = 0, var prev: Node = null, var next: Node = null)

  private val cache = mutable.Map[Int, Node]()

  private val head: Node = Node()

  private val tail: Node = Node()
  head.next = tail
  tail.prev = head

  private def addNode(node: Node): Unit = {
    node.prev = head
    node.next = head.next

    head.next.prev = node
    head.next = node
  }

  private def removeNode(node: Node): Unit = {
    val prev: Node = node.prev
    val next: Node = node.next

    prev.next = next
    next.prev = prev
  }

  private def moveToHead(node: Node): Unit = {
    removeNode(node)
    addNode(node)
  }

  private def popTail(): Node = {
    val res = tail.prev
    removeNode(res)
    res
  }

  def get(key: Int): Int = {
    cache.get(key).map { e =>
      moveToHead(e)
      e.value
    }.getOrElse(-1)
  }

  def put(key: Int, value: Int) {
    cache.get(key) match {
      case Some(node) =>
        node.value = value
        moveToHead(node)
      case None =>
        if (cache.size >= _capacity) {
          val res = popTail()
          cache.remove(res.key)
        }

        val nedNode = Node(key, value)
        addNode(nedNode)
        cache.put(key, nedNode)
    }
  }
}

object LRUCache {
  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(2)
    cache.put(1, 1)
    println(cache.get(1))
    cache.put(1, 3)
    println(cache.get(1))
    cache.put(3, 3)
    cache.put(4, 4)
    println(cache.get(1))
    cache.put(4, 4)
    println(cache.get(1))
  }
}
