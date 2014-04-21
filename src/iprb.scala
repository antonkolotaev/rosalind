
object iprb {

    def main(args : Array[String]){

        val k = 15
        val m = 23
        val n = 29
        
        val all = k + m + n
        
        val k_1 = 1.0 * k / all
        val m_1 = 1.0 * m / all
        val n_1 = 1.0 * n / all

        val all_1 = all - 1

        val kk = k_1 * (k - 1) / all_1
        val km = k_1 * m / all_1
        val kn = k_1 * n / all_1

        val nn = n_1 * (n - 1) / all_1
        val nm = n_1 * m / all_1
        val nk = n_1 * k / all_1

        val mm = m_1 * (m - 1) / all_1
        val mk = m_1 * k / all_1
        val mn = m_1 * n / all_1

        println(kk + km + kn + mk + nk + mm * 0.75 + (nm + mn) * 0.5)
    }

}
