import org.testng.annotations.Test

/**
 *  7. Reverse Integer
 *  // 只可以使用32位数据 [-2^32, 2^32 - 1]
 */

fun reverse(x: Int): Int {
    var result: Int = 0
    var tempx = x
    val symbol = if (tempx >= 0) 1 else -1
    while (tempx != 0) {
        // 对每一次可能溢出进行判断
        if (result  > (Int.MAX_VALUE  - (tempx % 10) ) / 10 && symbol == 1) {
            println("-")
            return 0
        }
        if (result < (Int.MIN_VALUE - (tempx % 10) ) / 10 && symbol == -1 ) {
            println("--")
            return 0
        }
        result = result * 10 + (tempx % 10)
        tempx /= 10
    }
    return result
}

fun reverse2(x: Int): Int {
    var result: Int = 0
    var tempx: Int = x
    while (tempx != 0) {

        val newResult = result * 10 + (tempx % 10)
        if (result !=  (newResult - tempx % 10 ) / 10 ) {
            return 0
        }

        result = newResult
        tempx /= 10
    }
    return result
}

@Test
fun _0007() {
    arrayListOf(153423646).forEach {
        println(reverse2(it))
    }
}