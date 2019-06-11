
import org.testng.annotations.Test

fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var result = 0
    for (index in 0 until nums.size) {
       if (nums[index] != `val`) {
           nums[result] = nums[index]
           result += 1
       }
    }
    return result
}


@Test
fun _0027() {
    arrayListOf(intArrayOf(0,1,2,2,3,0,4,2)).forEach {
        println(removeElement(it, 2))
    }
}

