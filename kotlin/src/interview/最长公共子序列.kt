package interview


fun longestCommonSubsequence(text1: String, text2: String): Int {
    // 字符串转为char数组以加快访问速度
    val str1 = text1.toCharArray()
    val str2 = text2.toCharArray()

    val m = str1.size
    val n = str2.size
    // 构建dp table，初始值默认为0
    val dp = Array(m + 1) { IntArray(n + 1) }
    // 状态转移
    for (i in 1..m)
        for (j in 1..n)
            if (str1[i - 1] == str2[j - 1])
            // 找到LCS中的字符
                dp[i][j] = dp[i - 1][j - 1] + 1
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])

    return dp[m][n]
}