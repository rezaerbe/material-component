package com.erbeandroid.materialcomponent.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erbeandroid.materialcomponent.databinding.CardElevatedBinding
import com.erbeandroid.materialcomponent.databinding.CardOutlinedBinding
import com.erbeandroid.materialcomponent.databinding.FragmentCardBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null

    private val binding get() = _binding!!

    private var _cardElevatedBinding: CardElevatedBinding? = null

    private val cardElevatedBinding get() = _cardElevatedBinding!!

    private var _cardOutlinedBinding: CardOutlinedBinding? = null

    private val cardOutlinedBinding get() = _cardOutlinedBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(layoutInflater, container, false)
        _cardElevatedBinding = CardElevatedBinding.bind(binding.root)
        _cardOutlinedBinding = CardOutlinedBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardElevatedBinding.cardElevated.setOnLongClickListener {
            cardElevatedBinding.cardElevated.isChecked = !cardElevatedBinding.cardElevated.isChecked
            showSnackBar(
                binding.container,
                "Card Elevated ${if (cardElevatedBinding.cardElevated.isChecked) "Checked" else "Unchecked"}"
            )
            true
        }

        cardOutlinedBinding.cardOutlined.setOnLongClickListener {
            cardOutlinedBinding.cardOutlined.isChecked = !cardOutlinedBinding.cardOutlined.isChecked
            showSnackBar(
                binding.container,
                "Card Outlined ${if (cardOutlinedBinding.cardOutlined.isChecked) "Checked" else "Unchecked"}"
            )
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _cardElevatedBinding = null
        _cardOutlinedBinding = null
        _binding = null
    }
}
