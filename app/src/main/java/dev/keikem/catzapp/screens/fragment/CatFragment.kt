package dev.keikem.catzapp.screens.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import coil.load
import com.google.android.material.progressindicator.CircularProgressIndicator
import dev.keikem.catzapp.R

//Фрагмент, показывающии котика
class CatFragment : Fragment(R.layout.fragment_cat) {

    private object ExampleObserver : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_START -> {

                }

                else -> Unit
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.image)
        val button = view.findViewById<Button>(R.id.button)
        val progress = view.findViewById<CircularProgressIndicator>(R.id.progress)

        var viewModel: CatViewModel? = null
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED))
            viewModel = ViewModelProvider(this)[CatViewModel::class.java]


      //  val handler = Handler(Looper.getMainLooper())
      //  val runnable = {
      //      Thread.sleep(3000)
     //   }
      //  handler.post(runnable)

        viewModel?.imageUrl?.observe(viewLifecycleOwner) { url ->
            if (url.isNotEmpty()) {
                image.load(url)
                progress.isVisible = false
            }
        }

        button.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.appNavHostFragment)
                .navigate(R.id.toNextFragment)
        }

    }

}