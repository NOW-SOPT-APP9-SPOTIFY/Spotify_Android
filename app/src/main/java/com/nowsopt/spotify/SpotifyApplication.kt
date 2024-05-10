package com.nowsopt.spotify

import android.app.Application
import com.nowsopt.spotify.data.ApiFactory

class SpotifyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiFactory.retrofit = ApiFactory.getRetrofit(BuildConfig.SPOTIFY_BASE_URL)
    }
}