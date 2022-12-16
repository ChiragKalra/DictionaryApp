package com.chiragkalra.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chiragkalra.dictionary.databinding.ItemResultBinding

class ResultViewHolder(
    private val binding: ItemResultBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ResultItem?) {
        if (item == null) return
        binding.typeTextView.text = item.type
        binding.definitionTextView.text = item.definition
    }
}

class RecyclerViewAdaptor(private val results: List<ResultItem>):
    RecyclerView.Adapter<ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val rootView = ItemResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ResultViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount() = results.size

}