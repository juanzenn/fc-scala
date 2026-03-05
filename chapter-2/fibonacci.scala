object FibonnaciSequence:
  def fibonnaci(n: Int): Int =
    
    @annotation.tailrec
    def go(n: Int, prev: Int, curr: Int): Int =
      if n == 0 then prev
      else go(n - 1, curr, prev + curr)

    go(n, 0, 1)
    
  @main def calculateFibonnaci(): Unit =
    println(FibonnaciSequence.fibonnaci(5))