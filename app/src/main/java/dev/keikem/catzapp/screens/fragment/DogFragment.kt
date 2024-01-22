package dev.keikem.catzapp.screens.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import coil.load
import com.google.android.material.progressindicator.CircularProgressIndicator
import dev.keikem.catzapp.R

class DogFragment : Fragment(R.layout.fragment_cat) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.image)
        val button = view.findViewById<Button>(R.id.button)
        val progress = view.findViewById<CircularProgressIndicator>(R.id.progress)

        var viewModel: DogViewModel? = null
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED))
           viewModel = ViewModelProvider(this)[DogViewModel::class.java]

        viewModel?.imageUrl?.observe(viewLifecycleOwner) { url ->
            if (url.isNotEmpty()) {
                image.load(url)
                progress.isVisible = false
            }
        }

        button.text = "Navigate Back"

        button.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.appNavHostFragment).popBackStack()
        }
    }
}