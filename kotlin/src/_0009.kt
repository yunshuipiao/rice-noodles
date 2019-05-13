import org.testng.annotations.Test

fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    var tempx = x
    var newx = 0
    while (tempx != 0) {
        newx = newx * 10 + tempx % 10
        tempx /= 10
    }
    return newx == x
}

fun isPalindrome2(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    // 结尾为0， 不是
    if (x != 0 && x % 10 == 0) {
        return false
    }
    var tempx = x
    var newx = 0
    while (tempx > newx) {
        newx = newx * 10 + tempx % 10
        tempx /= 10
    }
    // 两种情况 12321 12344321
    return (tempx == newx || tempx == newx / 10)
}

@Test
fun _0009() {
    arrayListOf(123, 454, -123, 1234321).forEach {
        println(isPalindrome2(it))
    }
}