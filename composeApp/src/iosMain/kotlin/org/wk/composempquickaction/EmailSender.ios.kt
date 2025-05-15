package org.wk.composempquickaction

import platform.Foundation.NSCharacterSet
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.URLQueryAllowedCharacterSet
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters
import platform.UIKit.UIApplication

actual fun sendEmail(to: String, subject: String, body: String,onError: (String) -> Unit) {
    val subjectEncoded = subject.encodeForURL()
    val bodyEncoded = body.encodeForURL()

    val urlString = "mailto:$to?subject=$subjectEncoded&body=$bodyEncoded"
    val url = NSURL.URLWithString(urlString) ?: return

    if (UIApplication.sharedApplication.canOpenURL(url)) {
        UIApplication.sharedApplication.openURL(url)
    }else {
        onError("Failed to send email")
    }
}


fun String.encodeForURL(): String {
    val nsString = this as NSString
    val allowedCharacterSet = NSCharacterSet.URLQueryAllowedCharacterSet
    return nsString.stringByAddingPercentEncodingWithAllowedCharacters(allowedCharacterSet) ?: this
}