import org.testng.annotations.Test

/**
 * 常规解法
 */
fun letterCombinations(digits: String): List<String> {
    val map = hashMapOf(
        "2" to "abc",
        "3" to "def",
        "4" to "ghi",
        "5" to "jkl",
        "6" to "mno",
        "7" to "pqrs",
        "8" to "tuv",
        "9" to "wxyz"
    )
    val tempResult = arrayListOf<String>()
    val result = arrayListOf<String>()
    if (digits.isBlank()) return tempResult
    var tempDigits = digits
    do {
        val digit = tempDigits[0].toString()
        if (result.isEmpty()) {
            map[digit]?.forEach { c ->
                tempResult.add("$c")
            }
        } else {
            result.forEach { s ->
                map[digit]?.forEach { c ->
                    tempResult.add("$s$c")
                }
            }
        }
        result.clear()
        result.addAll(tempResult)
        tempResult.clear()
        tempDigits = tempDigits.substring(1, tempDigits.length)
    } while (tempDigits.isNotBlank())
    return result
}

fun letterCombinations2(digits: String): List<String> {
    val map = hashMapOf(
        "2" to "abc",
        "3" to "def",
        "4" to "ghi",
        "5" to "jkl",
        "6" to "mno",
        "7" to "pqrs",
        "8" to "tuv",
        "9" to "wxyz"
    )
    val result = arrayListOf<String>()
    if (digits.isBlank()) {
        return result
    }
    return letterComRecursion(result, digits, map)
}

fun letterComRecursion(
    result: ArrayList<String>,
    digits: String,
    map: HashMap<String, String>
): List<String> {
    if (digits.isBlank()) {
        return result
    }
    val tempResult = arrayListOf<String>()
    tempResult.addAll(result)
    result.clear()
    if (tempResult.isEmpty()) {
        map[digits[0].toString()]?.forEach {
            result.add("$it")
        }
    } else {
        tempResult.forEach { s ->
            map[digits[0].toString()]?.forEach { c ->
                result.add("$s$c")
            }
        }
    }
    return letterComRecursion(result, digits.substring(1, digits.length), map)
}

@Test
fun _0017() {
    arrayListOf("235").forEach {
        println(letterCombinations2(it))
    }
}