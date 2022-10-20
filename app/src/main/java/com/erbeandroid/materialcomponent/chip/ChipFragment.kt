package com.erbeandroid.materialcomponent.chip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.ChipChoiceBinding
import com.erbeandroid.materialcomponent.databinding.ChipInputBinding
import com.erbeandroid.materialcomponent.databinding.FragmentChipBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class ChipFragment : Fragment() {

    private var _binding: FragmentChipBinding? = null

    private val binding get() = _binding!!

    private var _chipInputBinding: ChipInputBinding? = null

    private val chipInputBinding get() = _chipInputBinding!!

    private var _chipChoiceBinding: ChipChoiceBinding? = null

    private val chipChoiceBinding get() = _chipChoiceBinding!!

/*    private var _chipFilterBinding: ChipFilterBinding? = null

    private val chipFilterBinding get() = _chipFilterBinding!!

    private var _chipActionBinding: ChipActionBinding? = null

    private val chipActionBinding get() = _chipActionBinding!!*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChipBinding.inflate(layoutInflater, container, false)
        _chipInputBinding = ChipInputBinding.bind(binding.root)
        _chipChoiceBinding = ChipChoiceBinding.bind(binding.root)
/*        _chipFilterBinding = ChipFilterBinding.bind(binding.root)
        _chipActionBinding = ChipActionBinding.bind(binding.root)*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chipInputBinding.chipInput1.setOnClickListener {
            // Responds to chip click
            showSnackBar(binding.container, "Responds to chip click")
        }

        chipInputBinding.chipInput1.setOnCloseIconClickListener {
            // Responds to chip's close icon click if one is present
            showSnackBar(binding.container, "Responds to chip's close icon click if one is present")
        }

        chipInputBinding.chipInput1.setOnCheckedChangeListener { chip, isChecked ->
            // Responds to chip checked/unchecked
            showSnackBar(
                binding.container,
                "${chip.text} ${if (isChecked) "Checked" else "Unchecked"}"
            )
        }

        // Returns View.NO_ID if singleSelection = false
        // val checkedChipId = chipInputBinding.chipGroupInput.checkedChipId
        // Returns a list of the selected chips' IDs, if any
        // val checkedChipIds = chipInputBinding.chipGroupInput.checkedChipIds

        chipChoiceBinding.chipGroupChoice.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chip_choice_1 -> {
                    showSnackBar(binding.container, "Chip 1 Checked")
                }
                R.id.chip_choice_2 -> {
                    showSnackBar(binding.container, "Chip 2 Checked")
                }
                R.id.chip_choice_3 -> {
                    showSnackBar(binding.container, "Chip 3 Checked")
                }
                else -> {
                    showSnackBar(binding.container, "All Chip Unchecked")
                }
            }
        }

        // val chipDrawable = ChipDrawable.createFromResource(context, R.xml.chip)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _chipInputBinding = null
        _chipChoiceBinding = null
/*        _chipFilterBinding = null
        _chipActionBinding = null*/
        _binding = null
    }
}
