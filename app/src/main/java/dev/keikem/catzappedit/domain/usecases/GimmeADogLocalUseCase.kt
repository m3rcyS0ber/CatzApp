package dev.keikem.catzappedit.domain.usecases

import dev.keikem.catzappedit.data.repository.DogRepository

class GimmeADogLocalUseCase {

    private val repository: DogRepository = DogRepository()

    fun gimme(): String? = repository.loadFromLocal()
}