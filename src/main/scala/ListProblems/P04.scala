package ListProblems
/*
Problem 04: Find the number of elements of a List.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */
object P04 {
  def main(args: Array[String]): Unit = {
    println("Enter size of the list")
    val n = scala.io.StdIn.readLine().toIntOption
    n match {
      case Some(n: Int) => readList(n)
      case None => println("Please enter a valid input")
    }

    def readList(n: Int): Unit = {
      val vec: Array[Int] = new Array[Int](n)
      println("Enter the content of the list")
      for (i <- vec.indices) {
        val in = scala.io.StdIn.readLine().toIntOption
        in match {
          case Some(in: Int) => vec(i) = in
          case None => println("Please enter a valid input")
            sys.exit(0)
        }
      }
      val list1 = vec.toList
      println(list1)
      lengthOfList(list1, 0)
    }
    @scala.annotation.tailrec
    def lengthOfList(list1: List[Int], len: Int): Unit={
      list1 match{
        case _ :: tails => lengthOfList(tails, len+1)
          //Call the function until we hit the end of the list, add 1 to the counter every time we call it.
          //Can also be done with folds
          //http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-foldleft-example/
        case Nil => println("The length of the list is " + len)
      }
    }
  }
}
