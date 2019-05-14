import org.testng.annotations.Test

fun longestPalindrome(s: String): String {
    return longCommonSubString(s)
}

fun dp(s: String): String {
    if (s.isBlank()) {
        return s
    }
    var result = ""
    val map = Array(s.length) { Array(s.length) { 0 } }
    for (i in 0 until map.size) {
        for (j in 0 until map[0].size) {
            if (s[j] == s[i]) {
                if (i - j <= 1) {
                    map[j][i] = 1
                } else if (map[j + 1][i - 1] == 1) {
                    map[j][i] = 1
                }
            }
            if (map[j][i] == 1 && i - j + 1 >= result.length) {
                result = s.substring(j, i + 1)
            }
        }
    }
    return result
}

fun longCommonSubString(s: String): String {
    if (s.isBlank()) {
        return s
    }
    var result = ""
    val rs = s.reversed()
    val map = Array(s.length) { Array(s.length) { 0 } }
    for (i in 0 until s.length) {
        for (j in 0 until rs.length) {
            if (s[i] == rs[j]) {
                if (i - 1 < 0 || j - 1 < 0) {
                    map[i][j] = 1
                } else {
                    map[i][j] = map[i - 1][j - 1] + 1
                }
            } else {
                map[i][j] = 0
            }
            if (map[i][j] > result.length) {
                val temp = s.substring(i - map[i][j] + 1, i + 1)
                if (isPalindrome(temp)) {
                    result = temp
                }
            }
        }
    }
    return result
}

fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.length - 1
    while (l <= r) {
        if (s[l] != s[r]) {
            return false
        }
        l += 1
        r -= 1
    }
    return true
}

fun bestMethod(s: String): String {
    if (s.isBlank()) {
        return s
    }
    var result = ""
    for (i in 0 until s.length) {
        val len1 = getPalindromeLen(s, i, i)
        if (len1 >= result.length) {
            result = s.substring(i - len1 / 2, i + len1 / 2 + 1)
        }
        val len2 = getPalindromeLen(s, i, i + 1)
        if (len2 >= result.length) {
            result = s.substring(i - len2 / 2 + 1, i + len2 / 2 + 1)
        }
    }
    return result
}

/**
 * 判断回文串
 */
fun getPalindromeLen(s: String, i: Int, j: Int): Int {
    var l = i
    var r = j
    while (l >= 0 && r < s.length) {
        if (s[l] == s[r]) {
            l -= 1
            r += 1
        } else {
            break
        }
    }
    return r - l - 1
}


@Test
fun _0005() {
//    var str = "aacdefdcaa"
    var str = "abcdcb"
    val result = dp(str)
    println(result)
}

