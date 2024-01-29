package dev.keikem.catzappedit.data.api

import dev.keikem.catzappedit.data.remote.RemoteCat
import dev.keikem.catzappedit.data.remote.RemoteDog
import retrofit2.Call
import retrofit2.http.GET

interface DogsApi {

    @GET("/api/breeds/image/random")
    suspend fun getDog(): RemoteDog?
}