package dev.keikem.catzappedit.data.api

import dev.keikem.catzappedit.data.remote.RemoteCat
import retrofit2.http.GET

interface CatsApi {

    @GET("/v1/images/search")
    suspend fun getCat(): List<RemoteCat>?
}