import org.testng.annotations.Test

/**
 * 8. String to Integer (atoi)
 * 读懂题目要求，理解清楚题目意思
 *
 */
fun myAtoi(str: String): Int {
    if (str.isBlank()) {
        return 0
    }
    var result: Int = 0
    var symbol = 1
    var index = 0
    // 找到第一个非空字符
    while (str[index] == ' ') {
        index += 1
    }
    // 如果是符号，则后面必然接数字，否则不合法
    if (str[index] == '-' || str[index] == '+') {
        symbol *= if (str[index] == '-') -1 else 1
        index += 1
    }
    // 处理数字字符
    while (index < str.length && str[index] in '0'..'9') {

        val digit = (str[index].toInt() - 48)

        // 判断溢出
        if (result > (Int.MAX_VALUE - digit) / 10) {
            return if (symbol == 1) Integer.MAX_VALUE else Integer.MIN_VALUE
        }
        result = result * 10 + digit
        index += 1
    }
    return result * symbol
}

@Test
fun _0008() {
    val strs = arrayListOf("2147483648", "-2147483649", "  -42")
    strs.forEach {
        println("$it, ${myAtoi(it)}")
    }
}