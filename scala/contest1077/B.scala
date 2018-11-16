object A extends App{
    import java.io.{PrintWriter}
    import java.util.{Locale, Scanner}

    val in = new Scanner(System.in)
    val out = new PrintWriter(System.out)

    def nextInt = in.nextInt

    def solve = {
        val n = nextInt
        var ans = 0
        var stats = (for(i <- 1 to n) yield nextInt).toList
        stats = (0::stats):+0
        var input = stats.toBuffer

        for (i <- 1 to n) {
            if(input(i) == 0) {
                if(input(i - 1) == 1 && input(i + 1) == 1) {
                    input(i + 1) = 0
                    ans += 1
                }
            }
        }
        println(ans)
    }

    solve
}