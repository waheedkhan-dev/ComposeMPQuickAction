package org.wk.composempquickaction.utils

class QuickActionManager {
    fun handle(action: String) {
        AppQuickActionHandler.handleQuickAction(action)
    }
}