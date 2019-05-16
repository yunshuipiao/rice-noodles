import model.printTwoDimenArray
import org.testng.annotations.Test

/**
 * 字符串匹配 dp 问题: 放弃
 * Regular Expression Matching
 */
fun isMatch(s: String, p: String): Boolean {
    val dp = Array(p.length + 1){Array(s.length + 1) {false}}
    dp[0][0] = true
    // 第0行和第0列分别表示空字符和对应字符串的匹配
    for (i in 1..p.length) {
        // p 的第一个字符为*， 则无法匹配
        if (i > 1 && p[i - 1] == '*') {
            dp[i][0] = dp[i - 2][0]
        }
    }
    for (i in 1..s.length) {
        for (j in 1..p.length) {
            if (p[j - 1] == '*') {
                dp[j][i] = dp[j - 2][i] || (p[j - 2] == s[i - 1] || p[j - 2] == '.') && dp[j][i - 1]
            }
            if (p[j - 1] == s[i - 1]) {
                dp[j][i] = dp[j - 1][i - 1]
            }
            if (p[j - 1] == '.') {
                dp[j][i] = dp[j - 1][i - 1]
            }
        }
    }
    printTwoDimenArray(dp)
    return dp[p.length][s.length]
}

@Test
fun _0010() {
    val s = "aabb"
    val p = "a*b*"
    val result = isMatch(s, p)
    println(result)

}