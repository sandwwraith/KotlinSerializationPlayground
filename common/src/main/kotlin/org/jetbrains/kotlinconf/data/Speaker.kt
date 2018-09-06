package org.jetbrains.kotlinconf.data

import kotlinx.serialization.*
import kotlinx.serialization.internal.*

//@Serializable
//data class Speaker(
//    val firstName: String?,
////    val lastName: String,
////    val profilePicture: String,
////    val sessions: List<Int>,
////    val tagLine: String,
////    val isTopSpeaker: Boolean,
////    val bio: String,
////    val fullName: String,
//    val links: List<Link?>?
////    val id: String
//)

data class Speaker(
    val firstName: String?,
    val lastName: String?,
    val profilePicture: String?,
    val sessions: List<Int?>?,
    val tagLine: String?,
    val isTopSpeaker: Boolean?,
    val bio: String?,
    val fullName: String?,
    val links: List<Link?>?,
    val id: String?
) {
    @Suppress("NAME_SHADOWING")
    object serializer : KSerializer<Speaker> {
        override val descriptor: SerialDescriptor =
            object : SerialClassDescImplTagged("org.jetbrains.kotlinconf.data.Speaker") {
                init {
                    addElement("firstName")
                    addElement("lastName")
                    addElement("profilePicture")
                    addElement("sessions")
                    addElement("tagLine")
                    addElement("isTopSpeaker")
                    addElement("bio")
                    addElement("fullName")
                    addElement("links")
                    addElement("id")
                }
            }

        override fun serialize(output: Encoder, obj: Speaker) {
            val output = output.beginStructure(descriptor)
            output.encodeNullableSerializableElement(descriptor, 0, NullableSerializer(StringSerializer), obj.firstName)
            output.encodeNullableSerializableElement(descriptor, 1, NullableSerializer(StringSerializer), obj.lastName)
            output.encodeNullableSerializableElement(descriptor, 2, NullableSerializer(StringSerializer), obj.profilePicture)
            output.encodeNullableSerializableElement(descriptor, 3, NullableSerializer(ArrayListSerializer(NullableSerializer(IntSerializer))), obj.sessions)
            output.encodeNullableSerializableElement(descriptor, 4, NullableSerializer(StringSerializer), obj.tagLine)
            output.encodeNullableSerializableElement(descriptor, 5, NullableSerializer(BooleanSerializer), obj.isTopSpeaker)
            output.encodeNullableSerializableElement(descriptor, 6, NullableSerializer(StringSerializer), obj.bio)
            output.encodeNullableSerializableElement(descriptor, 7, NullableSerializer(StringSerializer), obj.fullName)
            output.encodeNullableSerializableElement(descriptor, 8, NullableSerializer(ArrayListSerializer(NullableSerializer(Link.serializer))), obj.links)
            output.encodeNullableSerializableElement(descriptor, 9, NullableSerializer(StringSerializer), obj.id)
            output.endStructure(descriptor)
        }

        override fun deserialize(input: Decoder): Speaker {
            val input = input.beginStructure(descriptor)
            var local0: String? = null
            var local1: String? = null
            var local2: String? = null
            var local3: List<Int?>? = null
            var local4: String? = null
            var local5: Boolean? = null
            var local6: String? = null
            var local7: String? = null
            var local8: List<Link?>? = null
            var local9: String? = null
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
                    3 -> {
                        local3 = input.decodeNullableSerializableElement(descriptor, 3, NullableSerializer(ArrayListSerializer(NullableSerializer(IntSerializer))))
                        bitMask = bitMask or 8
                    }
                    4 -> {
                        local4 = input.decodeNullableSerializableElement(descriptor, 4, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 16
                    }
                    5 -> {
                        local5 = input.decodeNullableSerializableElement(descriptor, 5, NullableSerializer(BooleanSerializer))
                        bitMask = bitMask or 32
                    }
                    6 -> {
                        local6 = input.decodeNullableSerializableElement(descriptor, 6, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 64
                    }
                    7 -> {
                        local7 = input.decodeNullableSerializableElement(descriptor, 7, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 128
                    }
                    8 -> {
                        local8 = input.decodeNullableSerializableElement(descriptor, 8, NullableSerializer(ArrayListSerializer(NullableSerializer(Link.serializer))))
                        bitMask = bitMask or 256
                    }
                    9 -> {
                        local9 = input.decodeNullableSerializableElement(descriptor, 9, NullableSerializer(StringSerializer))
                        bitMask = bitMask or 512
                    }
                }
            }
            input.endStructure(descriptor)
            if (bitMask and 1 == 0) {
                throw MissingFieldException("firstName")
            }
            if (bitMask and 2 == 0) {
                throw MissingFieldException("lastName")
            }
            if (bitMask and 4 == 0) {
                throw MissingFieldException("profilePicture")
            }
            if (bitMask and 8 == 0) {
                throw MissingFieldException("sessions")
            }
            if (bitMask and 16 == 0) {
                throw MissingFieldException("tagLine")
            }
            if (bitMask and 32 == 0) {
                throw MissingFieldException("isTopSpeaker")
            }
            if (bitMask and 64 == 0) {
                throw MissingFieldException("bio")
            }
            if (bitMask and 128 == 0) {
                throw MissingFieldException("fullName")
            }
            if (bitMask and 256 == 0) {
                throw MissingFieldException("links")
            }
            if (bitMask and 512 == 0) {
                throw MissingFieldException("id")
            }
            return Speaker(local0, local1, local2, local3, local4, local5, local6, local7, local8, local9)
        }
    }
    companion object {
        fun serializer() = serializer
    }
}
