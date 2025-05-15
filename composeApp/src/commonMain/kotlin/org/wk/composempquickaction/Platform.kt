package org.wk.composempquickaction

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform