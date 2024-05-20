package com.nowsopt.spotify.presentation.main.artist.chart

import androidx.lifecycle.ViewModel

class ChartTopperViewModel: ViewModel() {
    val chartTopperData = listOf(
        ChartTopperModel(
            number = 1,
            imageUrl = "imageUrl",
            title = "title1",
            like = 2022950208
        ),
        ChartTopperModel(
            number = 2,
            imageUrl = "imageUrl",
            title = "title2",
            like = 2022950208
        ),
        ChartTopperModel(
            number = 3,
            imageUrl = "imageUrl",
            title = "title3",
            like = 2022950208
        ),
        ChartTopperModel(
            number = 4,
            imageUrl = "imageUrl",
            title = "title4",
            like = 2022950208
        ),
        ChartTopperModel(
            number = 5,
            imageUrl = "imageUrl",
            title = "title5",
            like = 2022950208
        )
    )
}