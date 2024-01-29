package dev.keikem.catzappedit.domain.usecases

import dev.keikem.catzappedit.data.local.entity.LocalCat
import dev.keikem.catzappedit.data.repository.CatRepository

//Класс, репрезентующии получение данных с бека и преобразование в то с чем мы работаем, а также сохранение в базу
class GimmeACatRemoteUseCase {

    private val catRepository: CatRepository = CatRepository()

    suspend fun gimme(): String? {
        val catUrl = catRepository.loadFromRemote()
//        catRepository.saveToLocal(LocalCat(id = "1", imageUrl = catUrl))
        catUrl?.let { catRepository.saveToLocal(LocalCat(id = "1", imageUrl = it)) }
        return catUrl
    }
}