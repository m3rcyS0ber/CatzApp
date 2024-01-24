package dev.keikem.catzapp.domain.usecases

import dev.keikem.catzapp.data.local.entity.LocalDog
import dev.keikem.catzapp.data.repository.DogRepository

class GimmeADogRemoteUseCase {

    private val repository: DogRepository = DogRepository()

    fun gimme(): String {
        val dogUrl = repository.loadFromRemote()
        repository.saveToLocal(LocalDog(id = "1", imageUrl = dogUrl))

        return dogUrl
    }
}