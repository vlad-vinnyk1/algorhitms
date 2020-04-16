package functional

import scala.annotation.tailrec

/**
 * @author vvinnyk on 3/23/20.
 */
object ListComp {
  def main(args: Array[String]): Unit = {
    val arr = List(1, 2, 3, 4, 5)
//    println(tail(arr))
//    println(setHead(999, arr))
    println(drop(arr, 22))
  }

  def tail[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case ::(_, tail) => tail
    }
  }

  def setHead[A](head: A, l: List[A]): List[A] = {
    head :: l
  }

  def drop[A] (l: List[A], n: Int): List[A] = {
    if(n == 0) {
      return l
    } else if(n >= l.length){
      return Nil
    }
    @tailrec
    def dropLocal(l: List[A], i: Int): List[A] = {
      if(i == n || l.tail.length == 1) {
        return l.tail
      }
      dropLocal(l.tail, i + 1)
    }
    dropLocal(l, 1)
  }
}
