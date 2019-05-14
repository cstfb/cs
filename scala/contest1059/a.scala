object A extends App {
    import java.io.{PrintWriter, InputStreamReader, BufferedReader}
    import java.util.{Locale, Scanner}
    import scala.collection.mutable._

    val in = new Scanner(System.in)
    val bufferedIn = new BufferedReader(new InputStreamReader(System.in))
    val out = new PrintWriter(System.out)

    def nextInt = in.nextInt
    def nextLong = in.nextLong
    def nextDouble = in.nextDouble
    def nextString = bufferedIn.readLine

    def solve = {
        val n = nextInt
        val L = nextInt
        val a = nextInt
        var ans = 0
        var cur = 0

        // println(s"$n $L $a")

        for (i <- 0 until n) {
            val ti = nextInt
            val li = nextInt
            
            ans += (ti - cur) / a
            cur = ti + li
        }
        ans += (L - cur) / a

        println(ans)
    }

    solve
}