package org.wk.composempquickaction

class PlatformProvider {
    private val platform = getPlatform()

    fun getPlatformName(): String {
        return platform.name
    }
}