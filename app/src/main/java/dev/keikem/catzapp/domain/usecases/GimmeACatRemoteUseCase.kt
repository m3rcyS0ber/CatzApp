package dev.keikem.catzapp.domain.usecases

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.keikem.catzapp.DatabaseHolder
import dev.keikem.catzapp.data.local.Database
import dev.keikem.catzapp.data.local.entity.LocalCat
import dev.keikem.catzapp.data.remote.RemoteCat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.UUID
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

//Класс, репрезентующии получение данных с бека и преобразование в то с чем мы работаем, а также сохранение в базу
class GimmeACatRemoteUseCase {

    fun gimme() : String {
        var urlConnection: HttpsURLConnection? = null
        val imageUrl: String
        try {
            val url = URL("https://api.thecatapi.com/v1/images/search")
            urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.connect()

            val stream = urlConnection.inputStream
            val reader = BufferedReader(InputStreamReader(stream))
            val result = reader.lines().collect(Collectors.joining())
            val typeAlias = object : TypeToken<List<RemoteCat>>() {}.type
            val convertedResult: List<RemoteCat> = Gson().fromJson(result, typeAlias)
            imageUrl = convertedResult[0].url
           // val database = DatabaseHolder.provideDb(context)
           // database.catDao().set(LocalCat(id = UUID.randomUUID().toString(), imageUrl = imageUrl))

        } finally {
            urlConnection?.disconnect()
        }

        return imageUrl
    }
}