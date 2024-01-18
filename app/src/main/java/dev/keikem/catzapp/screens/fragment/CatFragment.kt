package dev.keikem.catzapp.screens.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import dev.keikem.catzapp.R
import dev.keikem.catzapp.domain.usecases.GimmeACatLocalUseCase
import dev.keikem.catzapp.domain.usecases.GimmeACatRemoteUseCase

//Фрагмент, показывающии котика
class CatFragment : Fragment(R.layout.fragment_cat) {

    private val gimmeACatRemoteUseCase: GimmeACatRemoteUseCase by lazy { GimmeACatRemoteUseCase() }
    private val gimmeACatLocalUseCase: GimmeACatLocalUseCase by lazy { GimmeACatLocalUseCase() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.image)

        //Thread - отдельный поток выполнения, он отвечает за то где будет выполнятся операция
        Thread {
            image.load(gimmeACatLocalUseCase.gimme(requireContext()))
            val imageUrl = gimmeACatRemoteUseCase.gimme(requireContext())
            image.load(imageUrl)
        }.start()
    }

}