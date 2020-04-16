package leetcode.happynumber

/**
 * @author vvinnyk on 3/31/20.
 */
object HappyNumber {

  private val cycleMembers = Set[Int](List(4, 16, 37, 58, 89, 145, 42, 20): _*)

  private def findDivider(number: Int): Int = {
    var res = 1
    var currentNumber = number
    while (currentNumber > 0) {
      currentNumber = currentNumber / 10
      res *= 10
    }
    res
  }

  private def getSqrAllDigitsOfNumber(number: Int, upDivider: Int): Int = {
    var res = 0
    var divider = 1

    while (divider < upDivider) {
      val thisVal = number / divider % 10
      divider *= 10
      res += thisVal * thisVal
    }

    res
  }

  @scala.annotation.tailrec
  def isHappy(n: Int): Boolean = {
    if (n == 1) {
      return true
    }
    if (cycleMembers.contains(n)) {
      return false
    }
    val divider = findDivider(n)
    val newNumber = getSqrAllDigitsOfNumber(n, divider)

    isHappy(newNumber)
  }

  def main(args: Array[String]): Unit = {
    print(isHappy(2))
  }
}
