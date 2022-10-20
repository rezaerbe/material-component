package com.erbeandroid.materialcomponent.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentDialogBinding
import com.erbeandroid.materialcomponent.util.showSnackBar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogFragment : Fragment() {

    private var _binding: FragmentDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.alertDialog.setOnClickListener {
            // R.style.ThemeOverlay_App_MaterialAlertDialog
            MaterialAlertDialogBuilder(
                requireContext()
            )
                .setTitle(resources.getString(R.string.title))
                .setMessage(resources.getString(R.string.supporting_text))
                .setNeutralButton(resources.getString(R.string.cancel)) { _, _ ->
                    // Respond to neutral button press
                    showSnackBar(binding.container, "Respond to neutral button press")
                }
                .setNegativeButton(resources.getString(R.string.decline)) { _, _ ->
                    // Respond to negative button press
                    showSnackBar(binding.container, "Respond to negative button press")
                }
                .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                    // Respond to positive button press
                    showSnackBar(binding.container, "Respond to positive button press")
                }
                .show()
        }

        binding.simpleDialog.setOnClickListener {
            val items = arrayOf("Item 1", "Item 2", "Item 3")

            // R.style.ThemeOverlay_App_MaterialAlertDialog
            MaterialAlertDialogBuilder(
                requireContext()
            )
                .setTitle(resources.getString(R.string.title))
                .setItems(items) { _, which ->
                    // Respond to item chosen
                    showSnackBar(binding.container, "Respond to item $which chosen")
                }
                .show()
        }

        binding.confirmationDialogSingle.setOnClickListener {
            val singleItems = arrayOf("Item 1", "Item 2", "Item 3")
            val checkedItem = 1

            // R.style.ThemeOverlay_App_MaterialAlertDialog
            MaterialAlertDialogBuilder(
                requireContext()
            )
                .setTitle(resources.getString(R.string.title))
                .setNeutralButton(resources.getString(R.string.cancel)) { _, _ ->
                    // Respond to neutral button press
                    showSnackBar(binding.container, "Respond to neutral button press")
                }
                .setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                    // Respond to positive button press
                    showSnackBar(binding.container, "Respond to positive button press")
                }
                // Single-choice items (initialized with checked item)
                .setSingleChoiceItems(singleItems, checkedItem) { _, which ->
                    // Respond to item chosen
                    showSnackBar(binding.container, "Respond to item $which chosen")
                }
                .show()
        }

        binding.confirmationDialogMulti.setOnClickListener {
            val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
            val checkedItems = booleanArrayOf(true, false, false, false)

            // R.style.ThemeOverlay_App_MaterialAlertDialog
            MaterialAlertDialogBuilder(
                requireContext()
            )
                .setTitle(resources.getString(R.string.title))
                .setNeutralButton(resources.getString(R.string.cancel)) { _, _ ->
                    // Respond to neutral button press
                    showSnackBar(binding.container, "Respond to neutral button press")
                }
                .setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                    // Respond to positive button press
                    showSnackBar(binding.container, "Respond to positive button press")
                }
                // Multi-choice items (initialized with checked items)
                .setMultiChoiceItems(multiItems, checkedItems) { _, which, checked ->
                    // Respond to item chosen
                    showSnackBar(
                        binding.container,
                        "Respond to item $which ${if (checked) "checked" else "unchecked"}"
                    )
                }
                .show()
        }

        binding.fullScreenDialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {

        val isLargeLayout = resources.getBoolean(R.bool.large_layout)

        val fragmentManager = requireActivity().supportFragmentManager
        val newFragment = CustomDialogFragment()
        if (isLargeLayout) {
            // The device is using a large layout, so show the fragment as a dialog
            newFragment.show(fragmentManager, "dialog")
        } else {
            // The device is smaller, so show the fragment fullscreen
            val transaction = fragmentManager.beginTransaction()
            // For a little polish, specify a transition animation
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            // To make it fullscreen, use the 'content' root view as the container
            // for the fragment, which is always the root view for the activity
            transaction
                .add(android.R.id.content, newFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
