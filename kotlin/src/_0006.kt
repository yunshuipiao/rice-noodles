import org.testng.annotations.Test

fun convert(s: String, numRows: Int): String {
    if (s.isBlank()) {
        return s
    }
    var result = ""
    // 每一组的字符串
    val count = if (numRows == 1) 1 else (2 * numRows - 2)
    for (i in 0 until numRows) {
        var index = i
        while (index < s.length) {
            result += s[index]

            // 非 第一行和 最后一行的 另外的元素下标计算
            val index2  = index + (count - 2 * i)
            if (i != 0 && i != numRows - 1 && index2 < s.length) {
                result += s[index2]
            }
            index += count
        }
    }
    return result
}

@Test
fun _0006() {
    val s = "PAYPALISHIRING"
    val numRows = 4
    val result = convert(s, numRows)
    println(result)
}