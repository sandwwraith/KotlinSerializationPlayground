import kotlin.test.*

import kotlinx.serialization.*
import kotlinx.serialization.json.*

import model.*
import org.jetbrains.kotlinconf.data.AllData

class ActualTest {
    @Test
    fun test() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun foobar() {
        val serializer = SimpleData.serializer()
        val data = SimpleData("foo", 42, listOf(ZZZ(42, "a"), ZZZ(43, "b")))
        val json = JSON.stringify(serializer, data)
        println(json)
        val restoredData = JSON.parse(serializer, json)
        assertEquals(data, restoredData)
    }

    @Test
    fun kconf() {
        val serializer = AllData.serializer()
        val json = JSON.stringify(serializer, allData)
        println(json)
        val restoredData = JSON.parse(serializer, json)
        assertEquals(allData, restoredData)
    }
}
