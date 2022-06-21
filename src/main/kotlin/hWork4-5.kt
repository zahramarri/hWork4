class Matrix(var row: Int, var column: Int) {
private var twoDArray = MutableList (row) { MutableList (column) {0} }

    fun setElement(i: Int, j: Int, element: Int) {
        twoDArray[i][j] = element
    }

    override fun toString(): String {
        var str = ""
        for (i in 0 until row) {
            for (j in 0 until column) {
                str += (this.twoDArray[i][j]).toString()
                str += " "
            }
            str += "\n"
        }
        return str
    }

    fun add(matrix: Matrix): Matrix? {
        var newMatrix: Matrix? = null
        if ((this.row == matrix.row) && (this.column == matrix.column)) {
            newMatrix = Matrix(row, column)
            for (i in 0 until row) {
                for (j in 0 until column) {
                    newMatrix.twoDArray[i][j] = this.twoDArray[i][j] + matrix.twoDArray[i][j]
                }
            }
        } else {
            println("The two matrices are not addable.")
        }
        return newMatrix
    }

    fun multiplication(matrix: Matrix): Matrix? {
        var newMatrix: Matrix? = null
        if ((this.row == matrix.row) && (this.column == matrix.column)) {
            newMatrix = Matrix(row, column)
            for (i in 0 until row) {
                for (j in 0 until column) {
                    newMatrix.twoDArray[i][j] = this.twoDArray[i][j] * matrix.twoDArray[i][j]
                }
            }
        } else {
            println("The two matrices are not multiplicative.")
        }
        return newMatrix
    }
}

//fun setAllElements(matrix: Matrix) {
//    for (i in 0 until matrix.row) {
//        for (j in 0 until matrix.column) {
//            println("i: $i, j: $j")
//            matrix.setElement(i, j, readLine().toString().toInt())
//        }
//    }
//}

fun main() {
    val matrix1 = Matrix(2, 2)
    for (i in 0 until matrix1.row) {
        for (j in 0 until matrix1.column) {
            println("i: $i, j: $j")
            matrix1.setElement(i, j, readLine().toString().toInt())
        }
    }
//    setAllElements(matrix1)
    println(matrix1.toString())
    val matrix2 = Matrix(2, 2)
    for (i in 0 until matrix2.row) {
        for (j in 0 until matrix2.column) {
            println("i: $i, j: $j")
            matrix2.setElement(i, j, readLine().toString().toInt())
         }
    }
//    setAllElements(matrix2)
    println(matrix2.toString())
    println(matrix1.add(matrix2).toString())
    println(matrix1.multiplication(matrix2).toString())
}