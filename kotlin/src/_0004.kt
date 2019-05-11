import org.testng.annotations.Test

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    if (m > n) {
        return findMedianSortedArrays(nums2, nums1)
    }
    var low = 0
    var high = m
    while (low <= high) {
        // 针对 nums1 进行 二分查找
        val i = low + (high - low).shr(1)
        val j = (m + n).shr(1) - i

        if (i < m && nums2[j - 1] > nums1[i]) {
            low = i + 1
        } else if (i > 0 && nums1[i - 1] > nums2[j]) {
            high = i - 1
        } else {
            // 找到想要的 i 值
            println(i)
            var minRight = 0
            minRight = when {
                i == m -> nums2[j]
                j == n -> nums1[i]
                else -> Math.min(nums1[i], nums2[j])
            }
            if ((m + n) % 2 == 1) {
                return minRight * 1.0
            }
            var maxLeft = 0
            maxLeft = when {
                i == 0 -> nums2[j - 1]
                j == 0 -> nums1[i - 1]
                else -> Math.max(nums1[i - 1], nums2[j - 1])
            }
            return 0.5 * (maxLeft + minRight)


//            var maxLeft = 0
//            maxLeft = when {
//                i == 0 -> nums2[j - 1]
//                j == 0 -> nums1[i - 1]
//                else -> Math.max(nums1[i - 1], nums2[j - 1])
//            }
//            if ((m + n) % 2 == 1) {
//                return maxLeft * 1.0
//            }
//            // 偶数逻辑
//            var minRight = 0
//            minRight = when {
//                i == m -> nums2[j]
//                j == n -> nums1[i]
//                else -> Math.min(nums1[i], nums2[j])
//            }
//            return 0.5 * (maxLeft + minRight)
        }
    }
    return 0.0
}

fun findMedianSortArray(nums1: ArrayList<Int>): Double {
    val m = nums1.size
    if (m == 0) {
        return 0.0
    }
    val low = 0
    val high = m
    val mid = low + (high - low).shr(1)
    if (m % 2 == 0) {
        return 0.5 * (nums1[mid] + nums1[mid - 1])
    } else {
        return nums1[mid] * 1.0
    }
}

@Test
fun _0004() {
    // 10    2 4 6 8 9
    val nums1 = IntArray(5)
    nums1[0] = 1
    nums1[1] = 2
    nums1[2] = 3
    nums1[3] = 4
    nums1[4] = 5
    val nums2 = IntArray(1)
    nums2[0] = 3
    val result = findMedianSortedArrays(nums1, nums2)
//    val result = findMedianSortArray(arrayListOf(1, 2))
    print(result)
}