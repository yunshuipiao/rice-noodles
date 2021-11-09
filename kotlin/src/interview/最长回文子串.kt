package interview


//abcdcbe, 比如bcdcb就是结果


//中心法
fun longestPalindrome(s: String): String {

    //求位置l为中心的最长回文子串的开始位置和长度
    fun expandAroundCenter(s: String, l: Int, r: Int, result: IntArray) {
        val len = s.length - 1
        var left = l
        var right = r
        while (left >= 0 && right <= len && s[left] == s[right]) {
            left += 1
            right -= 1
        }
        result[0] = left + 1
        result[1] = right - left - 1
    }

    if (s.isBlank()) {
        return s
    }
    var longestBegin = 0
    var longestLen = 0

    val result = intArrayOf(0, 0)
    s.forEachIndexed { index, c ->

        //以位置i为中心的最长回文子串
        expandAroundCenter(s, index, index, result)
        if (result[1] > longestLen) {
            longestBegin = result[0]
            longestLen = result[1]
        }
        // 以位置i，i+1 为中心的最长回文子串
        expandAroundCenter(s, index, index + 1, result)
        if (result[1] > longestLen) {
            longestBegin = result[0]
            longestLen = result[1]
        }
    }
    return s.substring(result[0], result[1])
}
