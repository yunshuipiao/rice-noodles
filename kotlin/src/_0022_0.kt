
import org.testng.annotations.Test

fun generateParenthesis(n: Int): List<String> {
    val result = arrayListOf<String>()
    backtracking(result, "", 0, 0, n)
    return result.toList()
}

fun backtracking(result: ArrayList<String>, s: String, open: Int, close: Int, max: Int) {
    println(s)
    if (s.length == 2 * max) {
        result.add(s)
        println("----")
        return
    }
    if (open < max) {
        backtracking(result, "$s(", open + 1, close, max)
    }
    if (close < open) {
        backtracking(result, "$s)", open ,close + 1, max)
    }
}


@Test
fun _0022() {
    arrayListOf(3).forEach {
        println(generateParenthesis(it))
    }
}

