package com.nowsopt.spotify.presentation.main.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private var _currentTab: MutableStateFlow<HomeTab> = MutableStateFlow(HomeTab.MAIN)
    val currentTab: StateFlow<HomeTab> = _currentTab

    fun setCurrentTab(tab: HomeTab) {
        _currentTab.value = tab
    }
}

enum class HomeTab {
    MAIN,
    PREFERENCE
}
