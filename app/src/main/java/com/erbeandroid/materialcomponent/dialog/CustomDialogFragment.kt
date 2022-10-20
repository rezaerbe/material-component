package com.erbeandroid.materialcomponent.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.erbeandroid.materialcomponent.databinding.FragmentCustomDialogBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class CustomDialogFragment : DialogFragment() {

    private var _binding: FragmentCustomDialogBinding? = null

    private val binding get() = _binding!!

    /** The system calls this to get the DialogFragment's layout, regardless
     of whether it's being displayed as a dialog or an embedded fragment. */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout to use as dialog or embedded fragment
        _binding = FragmentCustomDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    /** The system calls this only when creating the layout in a dialog. */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // The only reason you might override this method when using onCreateView() is
        // to modify any dialog characteristics. For example, the dialog includes a
        // title by default, but your custom layout might not need it. So here you can
        // remove the dialog title, but you must call the superclass to get the Dialog.
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogButton.setOnClickListener {
            dismiss()
            showSnackBar(binding.container, "Dialog dismissed")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
