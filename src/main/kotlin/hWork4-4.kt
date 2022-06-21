import java.util.*

open class Food(): Comparable<Food>{
    protected open var calories: Long = 0
    override fun compareTo(other: Food): Int = when {
        this.calories < other.calories -> -1
        this.calories > other.calories -> 1
        else -> 0
    }
    override fun toString(): String {
        return "calories = $calories"
    }
}
class Falafel: Food() {
    override var calories: Long = 30
}
class Pizza: Food() {
    override var calories: Long = 40
}
class Hamburger: Food() {
    override var calories: Long = 50
}

fun main() {
        val foodList = Array<Food?>(10) {null}
        for (i in foodList.indices) {
            val obj = when ((1..3).random()) {
                1 -> Falafel()
                2 -> Pizza()
                else -> Hamburger()
            }
            foodList[i] = obj
        }
        Arrays.sort(foodList)
        for (i in foodList.indices) {
            println(foodList[i])
        }
}