package model

fun <T> printTwoDimenArray(map: Array<Array<T>>) {
    for (i in 0 until map.size) {
        for (j in 0 until map[i].size) {
            print("${map[i][j]}  ")
        }
        println()
    }
}
