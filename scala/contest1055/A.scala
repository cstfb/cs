object A extends App {
    import java.io.{PrintWriter}
    import java.util.{Locale, Scanner}

    val in = new Scanner(System.in)
    val out = new PrintWriter(System.out)

    def nextInt = in.nextInt
    def nextDouble = in.nextDouble
    def nextString = in.next

    val Y = "YES"
    val N = "NO"

    var isOk:Boolean = false

    def solve = {
        var n = nextInt
        var loc = nextInt

        var s1 = (for (i <- 0 until n) yield nextInt).toArray
        var s2 = (for (i <- 0 until n) yield nextInt).toArray

        if (loc == 1) {
            isOk = true
        } else if (s1(loc - 1) == 0 && s2(loc - 1) == 0) {
            isOk = false
        } else if (s1(0) == 0 && loc > 1) {
            isOk = false
        } else {
            // for 
            for (i <- 0 until n) {
                // println(i + "," + n + "," + loc)
                if (s1(i) == 1) {
                    if (i == loc - 1) {
                        isOk = true
                    } else if (s2(loc - 1) == 1 && i >= loc - 1 && s2(i) == 1) {
                        isOk = true
                    }
                }
            }
        }

        // println(s"$n, $loc, $s1")
    }

    solve
    println(if(isOk) Y else N)
}