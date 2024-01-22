package dev.keikem.catzapp.screens.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.keikem.catzapp.domain.usecases.GimmeACatLocalUseCase
import dev.keikem.catzapp.domain.usecases.GimmeACatRemoteUseCase

class CatViewModel : ViewModel() {

    private val gimmeACatRemoteUseCase: GimmeACatRemoteUseCase by lazy { GimmeACatRemoteUseCase() }
    private val gimmeACatLocalUseCase: GimmeACatLocalUseCase by lazy { GimmeACatLocalUseCase() }

    init {
        load()
    }

    private var _imageUrl: MutableLiveData<String> = MutableLiveData("")
    val imageUrl: LiveData<String> = _imageUrl

    private fun load() {
        //Thread - отдельный поток выполнения, он отвечает за то где будет выполнятся операция
        Thread {
            Thread.sleep(5000)
            _imageUrl.postValue(gimmeACatRemoteUseCase.gimme())
        }.start()
    }
}