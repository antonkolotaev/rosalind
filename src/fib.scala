
object fib {

    def main(args : Array[String]) {

        val n : Long = 29
        val k : Long = 5

        def fib = (1L to n-1).foldLeft(1 : Long,1 : Long) {
            case ((a,b), _) => (b, a*k + b)
        }

        print(fib)

    }

}
