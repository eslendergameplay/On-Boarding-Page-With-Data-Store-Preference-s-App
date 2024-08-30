package com.example.jetpack8.onboardviews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpack8.data.PageData
import com.example.jetpack8.dataStore.StoreBoarding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(item:List<PageData>,pagerState:PagerState,modifier:Modifier = Modifier,navC:NavController,store:StoreBoarding){
    Box (modifier = modifier){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
           HorizontalPager(state = pagerState) { page ->
               Column (modifier = Modifier
                   .padding(60.dp)
                   .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                   LoaderData(modifier = Modifier
                       .size(200.dp)
                       .fillMaxWidth()
                       .align(alignment = Alignment.CenterHorizontally), image = item[page].image)
                   Text(text = item[page].titulo,modifier = Modifier.padding(top = 50.dp),
                       color = Color.Black, style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Bold)
                   Text(
                       text = item[page].desc,
                       color = Color.Black,
                       textAlign = TextAlign.Center,
                       fontWeight = FontWeight.Light,
                       fontSize = 20.sp
                   )
                   PagerIndicator(size = item.size, currentPage = pagerState.currentPage)

               }

           }
        }
        Box (modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp)){
            ButtonFinish(currentPage = pagerState.currentPage, navC = navC, store = store)

        }
    }
}