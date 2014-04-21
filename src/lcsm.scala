
object lcsm {

    def main(args : Array[String]) {

        val s = scala.io.Source.fromFile("rosalind_lcsm.txt").mkString


        val dnas = (s split ">").tail.toList map { L =>
            val e = L split "\r\n"
            val seq = e.tail mkString "" replaceAll(" ", "") replaceAll("\r", "") replaceAll("\n", "")

             seq
        }

        def normalize(s : List[String]) = s.sorted.foldLeft(List.empty[String]) { case (acc, e) =>

            if (acc.isEmpty)
                e :: Nil
            else if (e startsWith acc.head)
                e :: acc.tail
            else
                e :: acc
        }

        def allIndices(s : String, pattern : Char, idx : Int = 0) : List[Int] =
            s.indexOf(pattern, idx) match {
                case -1 => Nil
                case x => x :: allIndices(s, pattern, x + 1)
            }


        def substrings(s : String) : List[String] =
            if (s.isEmpty) Nil else s :: substrings(s.tail)

        def longestSubstring(s : String, idx : Int, pat : String) =
            (s.substring(idx) zip pat takeWhile { case (p ,q) => p == q } map { _._1 }) mkString ""

        val res = dnas.tail.toList.foldLeft(normalize(substrings(dnas.head))) { case (acc, dna) =>

            normalize(
                acc flatMap { pattern =>
                    allIndices(dna, pattern.head) map { idx => longestSubstring(dna, idx, pattern) }
                }
            )
        }

        println(res maxBy { _.length })

    }

}
