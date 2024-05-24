package com.nowsopt.spotify.data.service

import com.nowsopt.spotify.data.model.BaseResponse
import com.nowsopt.spotify.data.model.response.HitSongs
import com.nowsopt.spotify.data.model.response.Playlists
import com.nowsopt.spotify.data.model.response.PopularArtist
import retrofit2.http.GET

interface HomeMainService {
    @GET("v1/api/members/me/playlists/recommend")
    suspend fun getRecommendMix(): BaseResponse<Playlists>

    @GET("v1/api/songs/popular")
    suspend fun getTodayHitSongs(): BaseResponse<HitSongs>

    @GET("v1/api/artists/popular")
    suspend fun getPopularArtists(): BaseResponse<List<PopularArtist>>
}