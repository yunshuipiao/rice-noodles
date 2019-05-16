import org.testng.annotations.Test

fun threeSum(nums: IntArray): List<List<Int>> {

    val result = arrayListOf<ArrayList<Int>>()
    val tempNums = nums
    if (tempNums.size < 3) {
        return result
    }
    tempNums.sort()
    for (index in 0..tempNums.size - 3) {
        if (index - 1 >= 0 && tempNums[index - 1] == tempNums[index]) {
            continue
        }
        var l = index + 1
        var r = tempNums.size - 1
        while (l < r) {
            val sum = tempNums[index] + tempNums[l] + tempNums[r]
            if (sum > 0) {
                do {
                    r -= 1
                } while (r > l && tempNums[r] == tempNums[r + 1])
            } else if (sum < 0) {
                do {
                    l += 1
                } while (r > l && tempNums[l] == tempNums[l - 1])
            } else {
                result.add(arrayListOf(tempNums[index], tempNums[l], tempNums[r]))
                do {
                    r -= 1
                } while (r > l && tempNums[r] == tempNums[r + 1])
                do {
                    l += 1
                } while (r > l && tempNums[l] == tempNums[l - 1])
            }
        }
    }
    return result
}


@Test
fun _0015() {
    arrayListOf(intArrayOf(-2, 0, 1, 1, 2)).forEach {
        println(threeSum(it))
    }
}