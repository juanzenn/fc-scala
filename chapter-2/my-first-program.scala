// A comment
/* Another comment! */
/** A documentation comment */

object MyProgram:
  def abs(n: Int): Int =
    if n < 0 then -n
    else n

  def factorial(n: Int): Int =
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if n <= 0 then acc
      else go(n - 1, n * acc)
    
    go(n, 1)

  private def formatAbs(x: Int) =
    val msg = "The absolute value of %d is %d."
    msg.format(x, abs(x))

  private def formatFactorial(n: Int) =
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))

  private def findFirst[A](as: Array[A], p: A => Boolean) =
    @annotation.tailrec
    def loop(n: Int): Int =
      if n >= as.length then -1
      else if p(as(n)) then n
      else loop(n + 1)

    loop(0)

  @main def printAbs: Unit =
      println(formatAbs(-42))
      println(formatFactorial(7))
      println(findFirst(Array("a", "b", "c"), (s) => s == "a"))
