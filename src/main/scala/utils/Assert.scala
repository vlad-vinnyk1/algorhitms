package utils

/**
 * @author vvinnyk on 3/28/20.
 */
object Assert {
  def assert[E](f: => Boolean): Unit = {
    if(!f) throw new AssertionError
  }
}
