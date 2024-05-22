package com.nowsopt.spotify.data.service

import com.nowsopt.spotify.data.model.BaseResponse
import com.nowsopt.spotify.data.model.response.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("v1/api/members/me/albums/recommend")
    suspend fun getRecommendAlbums(): BaseResponse<Albums>
}
