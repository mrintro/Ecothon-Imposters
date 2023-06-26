package com.example.ecothon.ui.auth.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecothon.databinding.CardViewRecyclerViewBinding

class VPRecyclerViewAdapter(
    var items: List<String> = emptyList()
) : RecyclerView.Adapter<VPRecyclerViewAdapter.Binder<String>>() {

    class Binder<String>(private val binding: CardViewRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, position: Int) {
            binding.apply {
                this.textViewRV.text = item.toString()
                Log.d("VPRecylerView", "position: $position")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Binder<String> =
        Binder(inflate(viewType, parent))

    override fun onBindViewHolder(holder: Binder<String>, position: Int) {
        items[position].let{
            holder.bind(it, position)
        }
    }

    override fun getItemCount(): Int = items.size

    private fun inflate(viewType: Int, parent: ViewGroup): CardViewRecyclerViewBinding =
        CardViewRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

}

//class VPRecyclerViewBinder(
//    private val view: View
//) : VPRecyclerViewAdapter.Binder<String>(view) {
//    override fun bind(item: String, position: Int) {
//        CardViewRecyclerViewBinding.bind(view).apply {
//            this.textViewRV.text = item
//        }
//    }
//}
