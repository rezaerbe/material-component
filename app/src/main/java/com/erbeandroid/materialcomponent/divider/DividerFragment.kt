package com.erbeandroid.materialcomponent.divider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.erbeandroid.materialcomponent.databinding.FragmentDividerBinding
import com.google.android.material.divider.MaterialDividerItemDecoration

class DividerFragment : Fragment() {

    private var _binding: FragmentDividerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDividerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        binding.recyclerView.adapter = DividerAdapter(item)
        binding.recyclerView.setHasFixedSize(true)

        val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        divider.dividerInsetStart = 16
        divider.dividerInsetEnd = 16
        binding.recyclerView.addItemDecoration(divider)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
