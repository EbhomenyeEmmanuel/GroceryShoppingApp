package com.noobject01.groceryshoppingapp.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noobject01.groceryshoppingapp.R
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noobject01.groceryshoppingapp.ui.theme.GroceryShoppingAppTheme
import com.noobject01.groceryshoppingapp.ui.theme.MainGreen

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = MainGreen)
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderSection()
    }
}


@Composable
fun HeaderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
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
                .size(48.dp, 48.dp)
                .clip(RoundedCornerShape(72f))
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

@ExperimentalAnimationApi
@Preview(showBackground = true, heightDp = 640, name = "Light Preview")
@Composable
fun HomePreview() {
    GroceryShoppingAppTheme {
        Home(rememberAnimatedNavController())
    }
}