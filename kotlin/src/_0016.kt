import org.testng.annotations.Test

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = 0
    if (nums.size < 3) {
        return 0
    }
    var tempNums = nums
    tempNums.sort()
    result += tempNums[0] + tempNums[1] + tempNums[2]
    for (index in 0..tempNums.size - 3) {
        var l = index + 1
        var r = tempNums.size - 1
        while (l < r) {
            val tempResult = tempNums[index] + tempNums[l] + tempNums[r]
            if (tempResult > target) {
                r -= 1
            } else if (tempResult < target) {
                l += 1
            } else {
                return tempResult
            }
            if (Math.abs(tempResult - target) <= Math.abs(result - target)) {
                result = tempResult
            }
        }
    }
    return result
}


@Test
fun _0016() {
    arrayListOf(intArrayOf(1, 1, -1, -1, 3)).forEach {
        println(threeSumClosest(it, 1))
    }
}