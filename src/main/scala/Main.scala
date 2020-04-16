import scala.concurrent.Promise

/**
 * @author vvinnyk on 4/6/20.
 */
object Main {
  def main(args: Array[String]): Unit = {
    var i = 0
    do {
      println(i)
      i += 1
    } while (i < 10)
    val promise = Promise[String]
    promise.failure(new IllegalArgumentException("d"))
    println(promise.future.failed)
  }
}
