package Problems1to10
/*
Problem 03: Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:
scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */
object P03 {
  def main(args: Array[String]): Unit = {
    println("Enter size of the list")
    val n = scala.io.StdIn.readLine().toIntOption
    n match {
      case Some(n: Int) => readList(n)
      case None => println("Please enter a valid input")
    }

    def readList(n: Int): Unit = {
      val vec: Array[Int] = new Array[Int](n)
      println("Size of the list is " + vec.length)
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
      println("This is the list: " + list1)
      println("Please enter the number of the element to search ")
      val k = scala.io.StdIn.readLine().toIntOption
      k match {
        case Some(k: Int) => kthElement(list1, k)
        case None => println("Please enter a valid input")
      }
    }

    @scala.annotation.tailrec
    def kthElement(list1: List[Int], k: Int): Unit = {
      (list1, k) match{
        case (element:: _, 0) => println("The element searched for is: " + element)
          //We don't care if the current element of the list has a cons or nil, only thing we care about is that k is 0.
        case (_ :: tail, k) => kthElement(tail, k - 1)
          //Everytime we call the function we reduce k by one until we hit 0, so we know we've found what we are searching for.
        case (Nil, _) => println("Element not inside the list")
          //If we are at the end of the list and we didn't hit 0, then the number K is bigger than the size of the list.
      }
    }
  }
}
