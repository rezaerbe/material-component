package com.erbeandroid.materialcomponent.menu

import android.annotation.SuppressLint
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.ListPopupWindow
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.R
import com.erbeandroid.materialcomponent.databinding.FragmentMenuBinding
import com.erbeandroid.materialcomponent.databinding.MenuOverflowBinding
import com.erbeandroid.materialcomponent.databinding.MenuPopupBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    private val binding get() = _binding!!

    private var _overflowBinding: MenuOverflowBinding? = null

    private val overflowBinding get() = _overflowBinding!!

    private var _popupBinding: MenuPopupBinding? = null

    private val popupBinding get() = _popupBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        _overflowBinding = MenuOverflowBinding.bind(binding.root)
        _popupBinding = MenuPopupBinding.bind(binding.root)
        setHasOptionsMenu(true)
        // Register context menu for TextView
        registerForContextMenu(overflowBinding.menuContext)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overflowBinding.menuButton.setOnClickListener {
            showMenu(it, R.menu.overflow_menu)
        }

        val listPopupWindow = ListPopupWindow(
            requireContext(),
            null,
            com.google.android.material.R.attr.listPopupWindowStyle
        )

        // Set button as the list popup's anchor
        listPopupWindow.anchorView = popupBinding.menuPopup

        // Set list popup's content
        val items = listOf("Option 1", "Option 2", "Option 3")
        val adapter = ArrayAdapter(requireContext(), R.layout.menu_item, items)
        listPopupWindow.setAdapter(adapter)

        // Set list popup's item click listener
        listPopupWindow.setOnItemClickListener { adapterView, _, position, _ ->
            // Respond to list popup window item click.
            showSnackBar(binding.container, adapterView.getItemAtPosition(position).toString())

            // Dismiss popup.
            listPopupWindow.dismiss()
        }

        // Show list popup window on button click.
        popupBinding.menuPopup.setOnClickListener {
            listPopupWindow.show()
        }

        val inputItems = listOf("Option 1", "Option 2", "Option 3")
        val inputAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, inputItems)
        popupBinding.menuInput.setAdapter(inputAdapter)
        popupBinding.menuInput.setText(inputItems[0], false)

        popupBinding.menuInput.setOnItemClickListener { adapterView, _, position, _ ->
            showSnackBar(binding.container, adapterView.getItemAtPosition(position).toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.option_1 -> {
                showSnackBar(binding.container, item.toString())
                true
            }
            R.id.option_2 -> {
                showSnackBar(binding.container, item.toString())
                true
            }
            R.id.option_3 -> {
                showSnackBar(binding.container, item.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

/*    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val contextMenuTextView = v as TextView
        val context = context
        // Add menu items via menu.add
        menu.add(R.string.option_1)
            .setOnMenuItemClickListener { item: MenuItem? ->
                // Respond to item click
                showSnackBar(binding.container, item.toString())
                true
            }
        menu.add(R.string.option_2)
            .setOnMenuItemClickListener { item: MenuItem? ->
                // Respond to item click
                showSnackBar(binding.container, item.toString())
                true
            }
    }*/

/*    // Only for activity
    override fun onContextMenuClosed(menu: Menu) {
        // Respond to context menu being closed.
    }*/

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // Then, to handle clicks:
    override fun onContextItemSelected(item: MenuItem): Boolean {
        // val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.option_1 -> {
                // Respond to context menu item 1 click
                showSnackBar(binding.container, item.toString())
                true
            }
            R.id.option_2 -> {
                // Respond to context menu item 2 click
                showSnackBar(binding.container, item.toString())
                true
            }
            R.id.option_3 -> {
                // Respond to context menu item 2 click
                showSnackBar(binding.container, item.toString())
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    @SuppressLint("RestrictedApi")
    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            // Respond to menu item click
            showSnackBar(binding.container, menuItem.toString())
            true
        }

/*        popup.setOnDismissListener {
            // Respond to popup being dismissed
            showSnackBar(binding.container, "Respond to popup being dismissed")
        }*/

        if (popup.menu is MenuBuilder) {
            val menuBuilder = popup.menu as MenuBuilder
            menuBuilder.setOptionalIconsVisible(true)
            for (item in menuBuilder.visibleItems) {
                val iconMarginPx =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 0f, resources.displayMetrics
                    ).toInt()
                if (item.icon != null) {
                    item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
                    /*if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                        item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
                    } else {
                        item.icon =
                            object : InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0) {
                                override fun getIntrinsicWidth(): Int {
                                    return intrinsicHeight + iconMarginPx + iconMarginPx
                                }
                            }
                    }*/
                }
            }
        }
        // Show the popup menu.
        popup.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _overflowBinding = null
        _popupBinding = null
        _binding = null
    }
}
