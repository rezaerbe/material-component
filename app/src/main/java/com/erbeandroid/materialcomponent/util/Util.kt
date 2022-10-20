package com.erbeandroid.materialcomponent.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(view: View, text: String, anchor: View? = null) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAnchorView(anchor).show()
}
