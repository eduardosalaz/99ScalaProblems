package ListProblems
/*
Problem 06: Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */
object P06 {
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
      //We first reverse the list in order to check one by one.
      val revList = reverseList(list1, Nil)
      palindromeList(list1, revList)
    }
    //Slight modification of the function used in the previous problem to return a list used in our new function.
    @scala.annotation.tailrec
    def reverseList(currentList: List[Int], reversedList: List[Int]): List[Int] ={
      currentList match {
        case head :: tail => reverseList(tail, head:: reversedList)
        case Nil => return reversedList //return keyword is optional
      }
    }
    @scala.annotation.tailrec
    def palindromeList(currentList: List[Int], palindromedList: List[Int]): Unit={
      (currentList, palindromedList) match {
          //We are matching the 2 lists at the same time, checking the heads of both at the same time, if they are equal, we call the function again on their tails
          //until we hit the end of both, if we do hit the end then this means the list is palindromic
        case (head1 :: tail1, head2 :: tail2) if head1 == head2 => palindromeList(tail1, tail2)
        case (head1 :: _, head2:: _) if head1 != head2 => println("List is not palindromic")
          //In this case we will never hit the end because if any head is different from the other the function isn't called again.
        case (Nil, Nil) => println("List is palindromic")
      }
    }
  }
}
