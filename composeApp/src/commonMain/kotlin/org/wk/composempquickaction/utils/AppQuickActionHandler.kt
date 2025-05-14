package org.wk.composempquickaction.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object AppQuickActionHandler {

    private val _quickActionState = MutableStateFlow<String?>("")
    val quickActionState: StateFlow<String?> = _quickActionState

    fun handleQuickAction(action: String) {
        when (action) {
            "home" -> {
                _quickActionState.value = "Hello Quick Action"
            }
            else -> {
                println("Unknown Quick Action: $action")
            }
        }
    }
}