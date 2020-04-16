package leetcode.meetingrooms

import scala.collection.mutable

/**
 * @author vvinnyk on 4/4/20.
 */
object MeetingRoomsTwo {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    if (intervals.isEmpty) return 0
    val sortedIntervals = intervals.sortBy(e => e(0))

    def diff(inter: Array[Int]): Int = -inter(1)

    val roomsOccupied = new mutable.PriorityQueue[Array[Int]]()(Ordering.by(diff))
    roomsOccupied.enqueue(sortedIntervals(0))

    for (i <- 1 until sortedIntervals.length) {
      val thisInterval = sortedIntervals(i)
      if (thisInterval(0) >= roomsOccupied.head(1)) {
        roomsOccupied.dequeue()
      }
      roomsOccupied.enqueue(thisInterval)
    }

    roomsOccupied.size
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(
      Array(0, 30),
      Array(5, 10),
      Array(15, 20)
    )

    val arr2 = Array(
      Array(7, 10),
      Array(2, 4)
    )

    val arr3 = Array(
      Array(2, 7)
    )

    val arr4 = Array(Array(2, 11), Array(6, 16), Array(11, 16))

//    println(minMeetingRooms(arr1))
        println(minMeetingRooms(arr4))
    //    println(minMeetingRooms(arr3))
    //    println(minMeetingRooms(Array(Array.empty)))
    //    println(minMeetingRooms(Array(Array(5, 8), Array(6, 8))))
  }
}
