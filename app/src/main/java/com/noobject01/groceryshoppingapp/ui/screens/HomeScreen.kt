package com.noobject01.groceryshoppingapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noobject01.groceryshoppingapp.R
import com.noobject01.groceryshoppingapp.ui.theme.GroceryShoppingAppTheme
import com.noobject01.groceryshoppingapp.ui.theme.MainGreen

@Composable
fun Home(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                shape = RoundedCornerShape(50),
                backgroundColor = MainGreen,
                contentColor = Color.White
            ) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .wrapContentSize()
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Icon(Icons.Outlined.ShoppingCart, "", tint = MainGreen)
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = { BottomBarSection(navController, RoundedCornerShape(50)) },
    ) {
        Column(
            modifier = Modifier
                .background(color = MainGreen)
                .wrapContentSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderSection()
            SearchSection()
            Box( //(TODO(Align this box with Bottom Bar))
                contentAlignment = Alignment.Center, modifier = Modifier
                    .padding(top = 16.dp)
                    .wrapContentSize()
                    .clip(
                        RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(Color(0xFFf4f0ec))
            ) {
                Column(
                    modifier = Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    CategoriesSection()
                    AdvertSection()
                    PopularDealsSection()
                }
            }
        }
    }
}

@Composable
fun BottomBarSection(navController: NavController, fabShape: RoundedCornerShape) {
    var selectedState = remember {
        "home"
    }
    BottomAppBar(
        cutoutShape = fabShape,
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ),
        backgroundColor = MainGreen
    ) {
        IconButton(
            onClick = {
                selectedState = "home"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = null,
                tint = Color.White,
            )
        }

        IconButton(
            onClick = {
                selectedState = "order"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = null,
                tint = Color.White,
            )
        }

        IconButton(
            onClick = {
                selectedState = "offer"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = null,
                tint = Color.White,
            )
        }

        IconButton(
            onClick = {
                selectedState = "more"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}

@Composable
fun PopularDealsSection() {
    val rowList = listOf(
        ShoppingPopularDealsCategory(R.drawable.broccoli, "Vegetables"),
        ShoppingPopularDealsCategory(R.drawable.avocado, "Fruits"),
        ShoppingPopularDealsCategory(R.drawable.beef, "Meat"),
        ShoppingPopularDealsCategory(R.drawable.bread, "Bread"),
        ShoppingPopularDealsCategory(R.drawable.cheese, "Fish"),
        ShoppingPopularDealsCategory(R.drawable.drink, "Beer"),
        ShoppingPopularDealsCategory(R.drawable.cheese, "Cheese"),
        ShoppingPopularDealsCategory(R.drawable.ice_cream, "IceCream"),
        ShoppingPopularDealsCategory(R.drawable.milk_egg, "Milk & Egg"),
        ShoppingPopularDealsCategory(R.drawable.octopus, "Sea Food"),
        ShoppingPopularDealsCategory(R.drawable.soda, "Drinks")
    )
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(24f)
            )
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Popular Deals",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                )

                Text(
                    text = "See all",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    color = MainGreen,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(content = {
                items(rowList) { item ->
                    PopularDealsItem(item)
                }
            })

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PopularDealsItem(item: ShoppingPopularDealsCategory) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .padding(16.dp)
            .size(120.dp)
            .clip(
                RoundedCornerShape(24f)
            )
            .background(Color.White)
    ) {
        Image(painter = painterResource(id = item.categoryIcon), contentDescription = null)
    }
}

@Composable
fun AdvertSection() {
    val advertList = listOf<ShoppingAdvert>(
        ShoppingAdvert(
            R.drawable.fruit,
            "30% Discount",
            "Order any food from app \nand get the discount",
            "Order Now",
            Color(0xFFace1af)
        ), ShoppingAdvert(
            R.drawable.fruit_2,
            "22% Discount",
            "Order any fruit from app \nand get the discount",
            "Order Now", Color(0xFFffb6c1)
        )
    )
    LazyRow(content = {
        items(advertList) { advert -> ShoppingAdvertItem(advert) }
    },)
}

@Composable
fun ShoppingAdvertItem(advert: ShoppingAdvert) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
            .background(color = advert.advertBackgroundColor)
            .clip(RoundedCornerShape(8f))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = advert.advertIcon),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(14.dp)
                    .size(100.dp)
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start, modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    text = advert.advertTitle,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start,
                    color = MainGreen,
                )

                Text(
                    text = advert.advertSubtitle,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = advert.advertMessage,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    color = MainGreen,
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun SearchSection() {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .padding(top = 16.dp, bottom = 10.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth()
            .size(48.dp)
            .clip(RoundedCornerShape(32f))
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
            var text by remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = text,
                placeholder = {
                    Text(text = "Search your daily grocery food", color = Color.LightGray)
                },
                singleLine = true,
                onValueChange = {
                    text = it
                }, modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f),
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Hey,\nLets search your grocery food.",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start,
            color = Color.White,
        )

        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .padding(start = 22.dp)
                .wrapContentWidth()
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.user),
//                contentDescription = "user",
//                contentScale = ContentScale.Inside,
//                modifier = Modifier
//                    .scale(0.9f)
//            )
        }
    }

}

@Composable
fun CategoriesSection() {
    val rowList = listOf(
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

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(24f)
            )
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                )

                Text(
                    text = "See all",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    color = MainGreen,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(content = {
                items(rowList) { item ->
                    CategoryItem(item)
                }
            })

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CategoryItem(item: ShoppingCategory) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(90.dp)
                .width(100.dp)
                .clip(
                    RoundedCornerShape(24f)
                )
                .background(Color(0xFFace1af))
        ) {
            Image(
                painter = painterResource(id = item.categoryIcon),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .scale(0.9f)
                    .padding(14.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.categoryName,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, heightDp = 640, name = "Light Preview")
@Composable
fun HomePreview() {
    GroceryShoppingAppTheme {
        Home(rememberAnimatedNavController())
    }
}

data class ShoppingCategory(@DrawableRes val categoryIcon: Int, val categoryName: String)
data class ShoppingAdvert(
    @DrawableRes val advertIcon: Int,
    val advertTitle: String,
    val advertSubtitle: String,
    val advertMessage: String, val advertBackgroundColor: Color
)

data class ShoppingPopularDealsCategory(
    @DrawableRes val categoryIcon: Int,
    val categoryName: String
)
