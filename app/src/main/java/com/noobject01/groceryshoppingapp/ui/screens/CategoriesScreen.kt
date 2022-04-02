package com.noobject01.groceryshoppingapp.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noobject01.groceryshoppingapp.R
import com.noobject01.groceryshoppingapp.ui.theme.GroceryShoppingAppTheme
import com.noobject01.groceryshoppingapp.ui.theme.MainGreen

@Composable
fun CategoriesScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarSection(icon = Icons.Filled.KeyboardArrowLeft) { navController.popBackStack() } }
    ) {
        Box(
            modifier = Modifier
                .background(color = MainGreen)
                .wrapContentSize(),
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .padding(top = 4.dp)
                    .wrapContentSize()
                    .clip(
                        RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(Color(0xFFf4f0ec))
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.White)
                ) {

                    val gridList = listOf(
                        ShoppingCategory(R.drawable.broccoli, "Vegetables"),
                        ShoppingCategory(R.drawable.avocado, "Fruits"),
                        ShoppingCategory(R.drawable.beef, "Meat"),
                        ShoppingCategory(R.drawable.bread, "Bread"),
                        ShoppingCategory(R.drawable.cheese, "Fish"),
                        ShoppingCategory(R.drawable.drink, "Beer"),
                        ShoppingCategory(R.drawable.cheese, "Cheese"),
                        ShoppingCategory(R.drawable.ice_cream, "IceCream"),
                        ShoppingCategory(R.drawable.milk_egg, "Milk & Egg"),
                        ShoppingCategory(R.drawable.octopus, "Sea Food"),
                        ShoppingCategory(R.drawable.soda, "Drinks"),
                        ShoppingCategory(R.drawable.broccoli, "Vegetables"),
                        ShoppingCategory(R.drawable.avocado, "Fruits"),
                        ShoppingCategory(R.drawable.beef, "Meat"),
                        ShoppingCategory(R.drawable.bread, "Bread"),
                        ShoppingCategory(R.drawable.cheese, "Fish"),
                        ShoppingCategory(R.drawable.drink, "Beer"),
                        ShoppingCategory(R.drawable.cheese, "Cheese"),
                        ShoppingCategory(R.drawable.ice_cream, "IceCream"),
                        ShoppingCategory(R.drawable.milk_egg, "Milk & Egg"),
                        ShoppingCategory(R.drawable.octopus, "Sea Food"),
                        ShoppingCategory(R.drawable.soda, "Drinks")
                    )
                    GridSection(gridList)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridSection(categoryItems: List<ShoppingCategory>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 3),
        contentPadding = PaddingValues(10.dp, 10.dp),
    ) {
        items(categoryItems) { categoryItem ->
            CategoryItem(
                item = categoryItem, Modifier
                    .padding(start = 10.dp, top = 16.dp, end = 10.dp)
                    .wrapContentSize()
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun TopBarSection(
    title: String = "Categories",
    icon: ImageVector,
    onIconClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .background(color = MainGreen)
    ) {
        Image(
            imageVector = icon,
            contentDescription = "Top App Bar Icon",
            colorFilter = ColorFilter
                .tint(MaterialTheme.colors.onPrimary),
            modifier = Modifier
                .clickable(onClick = onIconClick)
                .padding(16.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = title,
            color = MaterialTheme.colors.onPrimary,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = 0.15.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, heightDp = 640, name = "Light Preview")
@Composable
fun CategoriesScreenPreview() {
    GroceryShoppingAppTheme {
        CategoriesScreen(rememberAnimatedNavController())
    }
}
