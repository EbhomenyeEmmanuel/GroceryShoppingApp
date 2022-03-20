package com.noobject01.groceryshoppingapp.navigation

import androidx.annotation.StringRes
import com.noobject01.groceryshoppingapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object HomeScreen : Screen("home", R.string.home)
    object CategoriesScreen : Screen("categories", R.string.categories)
    object CategoriesTypeScreen : Screen("categoriesType", R.string.categories_type)
    object OrderScreen : Screen("order", R.string.order)
    object CartScreen : Screen("cart", R.string.cart)
    object OfferScreen : Screen("offer", R.string.offer)
    object MoreScreen : Screen("more", R.string.more)
}