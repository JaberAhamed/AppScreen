package org.mj.appscreens.ui.extension

import android.content.Context
import androidx.compose.ui.unit.Dp

fun Dp.toPx(context: Context): Float {
    val density = context.resources.displayMetrics.density

    return (this.value) * density
}