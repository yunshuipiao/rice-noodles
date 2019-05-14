import org.testng.annotations.Test

fun maxArea(height: IntArray): Int {
    if (height.size < 2) {
        return 0
    }
    var l = 0
    var r = height.size - 1
    var result = 0
    while (l <= r) {
        val tempR = (r - l) * Math.min(height[r], height[l])
        result = Math.max(tempR, result)
        if (height[l] < height[r]) {
            l += 1
        } else {
            r -= 1
        }
    }
    return result
}

@Test
fun _0011() {
    val height = intArrayOf(1,9,6,2,5,4,8,3,7)
    arrayListOf(height).forEach {
        println(maxArea(it))
    }
}