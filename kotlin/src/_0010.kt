import org.testng.annotations.Test

/**
 * 字符串匹配 dp 问题: 放弃
 * Regular Expression Matching
 */
fun isMatch(s: String, p: String): Boolean {

    return false
}

@Test
fun _0010() {
    val s = "aaab"
    val p = "a*b"
    val result = isMatch(s, p)
    println(result)

}