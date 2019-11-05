package buu.informatics.s59160090.translateit

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import buu.informatics.s59160090.translateit.database.User

fun formatUser(nights: List<User>, resources: Resources): Spanned {
    val sb = StringBuilder()
    var num = 1
    sb.apply {
        nights.forEach {

            append("${num} \t${it.name} \t\t\t\t\t\t\t${it.score}<br>")
            append("<br>")
            num++
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}