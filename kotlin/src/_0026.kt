
import org.testng.annotations.Test

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var result = 0
    for (index in 0 until nums.size) {
        if (nums[index] != nums[result]) {
            result += 1
            nums[result] = nums[index]
        }
    }
    return result + 1
}


@Test
fun _0026() {
    arrayListOf(intArrayOf(0,0,1,1,1,2,2,3,3,4)).forEach {
        println(removeDuplicates(it))
    }
}

