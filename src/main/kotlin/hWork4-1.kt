//fun deleteNonOrderlyPair(arrayList: ArrayList<Int>): ArrayList<Int> {
//    if (arrayList.size % 2 != 0) {
////        arrayList.removeAt(arrayList.lastIndex)
//        arrayList.removeLast()
//    }
//    val newArrayList = arrayListOf<Int>()
//    for (index in arrayList.indices step 2) {
//        if (arrayList[index] < arrayList[index + 1]) {
//    newArrayList.add(arrayList[index])
//    newArrayList.add(arrayList[index + 1])
//        }
//    }
//    return newArrayList
//}
//
//fun main() {
//    val arrayList1 = arrayListOf(2, 4, 8, 7, 9, 1, 3, 5, 4)
//    println(deleteNonOrderlyPair(arrayList1))
//    val arrayList2 = arrayListOf<Int>()
//    println(deleteNonOrderlyPair(arrayList2))
//    val arrayList3 = arrayListOf(-8, -7, -9, -1)
//    println(deleteNonOrderlyPair(arrayList3))
//}

fun main() {
    val array1 = arrayListOf(5, 5, 7, 3)
    val array2 = arrayListOf(7, 3)
    var i = 0
    while (i in array1.indices) {
        var j = 0
        while (j < array2.size) {
            if (array1[i] + array1[i + 1] == array2[j] + array2[j + 1]) {
                array1.removeAt(i)
                array1.removeAt(i)
                array2.removeAt(j)
                array2.removeAt(j)
            }
            j += 2
        }
        i += 2
    }
    println(array1)
}