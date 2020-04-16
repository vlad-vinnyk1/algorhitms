package algs.sort

import scala.collection.mutable.ArrayBuffer

/**
 * @author vvinnyk on 4/4/20.
 */
object MergeSort {

  private def merge(sub1: ArrayBuffer[Int], sub2: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val res = ArrayBuffer[Int]()
    var point1 = 0
    var point2 = 0

    while (point1 < sub1.length || point2 < sub2.length) {

      if (point1 < sub1.length && point2 < sub2.length) {
        val elem1 = sub1(point1)
        val elem2 = sub2(point2)

        val elemToAdd = Math.min(elem1, elem2)
        res += elemToAdd

        if (elemToAdd == elem1) {
          point1 += 1
        } else {
          point2 += 1
        }
      } else if (point1 < sub1.length) {
        res += sub1(point1)
        point1 += 1
      } else {
        res += sub2(point2)
        point2 += 1
      }
    }

    res
  }

  private def mergeSort(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    if (arr.isEmpty || arr.length == 1) {
      return arr
    }

    val firstIdx = 0
    val lastIdx = arr.length - 1
    val pivot = firstIdx + (lastIdx + firstIdx) / 2
    val firstSubArr = mergeSort(arr.slice(firstIdx, pivot + 1))
    val secondSubArr = mergeSort(arr.slice(pivot + 1, arr.length))

    merge(firstSubArr, secondSubArr)
  }


  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(10, 2, 1500 ,-5, 1, 12, -78)
    println(mergeSort(arr))
    println(mergeSort(ArrayBuffer()))
    println(mergeSort(ArrayBuffer(2)))
  }

}
