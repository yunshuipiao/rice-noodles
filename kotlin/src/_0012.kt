import org.testng.annotations.Test

fun intToRoman(num: Int): String {
    var result = ""
    var tempNum = num
    if (tempNum < 1 || tempNum > 3999) {
        return result
    }
    val intArray = arrayListOf(
        1000, 900, 500, 400, 100,
        90, 50, 40, 10, 9, 5, 4, 1
    )
    val romanArray = arrayListOf(
        "M", "CM", "D", "CD", "C",
        "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    )
    var index = 0
    while (tempNum > 0 && index < intArray.size) {
        if (tempNum >= intArray[index]) {
            tempNum -= intArray[index]
            result += romanArray[index]
        } else {
            index += 1
        }
    }
    return result

}

fun intToRoman2(num: Int): String {
    val M = arrayListOf("", "M", "MM", "MMM")
    val C = arrayListOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val X = arrayListOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val I = arrayListOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10]
}


@Test
fun _0012() {
    arrayListOf(3, 4, 9, 58, 1994).forEach {
        println(intToRoman2(it))
    }
}