
object iev {

    def main(args : Array[String]) {

        val q = Array(18091, 19075, 18285, 18977, 19423, 19395)
        val p = Array(2.0, 2.0, 2.0, 1.5, 1.0, 0.0)

        println(p zip q map { case (a,b) => a*b } sum)

    }
}
