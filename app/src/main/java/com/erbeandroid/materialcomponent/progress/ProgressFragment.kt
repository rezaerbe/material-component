package com.erbeandroid.materialcomponent.progress

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentProgressBinding
import com.google.android.material.progressindicator.LinearProgressIndicator

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.linearIndeterminateProgress.setIndicatorColor(*resources.getIntArray(R.array.progress_colors))
        binding.linearIndeterminateProgress.indeterminateAnimationType =
            LinearProgressIndicator.INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS

        var count = 0
        val timer = object : CountDownTimer(5000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                count += 10
                binding.linearProgress.progress = count
                binding.circularProgress.progress = count
            }

            override fun onFinish() {
                binding.linearProgress.hide()
                binding.circularProgress.hide()
            }
        }

        timer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}