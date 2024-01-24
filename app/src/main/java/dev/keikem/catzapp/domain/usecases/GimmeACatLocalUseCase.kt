package dev.keikem.catzapp.domain.usecases

import android.content.Context
import dev.keikem.catzapp.DatabaseHolder
import dev.keikem.catzapp.data.repository.CatRepository

//Класс, репрезентующии получение данных с базы и преобразование в то с чем мы работаем
class GimmeACatLocalUseCase {

    private val catRepository: CatRepository = CatRepository()

    fun gimme(): String? = catRepository.loadFromLocal()
}