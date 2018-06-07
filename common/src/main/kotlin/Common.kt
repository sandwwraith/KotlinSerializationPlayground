import kotlinx.serialization.json.JSON
import model.*

// This code is common across all backends
class Common {
    fun getShop(): Shop = shop
    fun getZoo() = zoo

    fun greeting(): String = "Welcome to shop!"

    fun describe(): String {
        val jsonShop = JSON.stringify(getShop())
        return greeting() + "\n" + jsonShop
    }
}
