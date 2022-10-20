package com.erbeandroid.materialcomponent.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.BottomNavigationBinding
import com.erbeandroid.materialcomponent.databinding.ContentBottomNavigationBinding
import com.erbeandroid.materialcomponent.databinding.FragmentBottomNavigationBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class BottomNavigationFragment : Fragment() {

    private var _binding: FragmentBottomNavigationBinding? = null

    private val binding get() = _binding!!

    private var _bottomNavigationBinding: BottomNavigationBinding? = null

    private val bottomNavigationBinding get() = _bottomNavigationBinding!!

    private var _contentBinding: ContentBottomNavigationBinding? = null

    private val contentBinding get() = _contentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomNavigationBinding.inflate(layoutInflater, container, false)
        _bottomNavigationBinding = BottomNavigationBinding.bind(binding.root)
        _contentBinding = ContentBottomNavigationBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationBinding.bottomNavigation.selectedItemId = R.id.page_1

        bottomNavigationBinding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 1 click",
                        bottomNavigationBinding.bottomNavigation
                    )
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 2 click",
                        bottomNavigationBinding.bottomNavigation
                    )
                    true
                }
                R.id.page_3 -> {
                    // Respond to navigation item 3 click
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 3 click",
                        bottomNavigationBinding.bottomNavigation
                    )
                    true
                }
                R.id.page_4 -> {
                    // Respond to navigation item 4 click
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 4 click",
                        bottomNavigationBinding.bottomNavigation
                    )
                    true
                }
                else -> false
            }
        }

        bottomNavigationBinding.bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 reselection
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 1 reselection",
                        bottomNavigationBinding.bottomNavigation
                    )
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 reselection
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 2 reselection",
                        bottomNavigationBinding.bottomNavigation
                    )
                }
                R.id.page_3 -> {
                    // Respond to navigation item 3 reselection
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 3 reselection",
                        bottomNavigationBinding.bottomNavigation
                    )
                }
                R.id.page_4 -> {
                    // Respond to navigation item 4 reselection
                    showSnackBar(
                        binding.container,
                        "Respond to navigation item 4 reselection",
                        bottomNavigationBinding.bottomNavigation
                    )
                }
            }
        }

        val badge1 = bottomNavigationBinding.bottomNavigation.getOrCreateBadge(R.id.page_1)
        val badge2 = bottomNavigationBinding.bottomNavigation.getOrCreateBadge(R.id.page_2)
        val badge3 = bottomNavigationBinding.bottomNavigation.getOrCreateBadge(R.id.page_3)

        badge1.isVisible = true
        badge2.isVisible = true
        badge3.isVisible = true

        // An icon only badge will be displayed unless a number is set:
        badge1.number = 9999
        badge2.number = 999

/*        val badgeDrawable = binding.bottomNavigation.getBadge(R.id.page_1)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }*/

        // bottomNavigationBinding.bottomNavigation.removeBadge(R.id.page_1)

        contentBinding.content.setOnClickListener {
            // Respond to content click
            showSnackBar(
                binding.container,
                "Respond to content click",
                bottomNavigationBinding.bottomNavigation
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _contentBinding = null
        _bottomNavigationBinding = null
        _binding = null
    }
}
