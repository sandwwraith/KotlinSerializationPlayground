import kotlinx.serialization.cbor.CBOR
import kotlinx.serialization.json.JSON
import kotlinx.serialization.protobuf.ProtoBuf
import model.*
import kotlin.test.*

class CommonTest {
    @Test
    fun sanityCheck() {
        assertEquals("Welcome to shop!", Common().greeting())
    }

    @Test
    fun canSerialize() {
        val serializer = Shop.serializer()
        val jsonShop = JSON.stringify(serializer, shop)
        val greeting = "Welcome to shop!\n$jsonShop"
        val expectedGreeting = Common().describe()
        assertEquals(expectedGreeting, greeting)
    }

    @Test
    fun isomorphicCbor() {
        val zoo = Common().getZoo()
        val serial = Zoo.serializer()
        val zoo2 = CBOR.load(serial, CBOR.dump(serial, zoo))
        assertTrue(zoo !== zoo2)
        assertEquals(zoo, zoo2)
    }

    @Test
    fun isomorphicProtobuf() {
        val country = russia
        val serial = CountryData.serializer()
        val country2 = ProtoBuf.load(serial, ProtoBuf.dump(serial, country))
        assertTrue(country !== country2)
        assertEquals(country, country2)
    }
}
