package dev.keikem.catzappedit.domain.usecases

import dev.keikem.catzappedit.data.local.entity.LocalDog
import dev.keikem.catzappedit.data.repository.DogRepository

class GimmeADogRemoteUseCase {

    private val repository: DogRepository = DogRepository()

    fun gimme(): String {
        val dogUrl = repository.loadFromRemote()
        repository.saveToLocal(LocalDog(id = "1", imageUrl = dogUrl))

        return dogUrl
    }
}