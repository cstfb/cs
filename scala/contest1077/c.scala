object A extends App{
    import java.io.{PrintWriter, InputStreamReader, BufferedReader}
    import java.util.{Locale, Scanner}
    import scala.collection.mutable._

    val in = new BufferedReader(new InputStreamReader(System.in));
    val out = new PrintWriter(System.out)

    def nextString = in.readLine

    def solve = {
        var n = nextString.toInt
        var ar = nextString.split(" ").map(e => e.toLong)
        var sum = ar.sum
        var set = ar.toSet

        var l = (for(i <- 0 until n ) yield (ar(i), i)).toList

        var m:HashMap[Long, Int] = new HashMap()
        // var m = l.groupBy(e => e._1).mapValues(e => e.size.toInt)
        for (item <- ar) {
            if(m.contains(item)) {
                m.put(item, m.get(item).get + 1)
            } else {
                m.put(item, 1)
            }
        }
        
        var ans:Buffer[Int] = List().toBuffer
        for (i <- 0 until n) {
            var item = ar(i)
            if ((sum - item) % 2 == 0) {
                val haf = (sum - item) / 2
                if(m.contains(haf)) {
                    if (item != haf) {
                        ans.append(i)
                    } else if (m.get(haf).get > 1) {
                        ans.append(i)
                    }
                }
            }
        }

        println(ans.size)
        ans = ans.map(_ + 1)
        println(ans.mkString(" "))
    }

    solve
}