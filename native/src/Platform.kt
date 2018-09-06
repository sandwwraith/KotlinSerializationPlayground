import kotlinx.serialization.*


@Serializable
data class ZZZ(val i: Int, val s: String)

@Serializable
data class SimpleData(val foo: String, val bar: Int, val zz: List<ZZZ> = emptyList())


