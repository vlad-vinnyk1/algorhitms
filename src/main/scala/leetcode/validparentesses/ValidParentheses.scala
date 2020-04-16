package leetcode.validparentesses

import scala.collection.mutable

/**
 * @author vvinnyk on 3/29/20.
 */
object ValidParentheses {

  val map = Map(
    '(' -> ')',
    '[' -> ']',
    '{' -> '}'
  )

  def isValid(s: String): Boolean = {
    val stack = mutable.Stack[Char]()
    s.toCharArray.foreach { ch =>
      if (ch == '(' || ch == '{' || ch == '[')
        stack.push(ch)
      else if (ch == ')' || ch == '}' || ch == ']') {
        if (stack.isEmpty || map.get(stack.pop()).exists(v => v != ch))
          return false
      }
    }
    stack.isEmpty
  }

  def main(args: Array[String]): Unit = {
    println("() -> " + isValid("()"))
    println("()[]{} -> " + isValid("()[]{}"))
    println("(] -> " + isValid("(]"))
    println("([)] -> " + isValid("([)]"))
    println("{[]} -> " + isValid("{[]}"))
    println("]-> " + isValid("]"))
  }
}
