package model

import org.jetbrains.kotlinconf.data.*

val allData = AllData(

    listOf(
        Speaker(
            "a",
            "b", "http://", listOf(1), "tag", false, "", "a b",
            listOf(Link("a", "b", "c")),
            "100"
        )
        , Speaker(
            "a",
            "b", "http://", listOf(1), "tag", false, "", "a b",
            listOf(Link("a", "b", "c")),
            "100"
        )
    )
//    listOf(), listOf(), listOf()
)
