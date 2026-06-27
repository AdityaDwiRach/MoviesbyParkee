package id.adr.mobile.moviesbyparkee.utils

import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun Toolbar.applyStatusBarPadding() {
    val initialTopPadding = paddingTop

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top

        view.setPadding(
            view.paddingLeft,
            initialTopPadding + statusBarHeight,
            view.paddingRight,
            view.paddingBottom
        )

        insets
    }

    ViewCompat.requestApplyInsets(this)
}