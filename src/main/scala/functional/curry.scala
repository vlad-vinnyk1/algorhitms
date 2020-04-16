package functional

/**
 * @author vvinnyk on 3/23/20.
 */
object curry {
  def main(args: Array[String]): Unit = {
    val curr = curry((a: String, b: String) => a + b)
    val uncurr = uncurry(curr)
    println(uncurr("ByRA", "TiNo"))
    println(curr("ByRA")("TiNo"))
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    a: A => f(g(a))
  }
}
