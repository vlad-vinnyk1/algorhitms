package leetcode.addtwonumbers

/**
 * @author vvinnyk on 3/29/20.
 */
object AddTwoNumbers {

  case class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }

  def getSum(extra: Int, p1value: Int, p2value: Int): (Int, Int) = {
    var value = p1value + p2value + extra
    var extr = 0
    if (value >= 10) {
      extr += 1
      value = value % 10
    }
    extr -> value
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var p1 = l1
    var p2 = l2
    var sumRes = getSum(0, p1value = p1.x, p2value = p2.x)
    val res = ListNode(sumRes._2)
    var extra = sumRes._1
    var tmp = res
    var sum = 0

    while (p1.next != null || p2.next != null || extra != 0) {
      if (p1.next != null && p2.next != null) {
        p1 = p1.next
        p2 = p2.next
        sumRes = getSum(extra, p1value = p1.x, p2value = p2.x)
      } else if (p1.next != null) {
        p1 = p1.next
        sumRes = getSum(extra, p1value = p1.x, p2value = 0)
      } else if (p2.next != null) {
        p2 = p2.next
        sumRes = getSum(extra, p1value = 0, p2value = p2.x)
      } else {
        sumRes = getSum(extra, 0, 0)
      }
      extra = sumRes._1
      sum = sumRes._2
      val next = ListNode(sum)
      tmp.next = next
      tmp = tmp.next
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val l1 = ListNode(5)
    val l2 = ListNode(5)

    val a = addTwoNumbers(l1, l2)
    println(a)
  }
}
