package com.erbeandroid.materialcomponent.divider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erbeandroid.materialcomponent.databinding.ItemDividerBinding
import com.erbeandroid.materialcomponent.util.showSnackBar

class DividerAdapter(private val dataset: List<String>) :
    RecyclerView.Adapter<DividerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemDividerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.itemText.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDividerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            showSnackBar(it, item)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
