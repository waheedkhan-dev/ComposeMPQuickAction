package org.wk.composempquickaction

class IOSPlatform : Platform {
    override val name: String = "iOS"
}
actual fun getPlatform(): Platform  = IOSPlatform()