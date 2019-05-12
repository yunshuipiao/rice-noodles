import org.testng.annotations.Test

/**
 * 注意空格
 * 空间复杂度 O(n), 时间复杂度O(n*n)
 */
fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var tempStr = ""
    for (index in 0 until s.length) {
        val i = tempStr.indexOf(s[index])
        if (i != -1) {
            // 当前中有重复元素
            tempStr = tempStr.substring(i + 1) + s[index]
        } else {
            tempStr += s[index]
        }
        result = Math.max(tempStr.length, result)

    }
    return result
}

/**
 * 使用 hashmap 来标记最大 substring
 * 基本思想：两个 pointer i，j 记录当前最大的 substring，同时 hashmap 负责维护出现
 * 过的字符； i 向前扫描，遇到当前字符出现过，则进行 j 的更新：向前移动 j 到出现过的下标的位置
 */
fun lengthOfLongestSubstring2(s: String): Int {
    var max = 0
    if (s.isEmpty()) {
        return 0
    }
    var slow = 0
    val map = hashMapOf<Char, Int>()
    for (fast in 0 until s.length) {
        if (map.containsKey(s[fast])) {
            // 这里为什么要去最大值：防止 slow 向后移动，对于abcdbea 来说，第二个a时如果不取最大值， 则slow回到1， b重复
            // 即 向左移动可能会出现重复的字符串
            slow = Math.max(slow, (map[s[fast]] ?: 0) + 1)
        }
        map[s[fast]] = fast
        max = Math.max(max, fast - slow + 1)
    }
    return max
}

@Test
fun _0003() {
    val result = lengthOfLongestSubstring(" ")
    println(result)
}