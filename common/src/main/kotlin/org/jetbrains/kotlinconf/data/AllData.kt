package org.jetbrains.kotlinconf.data

import kotlinx.serialization.*
import kotlinx.serialization.internal.*

//@Serializable
//data class AllData(
//    val speakers: List<Speaker?>? = emptyList()
//)
//
//class SessionizeData(val allData: AllData, val etag: String = allData.hashCode().toString())

data class AllData(
    @Optional
    var speakers: List<Speaker>? = null
) {
    @Suppress("NAME_SHADOWING")
    object serializer : KSerializer<AllData> {
        override val descriptor: SerialDescriptor =
            object : SerialClassDescImpl("org.jetbrains.kotlinconf.data.AllData") {
                init {
                    addElement("sessions")
                    addElement("rooms")
                    addElement("speakers")
                    addElement("questions")
                    addElement("categories")
                    addElement("favorites")
                    addElement("votes")
                }
            }

        override fun serialize(output: Encoder, obj: AllData) {
            val output = output.beginStructure(descriptor)
            output.encodeNullableSerializableElement(descriptor, 0, NullableSerializer(ArrayListSerializer(Speaker.serializer)), obj.speakers)
            output.endStructure(descriptor)
        }

        override fun deserialize(input: Decoder): AllData {
            val input = input.beginStructure(descriptor)
            var local2: List<Speaker>? = null
            var bitMask: Int = 0
            mainLoop@while (true) {
                val idx = input.decodeElementIndex(descriptor)
                when (idx) {
                    -1 -> {
                        break@mainLoop
                    }
                    0 -> {
                        local2 = input.decodeNullableSerializableElement(descriptor, 2, NullableSerializer(ArrayListSerializer(Speaker.serializer)))
                        bitMask = bitMask or 1
                    }
                }
            }
            input.endStructure(descriptor)
            if (bitMask and 1 == 0) {
                local2 = null
            }
            return AllData(local2)
        }
    }
    companion object {
        fun serializer() = serializer
    }
}
