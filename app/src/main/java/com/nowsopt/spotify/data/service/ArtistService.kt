package com.nowsopt.spotify.data.service

import com.nowsopt.spotify.data.model.BaseResponse
import com.nowsopt.spotify.presentation.main.artist.model.ArtistDetailResponse
import com.nowsopt.spotify.presentation.main.artist.model.Songs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistService {
    @GET("v1/api/artists/{artistsId}/songs/popular")
    suspend fun getChartTopper(
        @Path("artistsId") artistsId: Int
    ): Response<BaseResponse<Songs>>

    @GET("v1/api/artists/{artistId}")
    suspend fun getArtistDetail(
        @Path("artistId") artistId: Int
    ): Response<BaseResponse<ArtistDetailResponse>>
}
