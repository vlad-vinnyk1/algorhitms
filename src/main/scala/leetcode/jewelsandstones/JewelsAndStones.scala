package leetcode.jewelsandstones

import scala.collection.mutable

/**
 * @author vvinnyk on 3/27/20.
 */
object JewelsAndStones {
  def numJewelsInStones(J: String, S: String): Int = {
    val jewels = mutable.Set[Char]()
    J.foreach(j => jewels.add(j))
    S.count(stone => jewels.contains(stone))
  }

  def main(args: Array[String]): Unit = {
    val J = "aA"
    val  S = "aAAbbbb"
    println(numJewelsInStones("aA", "aAAbbbb"))
    println(numJewelsInStones("z", "ZZ"))
  }

}
