package com.example.bestbuy

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.setVisibility(if (value) View.VISIBLE else View.GONE)
}

@BindingAdapter("android:text")
fun setText(view: View, value: Float?) {
    (view as TextView).setText(value.toString())
}

@BindingAdapter("android:text")
fun setText(view: View, value: String?) {
    (view as TextView).setText(value ?: "€")
}