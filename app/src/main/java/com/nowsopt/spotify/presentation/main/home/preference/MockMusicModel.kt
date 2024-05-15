package com.nowsopt.spotify.presentation.main.home.preference

// 서버 통신 DTO와 맞춰서 수정 필요
data class MockMusicModel(
    val title: String,
    val artist: String,
    val album: String,
    val imageUrl: String,
    val isBookmark: Boolean
)
