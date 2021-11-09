import interview.quickSort

fun main(args: Array<String>) {
    println("leetcode of kotlin ")
    test()
}

fun test() {
    var nums = intArrayOf(3, 1, 4, 7, 2, 5, 8, 2, 6, 9)
    quickSort(nums)
    println(nums.map { it })
}

//fun createReadme(from: Int, to: Int) {
//    (from..to).forEach {
//        val folderPath = String.format("_%04d", it)
//        val ktFile = File("kotlin/src/$folderPath/$folderPath.kt")
//        val readMe = File("kotlin/src/$folderPath/Readme.md")
//        ktFile.parentFile.mkdirs()
//        ktFile.createNewFile()
//        readMe.createNewFile()
////        File("$folderPath/Readme.md").createNewFile()
////        File("kotlin/src/_$folderPath/Readme.md").createNewFile()
//    }
//}