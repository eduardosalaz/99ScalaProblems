package ListProblems
/*
Problem 05: Reverse a List.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
object P05 {
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
      reverseList(list1, Nil)
    }
    @scala.annotation.tailrec
    def reverseList(currentList: List[Int], reversedList: List[Int]): Unit ={
      currentList match {
        case head :: tail => reverseList(tail, head:: reversedList)
          //We start with a Nil list, and we fill in the head of our list, while at the same time we remove it as we call the function on the tail of the original list.
        case Nil => println("Reversed list: " + reversedList)
          //Once we hit the end of the list we print it.
      }

    }
  }

}
