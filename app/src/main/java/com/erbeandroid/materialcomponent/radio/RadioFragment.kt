package com.erbeandroid.materialcomponent.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentRadioBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class RadioFragment : Fragment() {

    private var _binding: FragmentRadioBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRadioBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Returns View.NO_ID if nothing is checked.
        // val checkedRadioButtonId = binding.radioGroup.checkedRadioButtonId

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // Responds to child RadioButton checked/unchecked
            when (checkedId) {
                R.id.radio_button_1 -> {
                    showSnackBar(group, "Radio Button 1")
                }
                R.id.radio_button_2 -> {
                    showSnackBar(group, "Radio Button 2")
                }
                R.id.radio_button_3 -> {
                    showSnackBar(group, "Radio Button 3")
                }
            }
        }

        // To check a radio button
        binding.radioButton1.isChecked = true

/*        // To listen for a radio button's checked/unchecked state changes
        binding.radioButton1.setOnCheckedChangeListener { buttonView, isChecked ->
            // Responds to radio button being checked/unchecked
            showSnackBar(
                binding.radioGroup,
                "${buttonView.text} ${if (isChecked) "Checked" else "Unchecked"}"
            )
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}