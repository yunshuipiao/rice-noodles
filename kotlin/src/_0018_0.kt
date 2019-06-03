import org.testng.annotations.Test

/**
 * 常规解法
 */

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    if (nums.size < 4) {
        return result
    }
    val tempNums = nums
    nums.sort()

    return result
}

@Test
fun _0018() {
    arrayListOf(intArrayOf(1, 0, -1, 0, -2, 2)).forEach {
        fourSum(it, 0).forEach {
            println(it)
        }
    }
}

