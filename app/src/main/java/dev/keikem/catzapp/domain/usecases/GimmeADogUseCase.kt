package dev.keikem.catzapp.domain.usecases

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.keikem.catzapp.data.remote.RemoteDog
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class GimmeADogUseCase {

    fun gimme() : String {
        var urlConnection: HttpsURLConnection? = null
        val imageUrl: String
        try {
            val url = URL("https://dog.ceo/api/breeds/image/random")
            urlConnection = url.openConnection() as HttpsURLConnection
            urlConnection.connect()

            val stream = urlConnection.inputStream
            val reader = BufferedReader(InputStreamReader(stream))
            val result = reader.lines().collect(Collectors.joining())
            val typeAlias = object : TypeToken<RemoteDog>() {}.type
            val convertedResult: RemoteDog = Gson().fromJson(result, typeAlias)
            imageUrl = convertedResult.message
            // val database = DatabaseHolder.provideDb(context)
            // database.catDao().set(LocalCat(id = UUID.randomUUID().toString(), imageUrl = imageUrl))

        } finally {
            urlConnection?.disconnect()
        }

        return imageUrl
    }
}