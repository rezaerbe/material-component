package com.erbeandroid.materialcomponent.checkbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.databinding.CheckboxBinding
import com.erbeandroid.materialcomponent.databinding.FragmentCheckboxBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class CheckboxFragment : Fragment() {

    private var _binding: FragmentCheckboxBinding? = null

    private val binding get() = _binding!!

    private var _checkboxBinding: CheckboxBinding? = null

    private val checkboxBinding get() = _checkboxBinding!!

    // private var _checkboxParentChildBinding: CheckboxParentChildBinding? = null

    // private val checkboxParentChildBinding get() = _checkboxParentChildBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckboxBinding.inflate(layoutInflater, container, false)
        _checkboxBinding = CheckboxBinding.bind(binding.root)
        // _checkboxParentChildBinding = CheckboxParentChildBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // To check a checkbox
        checkboxBinding.checkbox1.isChecked = true

        // To listen for a checkbox checked/unchecked state changes
        checkboxBinding.checkbox1.setOnCheckedChangeListener { buttonView, isChecked ->
            // Responds to checkbox being checked/unchecked
            showSnackBar(
                binding.container,
                "${buttonView.text} ${if (isChecked) "Checked" else "Unchecked"}"
            )
        }

        checkboxBinding.checkbox2.setOnCheckedChangeListener { buttonView, isChecked ->
            // Responds to checkbox being checked/unchecked
            showSnackBar(
                binding.container,
                "${buttonView.text} ${if (isChecked) "Checked" else "Unchecked"}"
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _checkboxBinding = null
        // _checkboxParentChildBinding = null
        _binding = null
    }
}
