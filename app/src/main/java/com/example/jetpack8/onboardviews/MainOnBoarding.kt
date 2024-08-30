package com.example.jetpack8.onboardviews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.jetpack8.R
import com.example.jetpack8.data.PageData
import com.example.jetpack8.dataStore.StoreBoarding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainOnBoarding(navc:NavController,store:StoreBoarding){
    val items = ArrayList<PageData>()

    items.add(PageData(R.raw.welcome,"Titulo 1","Pagina 1."))
    items.add(PageData(R.raw.car,"Titulo 2","Pagina 2."))
    items.add(PageData(R.raw.finish,"Titulo 3","Pagina 3."))

    val pagerState = rememberPagerState( pageCount = { items.size },
        initialPage = 0)

    OnBoardingPager(item = items, pagerState = pagerState,modifier = Modifier.fillMaxWidth().fillMaxHeight().background(
        Color.White) ,navC = navc, store = store)

}