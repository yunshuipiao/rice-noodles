import org.testng.annotations.Test

fun romanToInt(s: String): Int {
    var result = 0
    if (s.isEmpty()) {
        return 0
    }
    val map = hashMapOf(
        'M' to 1000,
        'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1
    )
    result = map[s[0]] ?: 0
    for (i in 1 until s.length) {
        var cur = map[s[i]] ?: 0
        var before = map[s[i - 1]] ?: 0
        if (cur > before) {
            result += cur - 2 * before
        } else {
            result += cur
        }
    }
    return result
}


@Test
fun _0013() {
    arrayListOf("III", "IV", "IX", "LVIII", "MCMXCIV").forEach {
        println(romanToInt(it))
    }
}