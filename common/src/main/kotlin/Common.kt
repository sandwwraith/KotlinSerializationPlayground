import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import model.*

// This code is common across all backends
class Common {
    fun getShop(): Shop = shop

    fun greeting(): String = "Welcome to shop!"

    fun describe(): String {
        val jsonShop = JSON.stringify(Shop.serializer(), getShop())
        return greeting() + "\n" + jsonShop
    }
}

@Serializable
data class WithName(@SerialName("description") val descriptionText: String)
