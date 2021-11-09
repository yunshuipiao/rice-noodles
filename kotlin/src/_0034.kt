fun searchRange(nums: IntArray, target: Int): IntArray {
    val result = intArrayOf(0, 0)
    //分两次查找，分别定位左边界和右边界
    if (nums.isEmpty()) {
        return intArrayOf(-1, -1)
    }
    var left = 0
    var right = nums.size - 1
    var median = 0
    while (left < right) {
        median = left + (right - left) / 2
        if (nums[median] < target) {
            left = median + 1
        } else {
            right = median
        }
    }
    if (nums[left] != target) {
        return intArrayOf(-1, -1)
    }
    result[0] = left

    left = 0
    right = nums.size - 1
    while (left < right) {
        median = left + (right - left + 1) / 2
        if (nums[median] > target) {
            right = median - 1
        } else {
            left = median
        }
    }
    result[1] = right
    if (nums[right] != target) {
        return intArrayOf(-1, -1)
    }
    return result
}