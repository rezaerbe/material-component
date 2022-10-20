package com.erbeandroid.materialcomponent.bottomappbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.BottomAppBarCenterBinding
import com.erbeandroid.materialcomponent.databinding.ContentBottomAppBarBinding
import com.erbeandroid.materialcomponent.databinding.FragmentBottomAppBarBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class BottomAppBarFragment : Fragment() {

    private var _binding: FragmentBottomAppBarBinding? = null

    private val binding get() = _binding!!

    private var _bottomAppBarBinding: BottomAppBarCenterBinding? = null

    private val bottomAppBarBinding get() = _bottomAppBarBinding!!

    private var _contentBinding: ContentBottomAppBarBinding? = null

    private val contentBinding get() = _contentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomAppBarBinding.inflate(layoutInflater, container, false)
        _bottomAppBarBinding = BottomAppBarCenterBinding.bind(binding.root)
        _contentBinding = ContentBottomAppBarBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomAppBarBinding.bottomAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
            showSnackBar(
                binding.container,
                "Handle navigation icon press",
                bottomAppBarBinding.floatingActionButton
            )
        }

        bottomAppBarBinding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    showSnackBar(
                        binding.container,
                        "Handle navigation icon press",
                        bottomAppBarBinding.floatingActionButton
                    )
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    showSnackBar(
                        binding.container,
                        "Handle navigation icon press",
                        bottomAppBarBinding.floatingActionButton
                    )
                    true
                }
                else -> false
            }
        }

/*        val topEdge = BottomAppBarCutCornersTopEdge(
            bottomAppBarBinding.bottomAppBar.fabCradleMargin,
            bottomAppBarBinding.bottomAppBar.fabCradleRoundedCornerRadius,
            bottomAppBarBinding.bottomAppBar.cradleVerticalOffset
        )

        val background = bottomAppBarBinding.bottomAppBar.background as MaterialShapeDrawable
        background.shapeAppearanceModel =
            background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()*/

        bottomAppBarBinding.floatingActionButton.setOnClickListener {
            // Respond to FAB click
            showSnackBar(
                binding.container,
                "Respond to FAB click",
                bottomAppBarBinding.floatingActionButton
            )
        }

        contentBinding.content.setOnClickListener {
            // Respond to content click
            showSnackBar(
                binding.container,
                "Respond to content click",
                bottomAppBarBinding.floatingActionButton
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _contentBinding = null
        _bottomAppBarBinding = null
        _binding = null
    }
}
