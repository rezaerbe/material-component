package com.erbeandroid.materialcomponent.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.ModalBottomSheetContentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {

    private var _binding: ModalBottomSheetContentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use this to programmatically apply behavior attributes
        val modalBottomSheetBehavior = (dialog as BottomSheetDialog).behavior

        binding.bottomSheet.post {
            modalBottomSheetBehavior.peekHeight = binding.bottomSheet.measuredHeight
            binding.modalBottomSheet.updateLayoutParams {
                height = 3 * binding.bottomSheet.measuredHeight
            }
        }

        modalBottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL

        binding.bottomSheetButton.setOnClickListener {
            if (modalBottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                modalBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                modalBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Do something for new state.
                when (modalBottomSheetBehavior.state) {
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
        modalBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)

        // To remove the callback:
        // modalBottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}