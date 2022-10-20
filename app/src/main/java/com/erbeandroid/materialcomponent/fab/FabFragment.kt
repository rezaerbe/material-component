package com.erbeandroid.materialcomponent.fab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.databinding.FabBinding
import com.erbeandroid.materialcomponent.databinding.FragmentFabBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class FabFragment : Fragment() {

    private var _binding: FragmentFabBinding? = null

    private val binding get() = _binding!!

    private var _fabBinding: FabBinding? = null

    private val fabBinding get() = _fabBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFabBinding.inflate(layoutInflater, container, false)
        _fabBinding = FabBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabBinding.floatingActionButton.setOnClickListener {
            // Respond to FAB click
            showSnackBar(binding.container, "Respond to FAB click")
        }

        fabBinding.miniFloatingActionButton.setOnClickListener {
            // Respond to Mini FAB click
            showSnackBar(binding.container, "Respond to Mini FAB click")
        }

        fabBinding.extendedFloatingActionButton.setOnClickListener {
            // Respond to Extended FAB click
            showSnackBar(binding.container, "Respond to Extended FAB click")
        }

/*        // To show FAB:
        fabBinding.floatingActionButton.show()
        // To hide FAB:
        fabBinding.floatingActionButton.hide()

        // To show Mini FAB:
        fabBinding.miniFloatingActionButton.show()
        // To hide Mini FAB:
        fabBinding.miniFloatingActionButton.hide()

        // To show Extended FAB:
        fabBinding.extendedFloatingActionButton.show()
        // To hide Extended FAB:
        fabBinding.extendedFloatingActionButton.hide()

        // To extend Extended FAB:
        fabBinding.extendedFloatingActionButton.extend()
        // To shrink Extended FAB:
        fabBinding.extendedFloatingActionButton.shrink()*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fabBinding = null
        _binding = null
    }
}
