package com.erbeandroid.materialcomponent.navigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.databinding.FragmentNavigationDrawerBinding
import com.erbeandroid.materialcomponent.databinding.NavigationDrawerBottomBinding
import com.erbeandroid.materialcomponent.databinding.NavigationDrawerModalBinding
import com.erbeandroid.materialcomponent.databinding.NavigationDrawerStandardBinding

class NavigationDrawerFragment : Fragment() {

    private var _binding: FragmentNavigationDrawerBinding? = null

    private val binding get() = _binding!!

    private var _standardBinding: NavigationDrawerStandardBinding? = null

    private val standardBinding get() = _standardBinding!!

    private var _modalBinding: NavigationDrawerModalBinding? = null

    private val modalBinding get() = _modalBinding!!

    private var _bottomBinding: NavigationDrawerBottomBinding? = null

    private val bottomBinding get() = _bottomBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavigationDrawerBinding.inflate(layoutInflater, container, false)
        // _standardBinding = NavigationDrawerStandardBinding.bind(binding.root)
        // _modalBinding = NavigationDrawerModalBinding.bind(binding.root)
        // _bottomBinding = NavigationDrawerBottomBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        standardBinding.navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            showSnackBar(binding.container, menuItem.toString())
            true
        }*/

/*        modalBinding.topAppBar.setNavigationOnClickListener {
            modalBinding.drawerLayout.open()
        }

        modalBinding.navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            showSnackBar(binding.container, menuItem.toString())
            modalBinding.drawerLayout.close()
            true
        }*/

/*        val bottomSheetBehavior = BottomSheetBehavior.from(bottomBinding.navigationView)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomBinding.bottomAppBar.setNavigationOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bottomBinding.navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            showSnackBar(binding.container, menuItem.toString(), bottomBinding.bottomAppBar)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            true
        }

        bottomBinding.scrim.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val baseColor = Color.BLACK
                // 60% opacity
                val baseAlpha = ResourcesCompat.getFloat(
                    resources,
                    com.google.android.material.R.dimen.material_emphasis_medium
                )
                // Map slideOffset from [-1.0, 1.0] to [0.0, 1.0]
                val offset = (slideOffset - (-1f)) / (1f - (-1f)) * (1f - 0f) + 0f
                val alpha = MathUtils.lerp(0f, 255f, offset * baseAlpha).toInt()
                val color = Color.argb(alpha, baseColor.red, baseColor.green, baseColor.blue)
                bottomBinding.scrim.setBackgroundColor(color)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // _standardBinding = null
        // _modalBinding = null
        // _bottomBinding = null
        _binding = null
    }
}