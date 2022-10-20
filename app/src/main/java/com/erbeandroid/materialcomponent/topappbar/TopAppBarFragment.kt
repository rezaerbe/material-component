package com.erbeandroid.materialcomponent.topappbar

import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.ContentTopAppBarBinding
import com.erbeandroid.materialcomponent.databinding.FragmentTopAppBarBinding
import com.erbeandroid.materialcomponent.databinding.TopAppBarRegularBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class TopAppBarFragment : Fragment() {

    private var _binding: FragmentTopAppBarBinding? = null

    private val binding get() = _binding!!

    private var _topAppBarBinding: TopAppBarRegularBinding? = null

    private val topAppBarBinding get() = _topAppBarBinding!!

    private var _contentBinding: ContentTopAppBarBinding? = null

    private val contentBinding get() = _contentBinding!!

    private var actionMode: ActionMode? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopAppBarBinding.inflate(layoutInflater, container, false)
        _topAppBarBinding = TopAppBarRegularBinding.bind(binding.root)
        _contentBinding = ContentTopAppBarBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topAppBarBinding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            showSnackBar(binding.container, "Handle navigation icon press")
        }

        topAppBarBinding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    // Handle favorite icon press
                    showSnackBar(binding.container, "Handle favorite icon press")
                    true
                }
                R.id.search -> {
                    // Handle search icon press
                    showSnackBar(binding.container, "Handle search icon press")
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    showSnackBar(
                        binding.container,
                        "Handle more item (inside overflow menu) press"
                    )
                    true
                }
                else -> false
            }
        }

        contentBinding.content.setOnClickListener {
            // Respond to content click
            showSnackBar(binding.container, "Respond to content click")
        }

        val primaryVariantColor =
            themeColor(requireContext(), com.google.android.material.R.attr.colorPrimaryVariant)

        val actionModeColor = Color.BLACK

        val callback = object : ActionMode.Callback {

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                switchStatusColor(
                    requireActivity(),
                    view,
                    false,
                    primaryVariantColor,
                    actionModeColor
                )
                requireActivity().menuInflater.inflate(R.menu.contextual_action_bar, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.share -> {
                        // Handle share icon press
                        showSnackBar(binding.container, "Handle share icon press")
                        true
                    }
                    R.id.delete -> {
                        // Handle delete icon press
                        showSnackBar(binding.container, "Handle delete icon press")
                        true
                    }
                    R.id.more -> {
                        // Handle more item (inside overflow menu) press
                        showSnackBar(
                            binding.container,
                            "Handle more item (inside overflow menu) press"
                        )
                        true
                    }
                    else -> false
                }
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                switchStatusColor(
                    requireActivity(),
                    view,
                    true,
                    actionModeColor,
                    primaryVariantColor
                )
                actionMode = null
            }
        }

        contentBinding.content.setOnLongClickListener {
            actionMode = (requireActivity() as AppCompatActivity).startSupportActionMode(callback)
            actionMode?.title = "Content selected"
            true
        }
    }

    private fun themeColor(context: Context, @AttrRes attrRes: Int): Int {
        return TypedValue().apply {
            context.theme.resolveAttribute(
                attrRes, this, true
            )
        }.data
    }

    private fun switchStatusColor(
        activity: Activity,
        view: View,
        lightStatusBar: Boolean,
        colorFrom: Int,
        colorTo: Int
    ) {
        ValueAnimator.ofArgb(colorFrom, colorTo).apply {
            duration = 300
            addUpdateListener {
                activity.window.statusBarColor = it.animatedValue as Int
                WindowInsetsControllerCompat(
                    activity.window,
                    view
                ).isAppearanceLightStatusBars = lightStatusBar
            }
            start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _contentBinding = null
        _topAppBarBinding = null
        _binding = null
    }
}
