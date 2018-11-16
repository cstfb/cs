object A extends App{
    import java.io.{PrintWriter}
    import java.util.{Locale, Scanner}

    val in = new Scanner(System.in)
    val out = new PrintWriter(System.out)

    def nextInt = in.nextInt
    def nextLong = in.nextLong

    def nextInput = {
        (for (i <- 0 until 3) yield nextLong).toArray
    }

    def solve = {
        val n = nextInt
        for (i <- 0 until n) {
            var input = nextInput
            val odd = input(2) / 2
            val even = if(input(2) % 2 == 0) input(2) / 2 else input(2) / 2 + 1
            val ans = even * input(0) - odd * input(1)
            println(ans)
        }
    }

    solve
}