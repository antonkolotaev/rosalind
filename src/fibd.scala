import collection.immutable.Queue

object fibd {

    def main(args : Array[String]) {


        def fib(n : BigInt, m : Int) =
            ((1L : BigInt) to n-1).foldLeft(Queue.fill(m - 1) { 0L : BigInt } ++ Queue(1L : BigInt )) {
                case (p, _) => p.enqueue(p.sum - p.last).dequeue._2
            }.sum

        print((1 to 96) map {x => fib(x, 18)} mkString "\n")
        //print(fib(6,3)._2)
    }

}
