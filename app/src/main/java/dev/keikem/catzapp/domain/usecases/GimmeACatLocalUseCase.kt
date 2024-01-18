package dev.keikem.catzapp.domain.usecases

import android.content.Context
import dev.keikem.catzapp.DatabaseHolder

//Класс, репрезентующии получение данных с базы и преобразование в то с чем мы работаем
class GimmeACatLocalUseCase {

    fun gimme(context: Context) : String? {
        val database = DatabaseHolder.provideDb(context)
        return database.catDao().get()?.imageUrl
    }
}