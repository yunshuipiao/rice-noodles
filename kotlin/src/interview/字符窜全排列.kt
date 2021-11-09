package interview


// 给一个字符数组 char arr[] = "abc"，输出该数组中字符的全排列。

fun perm(s: String) {

    fun perm(s: CharArray, k: Int) {
        if (k == s.size - 1) {
            println(String(s))
        }
        (k until s.size).forEach { i ->
            swapChar(s, i, k)
            perm(s, k + 1)
            swapChar(s, i, k)
        }
    }

    perm(s.toCharArray(), 0)
}