
import org.testng.annotations.Test

fun isValid(s: String): Boolean {
    val map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
    val result = ArrayList<Char>()
    for (c in s) {
        println(c)
        if (c in map.keys) {
            result.add(c)
        } else {
            if (result.isEmpty() || map[result.last()] != c) {
                return false
            } else {
                result.removeAt(result.size - 1)
            }
        }
    }
    return result.isEmpty()
}

@Test
fun _0020() {
    arrayListOf("()", "()[]{}", "({])").forEach {
        println(isValid(it))
    }
}

