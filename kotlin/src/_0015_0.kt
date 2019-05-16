import org.testng.annotations.Test

fun threeSum(nums: IntArray): List<List<Int>> {

    val result = arrayListOf<ArrayList<Int>>()
    val tempNums = nums
    if (tempNums.size < 3) {
        return result
    }
    return result
}


@Test
fun _0015() {
    arrayListOf(intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6)).forEach {
        println(threeSum(it))
    }
}