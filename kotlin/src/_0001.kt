fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val list = IntArray(nums.size) { Int.MAX_VALUE}
    nums.forEachIndexed { index, number ->
        if (list.contains(number)) {
            result[0] = nums.indexOf(target - number)
            result[1] = index
            return result
        } else {
            list[index] = target - number
        }
    }
    return result
}




