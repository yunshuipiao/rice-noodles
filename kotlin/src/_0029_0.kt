import org.testng.annotations.Test

fun divide(dividend: Int, divisor: Int): Int {
    // 当除数为 Int.MIN_VALUE)
    if (dividend == Int.MIN_VALUE){
        // 此结果越界
        if (divisor == -1) {
            return Int.MAX_VALUE
        }
        if (divisor == 1) {
            return Int.MIN_VALUE
        }
        // 这种情况较为特殊，这里的处理是当除数为 Int.MIN_VALUE, 取除数为Int.MAX_VALUE, 2 为被除数是结果加1。
        if (divisor == 2) {
            return -(divide(Int.MAX_VALUE, divisor) + 1)
        }
        if (divisor == Int.MIN_VALUE) {
            return 1
        }
    }
    // 当除数为 Int.MIN_VALUE)
    if (divisor == Int.MIN_VALUE) {
        return 0
    }
    var result = 0
    var d1 = Math.abs(dividend)
    // 除数为Int.MIN_VALUE， 取为 Int.MAX_VALUE
    if (d1 == Int.MIN_VALUE) {
        d1 = Int.MAX_VALUE
    }
    val d2 = Math.abs(divisor)
    println("$d1, $d2")
    val flag = (dividend > 0).xor(divisor > 0)
    while (d1 >= d2) { // 优化
        d1 -= d2
        result += 1
    }
    if (flag) {
        return -result
    }
    return result
}

@Test
fun _0029() {
    arrayListOf(arrayListOf(Int.MIN_VALUE, 3)).forEach {
        println(divide(it[0], it[1]))
    }

}

