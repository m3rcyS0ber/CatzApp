package dev.keikem.catzappedit.data.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.keikem.catzappedit.DatabaseHolder
import dev.keikem.catzappedit.NetworkHolder
import dev.keikem.catzappedit.data.local.entity.LocalCat
import dev.keikem.catzappedit.data.remote.RemoteCat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class CatRepository {

    private val database = DatabaseHolder.provideDb()
    private val catsApi = NetworkHolder.provideCatApi

    suspend fun loadFromRemote(): String? = catsApi.getCat()?.get(0)?.url

//    fun loadFromRemote(): String {
//        var urlConnection: HttpsURLConnection? = null
//        val imageUrl: String
//        try {
//            val url = URL("https://api.thecatapi.com/v1/images/search")
//            urlConnection = url.openConnection() as HttpsURLConnection
//            urlConnection.connect()
//
//            val stream = urlConnection.inputStream
//            val reader = BufferedReader(InputStreamReader(stream))
//            val result = reader.lines().collect(Collectors.joining())
//            val typeAlias = object : TypeToken<List<RemoteCat>>() {}.type
//            val convertedResult: List<RemoteCat> = Gson().fromJson(result, typeAlias)
//            imageUrl = convertedResult[0].url
//        } finally {
//            urlConnection?.disconnect()
//        }
//
//        return imageUrl
//    }

    fun loadFromLocal(): String? = database?.catDao()?.get()?.imageUrl

    fun saveToLocal(cat: LocalCat) {
        database?.catDao()?.set(cat)
    }
}