package com.erbeandroid.materialcomponent.navigationrail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentNavigationRailBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class NavigationRailFragment : Fragment() {

    private var _binding: FragmentNavigationRailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavigationRailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationRail.selectedItemId = R.id.alarms

        // Listeners are defined on the super class NavigationBarView
        // to support both NavigationRail and BottomNavigation with the \
        // same listeners
        binding.navigationRail.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.alarms -> {
                    // Respond to navigation item 1 click
                    showSnackBar(binding.container, "Respond to navigation $item click")
                    true
                }
                R.id.schedule -> {
                    // Respond to navigation item 2 click
                    showSnackBar(binding.container, "Respond to navigation $item click")
                    true
                }
                R.id.timer -> {
                    // Respond to navigation item 3 click
                    showSnackBar(binding.container, "Respond to navigation $item click")
                    true
                }
                R.id.stopwatch -> {
                    // Respond to navigation item 4 click
                    showSnackBar(binding.container, "Respond to navigation $item click")
                    true
                }
                else -> false
            }
        }

        binding.navigationRail.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.alarms -> {
                    // Respond to navigation item 1 reselection
                    showSnackBar(binding.container, "Respond to navigation $item reselection")
                }
                R.id.schedule -> {
                    // Respond to navigation item 2 reselection
                    showSnackBar(binding.container, "Respond to navigation $item reselection")
                }
                R.id.timer -> {
                    // Respond to navigation item 3 reselection
                    showSnackBar(binding.container, "Respond to navigation $item reselection")
                }
                R.id.stopwatch -> {
                    // Respond to navigation item 4 reselection
                    showSnackBar(binding.container, "Respond to navigation $item reselection")
                }
            }
        }

        binding.navigationRail.headerView?.setOnClickListener {
            showSnackBar(binding.container, "Resond to FAB click")
        }

        val badge1 = binding.navigationRail.getOrCreateBadge(R.id.alarms)
        val badge2 = binding.navigationRail.getOrCreateBadge(R.id.schedule)
        val badge3 = binding.navigationRail.getOrCreateBadge(R.id.timer)

        badge1.isVisible = true
        badge2.isVisible = true
        badge3.isVisible = true

        // An icon only badge will be displayed unless a number is set:
        badge1.number = 999
        badge2.number = 1

/*        val badgeDrawable = binding.navigationRail.getBadge(R.id.alarms)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }*/

        // binding.navigationRail.removeBadge(R.id.alarms)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}