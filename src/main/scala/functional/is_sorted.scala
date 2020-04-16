package functional

import scala.annotation.tailrec

/**
 * @author vvinnyk on 3/23/20.
 */
object is_sorted {
  def main(args: Array[String]): Unit = {
    val ar1 = Array.empty
    val ar2 = Array(1)
    val ar3 = Array(1, 2)
    val ar4 = Array(1, 3, 2, 5)
    val ar5 = Array(1, 2, 3, 5)
    val func = (a: Int, b:Int) => a < b
//    println(isSorted(ar1, func))
//    println(isSortedFromGit(ar1, func))

//    println(isSorted(ar2, func))
//    println(isSortedFromGit(ar2, func))
//
//    println(isSorted(ar3, func))
//    println(isSortedFromGit(ar3, func))

//    println(isSorted(ar4, func))
//    println(isSortedFromGit(ar4, func))

    println(isSorted(ar1, func))
    println(isSortedFromGit(ar1, func))
  }

  def isSorted[A] (ar: Array[A], ordered: (A, A) => Boolean): Boolean = {
    if(ar.isEmpty || ar.length == 1)
      return true
    @tailrec
    def isSortedLocal(ar: Array[A], prev_elem: A): Boolean = {
      if(ar.isEmpty)
        return true
      val thisElem= ar.head
      if(!ordered(prev_elem, thisElem))
        return false
      isSortedLocal(ar.tail, thisElem)
    }
    isSortedLocal(ar.tail, ar.head)
  }

  def isSortedFromGit[A] (ar: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def isSortedLocal(index: Int): Boolean = {
        if(index >= ar.length - 1) true
        else {
          ordered(ar(index), ar(index + 1)) && isSortedLocal(index + 1)
        }
      }

    isSortedLocal(0)
  }
}