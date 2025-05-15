package org.wk.composempquickaction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.wk.composempquickaction.utils.AppQuickActionHandler

@Composable
@Preview
fun App() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val quickActionMessage = AppQuickActionHandler.quickActionState.collectAsStateWithLifecycle()
    val platformName = remember { PlatformProvider().getPlatformName() }

    MaterialTheme {
        Scaffold(
            scaffoldState = scaffoldState, floatingActionButton = {
                if (platformName == "iOS") {
                    FloatingActionButton(
                        onClick = {
                            sendEmail(
                                to = "waheedkhan6446@gmail.com",
                                subject = "KMM",
                                body = "I love KMM",
                                onError = { errorMessage->
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar(
                                            message = errorMessage,
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                })
                        },
                        content = {
                            Icon(
                                Icons.Filled.Email,
                                contentDescription = "email",
                                tint = MaterialTheme.colors.background
                            )
                        }, backgroundColor = MaterialTheme.colors.onBackground
                    )
                }
            }) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                quickActionMessage.value?.ifEmpty { "Hello World!" }?.let { Text(text = it) }
            }
        }

    }
}