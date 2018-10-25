import kotlin.test.*

import kotlinx.serialization.*
import kotlinx.serialization.json.*

class ActualTest {
    @Test
    fun test() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun foobar() {
        val serializer = SimpleData.serializer()
        val data = SimpleData("foo", 42)
        val json = JSON.stringify(serializer, data)
        println(json)
        val restoredData = JSON.parse(serializer, json)
        assertEquals(data, restoredData)
    }
}
