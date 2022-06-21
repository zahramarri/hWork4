class Socks(
    var name: String,
    season: Season,
    basePrice: Long,
) : Clothing(season, basePrice)

class Shirt(
    var name: String,
    season: Season,
    basePrice: Long,
) : Clothing(season, basePrice)

class Pants(
    var name: String,
    season: Season,
    basePrice: Long
) : Clothing(season, basePrice)

class Jacket(
    var name: String,
    season: Season,
    basePrice: Long
) : Clothing(season, basePrice)

enum class Season {
    Spring, Summer, Fall, Winter
}

abstract class DiscountStrategy {
    abstract fun priceByDiscount(clothing: Clothing): Long
}

class SummerDiscountStrategy : DiscountStrategy() {
    override fun priceByDiscount(clothing: Clothing): Long {
        clothing.price = when (clothing.season) {
            Season.Spring -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.4)).toLong()
            }
            Season.Summer -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.5)).toLong()
            }
            Season.Winter -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.3)).toLong()
            }
            else -> {
                clothing.basePrice
            }
        }
        return clothing.price
    }
}

class WinterDiscountStrategy : DiscountStrategy() {
    override fun priceByDiscount(clothing: Clothing): Long {
        clothing.price = when (clothing.season) {
            Season.Fall -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.4)).toLong()
            }
            Season.Winter -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.5)).toLong()
            }
            Season.Summer -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.25)).toLong()
            }
            else -> {
                clothing.basePrice
            }
        }
        if (clothing is Jacket) {
            clothing.price -= (clothing.price * 0.1).toLong()
        }
        return clothing.price
    }
}

class YaldaDiscountStrategy : DiscountStrategy() {
    override fun priceByDiscount(clothing: Clothing): Long {
        clothing.price = when (clothing) {
            is Jacket -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.1)).toLong()
            }
            is Socks -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.2)).toLong()
            }
            else -> {
                ((clothing.basePrice) - (clothing.basePrice * 0.25)).toLong()
            }
        }
        return clothing.price
    }
}

abstract class Clothing(var season: Season, var basePrice: Long) {
    var price = basePrice

    fun setDiscountStrategy(discountStrategy: DiscountStrategy) {
        discountStrategy.priceByDiscount(this)
    }
}

fun main() {
    val leninCoat = Jacket("Lenin Coat", Season.Fall, 100000)
    println("Lenin Coat: ${leninCoat.price}")

    leninCoat.setDiscountStrategy(YaldaDiscountStrategy())
    println("Lenin Coat with Yalda discount: ${leninCoat.price}")

    leninCoat.setDiscountStrategy(WinterDiscountStrategy())
    println("Lenin Coat with Winter discount: ${leninCoat.price}")

    val woolenSocks: Clothing = Pants("Woolen Socks", Season.Winter, 10000)
    println("Woolen Socks: ${woolenSocks.price}")

    woolenSocks.setDiscountStrategy(SummerDiscountStrategy())
    println("Woolen Socks with Summer discount: ${woolenSocks.price}")

    woolenSocks.setDiscountStrategy(WinterDiscountStrategy())
    println("Woolen Socks with Winter discount: ${woolenSocks.price}")
}