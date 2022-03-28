package com.noobject01.groceryshoppingapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noobject01.groceryshoppingapp.ui.theme.MainGreen

@Composable
fun CategoriesScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarSection(icon = Icons.Filled.KeyboardArrowLeft) { navController.popBackStack() } }
    ) {
        Box(
            modifier = Modifier
                .background(color = MainGreen)
                .wrapContentSize()
                .verticalScroll(state = rememberScrollState()),
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
                        .padding( top = 16.dp)
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                        )
                        .background(Color.White)
                ) {
                }
            }
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
