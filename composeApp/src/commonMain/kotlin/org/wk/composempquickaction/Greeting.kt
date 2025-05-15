package org.wk.composempquickaction

class Greeting {
    private val platform = getPlatform()

    fun getPlatformName(): String {
        return platform.name
    }
}