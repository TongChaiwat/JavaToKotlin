package com.example.javatokotlin.extention

import android.content.Context
import androidx.core.content.ContextCompat

fun Context.getColorCompat(res: Int) = ContextCompat.getColor(this, res)