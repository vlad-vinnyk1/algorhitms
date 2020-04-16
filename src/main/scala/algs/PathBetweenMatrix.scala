package algs.graph



case class Searcher(n: Int) {
  private var unionComponents: List[Int] = (0 to n).toList

  def union(a: Int, b: Int): Unit = {
    val a_from = unionComponents(a)
    val b_from = unionComponents(b)

    unionComponents = unionComponents.map(elem => {
      if (elem == b_from) a_from else elem
    })
  }

  def isConnected(a: Int, b: Int): Boolean = {
    unionComponents(a) == unionComponents(b)
  }
}
