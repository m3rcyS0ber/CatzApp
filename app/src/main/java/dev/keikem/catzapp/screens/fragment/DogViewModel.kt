package dev.keikem.catzapp.screens.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.keikem.catzapp.domain.usecases.GimmeADogUseCase

class DogViewModel : ViewModel() {

    private val gimmeADogUseCase: GimmeADogUseCase by lazy { GimmeADogUseCase() }

    init {
        load()
    }

    private val counter: MutableLiveData<Int> = MutableLiveData(0)

    private var _imageUrl: MutableLiveData<String> = MutableLiveData("")
    val imageUrl: LiveData<String> = _imageUrl

    private fun load() {
        //Thread - отдельный поток выполнения, он отвечает за то где будет выполнятся операция
        Thread {
            Thread.sleep(5000)
            _imageUrl.postValue(gimmeADogUseCase.gimme())
        }.start()
    }

    private fun increment() {
        counter.value
    }
}