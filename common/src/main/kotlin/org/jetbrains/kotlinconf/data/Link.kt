package org.jetbrains.kotlinconf.data

import kotlinx.serialization.*
import kotlinx.serialization.internal.*

//@Serializable
//data class Link(
//    val linkType: String?,
//    val title: String?,
//    val url: String?
//)

data class Link(
    val linkType: String?,
    val title: String?,
    val url: String?
) {
    @Suppress("NAME_SHADOWING")
    object serializer : KSerializer<Link> {
        override val descriptor : SerialDescriptor =
            object : SerialClassDescImpl("org.jetbrains.kotlinconf.data.Link") {
                init {
                    addElement("linkType")
                    addElement("title")
                    addElement("url")
                }
            }

        override fun serialize(output: Encoder, obj: Link) {
            val output = output.beginStructure(descriptor)
            output.encodeNullableSerializableElement(descriptor, 0, NullableSerializer(StringSerializer), obj.linkType)
            output.encodeNullableSerializableElement(descriptor, 1, NullableSerializer(StringSerializer), obj.title)
            output.encodeNullableSerializableElement(descriptor, 2, NullableSerializer(StringSerializer), obj.url)
            output.endStructure(descriptor)
        }

        override fun deserialize(input: Decoder): Link {
            val input = input.beginStructure(descriptor)
            var local0: String? = null
            var local1: String? = null
            var local2: String? = null
            var bitMask: Int = 0
            mainLoop@while (true) {
                val idx = input.decodeElementIndex(descriptor)
                when (idx) {
                    -1 -> {
                        break@mainLoop
                    }
                    0 -> {
                        local0 = input.decodeNullableSerializableElement(descriptor, 0, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 1
                    }
                    1 -> {
                        local1 = input.decodeNullableSerializableElement(descriptor, 1, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 2
                    }
                    2 -> {
                        local2 = input.decodeNullableSerializableElement(descriptor, 2, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 4
                    }
                }
            }
            input.endStructure(descriptor)
            if (bitMask and 1 == 0) {
                throw MissingFieldException("linkType")
            }
            if (bitMask and 2 == 0) {
                throw MissingFieldException("title")
            }
            if (bitMask and 4 == 0) {
                throw MissingFieldException("url")
            }
            return Link(local0, local1, local2)
        }
    }
    companion object {
        fun serializer() = serializer
    }
}
