import org.testng.annotations.Test

fun longestCommonPrefix(strs: Array<String>): String {
    var result = ""
    if (strs.isEmpty()) {
        return result
    }
    var index = 0
    while (index < strs[0].length) {
        for (i in 1 until strs.size) {
            if (index >= strs[i].length || strs[0][index] != strs[i][index]) {
                return result
            }
        }
        result += strs[0][index]
        index += 1
    }
    return result
}


@Test
fun _0014() {
    val strs = arrayListOf("flower").toTypedArray()
    println(longestCommonPrefix(strs))
}