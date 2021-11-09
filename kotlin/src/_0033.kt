fun search(nums: IntArray, target: Int): Int {
    //先确定有序的部分再查找
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        var median = left + (right - left) / 2
        println("$left, $median, $right")
        if (nums[median] == target) {
            return median
        }
        //看左边是否有序
        if (nums[left] <= nums[median]) {
            if (target >= nums[left] && target <= nums[median]) {
                right = median - 1
            } else {
                left = median + 1
            }
        } else {
            if (target >= nums[median] && target <= nums[right]) {
                left = median + 1
            } else {
                right = median - 1
            }
        }

    }
    return -1
}