package dev.keikem.catzapp.domain.usecases

import dev.keikem.catzapp.DatabaseHolder
import dev.keikem.catzapp.data.repository.DogRepository

class GimmeADogLocalUseCase {

    private val repository: DogRepository = DogRepository()

    fun gimme(): String? = repository.loadFromLocal()
}