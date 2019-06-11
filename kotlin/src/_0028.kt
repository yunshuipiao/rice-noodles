import org.testng.annotations.Test

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) {
        return 0
    }
    var result = -1
    val len = needle.length
    for (index in 0 until haystack.length) {
        if ((index + len) <= haystack.length &&
            haystack.substring(index, index + len) == needle
        ) {
            return index
        }
    }
    return result
}

fun strStr2(haystack: String, needle: String): Int {
    for (i in 0 until Int.MAX_VALUE) {
        for (j in 0 until Int.MAX_VALUE) {
            if (j == needle.length) {
                return i
            }
            if (i + j == haystack.length) {
                return -1
            }
            if (haystack[i + j] != needle[j]) {
                break
            }
        }
    }
    return -1
}

@Test
fun _0028() {
    arrayListOf(arrayListOf("hello", "ll")).forEach {
        println(strStr2(it[0], it[1]))
    }
}

