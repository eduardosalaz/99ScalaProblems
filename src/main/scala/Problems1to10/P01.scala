package Problems1to10
/*
Problem 01:  Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
TODO: IMPLEMENT A RECURSIVE INPUT METHOD WITH CONS
 */
object P01{
  def main(args: Array[String]): Unit = {
    println("Enter size of the list")
    val n = scala.io.StdIn.readLine().toIntOption
    //Very important to use an Option variable to use pattern matching to handle incorrect input, instead of throwing exception, it may have Some[value] or None.
    n match {
      case Some(n: Int) => readList(n)
      case None => println("Please enter a valid input")
    }
    def readList(n: Int): Unit ={
      val vec:Array[Int] = new Array[Int](n)
      //Theoretically it's first an array and then we turn it into a list.
      println("Size of the list is " + vec.length)
      println("Enter the content of the list")
      for(i <- 0 until vec.length){ // vec.indices works too
        val in = scala.io.StdIn.readLine().toIntOption
        //Same as above, using Option[Int] to handle input that is not an int.
        in match {
          case Some(in: Int) => vec(i) = in
          case None => println("Please enter a valid input")
            /*
            Let's say we have a list of size 3, and we enter foo, bar and 1. The program will complain but it will go on, filling with 0's the blank spaces
            left by the String inputs, so the list would be: 0 0 1, which is not what I want, so I just shut it down entirely. This behavior may be useful in the future.
            This can also be done with: in.getOrElse(value to be filled in).
            Additionally, there is also in.isEmpty to return true or false, not much useful because of pattern matching but it's also a nice option to have I guess.
             */
            sys.exit(0)
        }
      }
      val list1 = vec.toList
      println("This is the list: " + list1)
      lastOfList(list1)
    }
    @scala.annotation.tailrec
    def lastOfList(list1: List[Int]): Unit={
      /*
      Lists in Scala are immutable and follow the rules that Lists in Lisp do: a head, which is the first method of the list,
      the tail: which is everything except the first item,
      the :: operator, also called cons, very similar to the one of Lisp,
      the isEmpty method, pretty self explanatory.
      Using this we can create a recursive algorithm to search a tail with a Nil cons.
      Nil stands for Empty list, just as in Lisp.
       */
      list1 match{
        case last :: Nil => println("The last element of the list is " + last)
        //If the cons of last matches to Nil (no elements following last), then this is the one, serves as our base case.
        case _ :: tail => lastOfList(tail)
        //Otherwise, if the cons of _ matches to a viable tail, use the function on that same tail, until the tail we have has no tail.
        //We use _ to represent any other case (by convention)
      }
    }
  }
}