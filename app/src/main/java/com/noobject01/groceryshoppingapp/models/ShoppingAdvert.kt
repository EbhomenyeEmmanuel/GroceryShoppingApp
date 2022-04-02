package com.noobject01.groceryshoppingapp.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class ShoppingAdvert(
    @DrawableRes val advertIcon: Int,
    val advertTitle: String,
    val advertSubtitle: String,
    val advertMessage: String, val advertBackgroundColor: Color
)
