package ListProblems
/*
Problem 02: Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */
object P02 {
  def main(args: Array[String]): Unit = {
    println("Enter size of the list")
    val n = scala.io.StdIn.readLine().toIntOption
    n match {
      case Some(n: Int) => readList(n)
      case None => println("Please enter a valid input")
    }
    def readList(n: Int): Unit ={
      val vec:Array[Int] = new Array[Int](n)
      println("Size of the list is " + vec.length)
      println("Enter the content of the list")
      for(i <- vec.indices){
        val in = scala.io.StdIn.readLine().toIntOption
        in match {
          case Some(in: Int) => vec(i) = in
          case None => println("Please enter a valid input")
            sys.exit(0)
        }
      }
      val list1 = vec.toList
      println("This is the list: " + list1)
      penultimateOfList(list1)
    }
    @scala.annotation.tailrec
    def penultimateOfList(list1: List[Int]): Unit={
      list1 match{
        case penultimate :: _ :: Nil => println("Penultimate element is: " + penultimate)
          //Does the tail of the tail of our current element is Nil? If so, we have the penultimate element
        case _ :: tail => penultimateOfList(tail)
      }
    }
  }

}
