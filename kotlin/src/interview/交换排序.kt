package interview


/**
 * 已知一个字符数组，其中存储有R、G、B字符，要求将所有的字符按照 RGB 的顺序进行排序。
 * 比如给定一个数组为 char s[] = "RGBBRGGBGB"，则排序后应该为 RRGGGGBBBB。
 */

internal fun swapChar(s: CharArray, i: Int, j: Int) {
    val temp = s[i]
    s[i] = s[j]
    s[j] = temp
}

internal fun partition(s: CharArray, lo: Int, hi: Int, c: Char) {
    var m = 0
    (lo .. hi).forEach { i ->
        if (s[i] != c) {
            swapChar(s, m, i)
            m++
        }
    }
}

// 类似快速排序的划分数组的方法
fun rgbSortTwice(s: String): String {
    val tempS = s.toCharArray()
    partition(tempS, 0, tempS.size - 1, 'G')
    partition(tempS, 0, tempS.size - 1, 'B')
    println(tempS)
    return tempS.joinToString()
}
