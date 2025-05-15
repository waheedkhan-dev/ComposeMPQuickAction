package org.wk.composempquickaction

expect fun sendEmail(to: String, subject: String, body: String,onError: (String) -> Unit = {})