package com.erbeandroid.materialcomponent.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetFragment : Fragment() {

    private var _binding: FragmentBottomSheetBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.modalBottomSheetButton.setOnClickListener {
            val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.show(requireActivity().supportFragmentManager, ModalBottomSheet.TAG)
        }

        // Use this to programmatically apply behavior attributes
        val standardBottomSheetBehavior = BottomSheetBehavior.from(binding.standardBottomSheet)

        binding.bottomSheet.post {
            standardBottomSheetBehavior.peekHeight = binding.bottomSheet.measuredHeight
            binding.standardBottomSheet.updateLayoutParams {
                height = 3 * binding.bottomSheet.measuredHeight
            }
        }

        standardBottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL

        binding.bottomSheetButton.setOnClickListener {
            if (standardBottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Do something for new state.
                when (standardBottomSheetBehavior.state) {
                    BottomSheetBehavior.STATE_EXPANDED ->
                        binding.bottomSheetButton.text = getString(R.string.collapse)
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        binding.bottomSheetButton.text = getString(R.string.expand)
                    else -> {}
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Do something for slide offset.
            }
        }

        // To add the callback:
        standardBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)

        // To remove the callback:
        // standardBottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}