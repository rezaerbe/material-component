package com.erbeandroid.materialcomponent.button

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.ButtonBinding
import com.erbeandroid.materialcomponent.databinding.CheckboxButtonBinding
import com.erbeandroid.materialcomponent.databinding.FragmentButtonBinding
import com.erbeandroid.materialcomponent.databinding.ToggleButtonBinding
import com.erbeandroid.materialcomponent.databinding.ToggleIconBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class ButtonFragment : Fragment() {

    private var _binding: FragmentButtonBinding? = null

    private val binding get() = _binding!!

    private var _buttonBinding: ButtonBinding? = null

    private val buttonBinding get() = _buttonBinding!!

    private var _toggleButtonBinding: ToggleButtonBinding? = null

    private val toggleButtonBinding get() = _toggleButtonBinding!!

    private var _toggleIconBinding: ToggleIconBinding? = null

    private val toggleIconBinding get() = _toggleIconBinding!!

    private var _checkboxBinding: CheckboxButtonBinding? = null

    private val checkboxBinding get() = _checkboxBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentButtonBinding.inflate(layoutInflater, container, false)
        _buttonBinding = ButtonBinding.bind(binding.root)
        _toggleButtonBinding = ToggleButtonBinding.bind(binding.root)
        _toggleIconBinding = ToggleIconBinding.bind(binding.root)
        _checkboxBinding = CheckboxButtonBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBinding.textButton.setOnClickListener {
            // Respond to text button press
            showSnackBar(binding.container, "Respond to text button press")
        }

        buttonBinding.outlinedButton.setOnClickListener {
            // Respond to outlined button press
            showSnackBar(binding.container, "Respond to outlined button press")
        }

        buttonBinding.containedButton.setOnClickListener {
            // Respond to contained button press
            showSnackBar(binding.container, "Respond to contained button press")
        }

        toggleButtonBinding.toggleButton.addOnButtonCheckedListener { _, checkedId, isChecked ->
            // Respond to button selection
            when (checkedId) {
                R.id.button1 -> {
                    showSnackBar(
                        binding.container,
                        "Button 1 ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
                R.id.button2 -> {
                    showSnackBar(
                        binding.container,
                        "Button 2 ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
                R.id.button3 -> {
                    showSnackBar(
                        binding.container,
                        "Button 3 ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
            }
        }

        toggleIconBinding.toggleIcon.addOnButtonCheckedListener { _, checkedId, isChecked ->
            // Respond to button selection
            when (checkedId) {
                R.id.favorite -> {
                    showSnackBar(
                        binding.container,
                        "Button Favorite ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
                R.id.eye -> {
                    showSnackBar(
                        binding.container,
                        "Button Eye ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
                R.id.notification -> {
                    showSnackBar(
                        binding.container,
                        "Button Notification ${if (isChecked) "Checked" else "Unchecked"}"
                    )
                }
            }
        }

        checkboxBinding.icon.setOnCheckedChangeListener { _, isChecked ->
            // Respond to icon toggle
            showSnackBar(
                binding.container,
                "Checkbox ${if (isChecked) "Checked" else "Unchecked"}"
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buttonBinding = null
        _toggleButtonBinding = null
        _toggleIconBinding = null
        _checkboxBinding = null
        _binding = null
    }
}
