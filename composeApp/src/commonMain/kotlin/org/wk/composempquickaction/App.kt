package org.wk.composempquickaction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.wk.composempquickaction.utils.AppQuickActionHandler

@Composable
@Preview
fun App() {

    val quickActionMessage = AppQuickActionHandler.quickActionState.collectAsStateWithLifecycle()
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            quickActionMessage.value?.ifEmpty { "Hello World!" }?.let { Text(text = it) }
        }
    }
}