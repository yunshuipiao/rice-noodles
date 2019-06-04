import org.testng.annotations.Test

/**
 * 常规解法
 */

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    if (nums.size < 4) {
        return result
    }
    nums.sort()
    var index = 0
    while (index < nums.size) {
        if (index > 0 && nums[index] == nums[index - 1]) {
        } else {
            val tempNums = nums.filterIndexed { i, v -> i > index }.toIntArray()
            val tResult = threeSum(tempNums, target - nums[index])
            tResult.forEach {
                val l = it as ArrayList
                l.add(nums[index])
                result.add(l)
            }
        }
        index += 1
    }
    return result
}


fun threeSum(nums: IntArray, target: Int): List<List<Int>> {

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
            if (sum > target) {
                do {
                    r -= 1
                } while (r > l && tempNums[r] == tempNums[r + 1])
            } else if (sum < target) {
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

// wrong answer
//fun fourSum2(nums: IntArray, target: Int): List<List<Int>> {
//    fun findNsum(l: Int, r: Int, target: Int, n: Int, result: ArrayList<Int>, results: ArrayList<ArrayList<Int>>) {
//        if (r - l + 1 < n || n < 2 || target < nums[l] * n || target > nums[r] * n) {
//            return
//        }
//        println(result)
//        var l1 = l
//        var r1 = r
//        if (n == 2) {
//            while (l1 < r1) {
//                val s = nums[l1] + nums[r1]
//                if (s == target) {
//                    result.add(nums[l1])
//                    result.add(nums[r1])
//                    results.add(result)
////                    println(results)
//                    l1 += 1
//                    while (l1 < r1 && nums[l1] ==  nums[l1 - 1]) {
//                        l1 += 1
//                    }
//                } else if (s > target) {
//                    r1 -= 1
//                } else {
//                    l1 += 1
//                }
//            }
//        } else {
//            for (i in l until r + 1) {
//                if (i == l || (i > l && nums[i - 1] != nums[i])) {
//                    result.add(nums[i])
//                    findNsum(i + 1, r, target - nums[i], n - 1, result, results)
//                }
//            }
//        }
//    }
//
//    val results = arrayListOf<ArrayList<Int>>()
//    if (nums.size < 4) {
//        return results
//    }
//    nums.sort()
//    findNsum(0, nums.size - 1, target, 4, arrayListOf(), results)
//    return results
//}


@Test
fun _0018() {
    arrayListOf(intArrayOf(-1, -5, -5, -3, 2, 5, 0, 4)).forEach {
        fourSum(it, -7).forEach {
            println(it)
        }
    }
}

