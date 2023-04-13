package com.hsdroid.products.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hsdroid.products.R
import com.hsdroid.products.data.Products
import com.hsdroid.products.databinding.ItemsBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var list: List<Products>? = null

    inner class MyViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MyViewHolder {
        val binding: ItemsBinding = ItemsBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        )

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(list!![position]) {
                binding.tvName.text = title
                binding.tvRating.text = "${rating.rate} | ${rating.count}"
                binding.tvPrice.text = "₹ $price"

                Glide.with(itemView.context).load(image).into(binding.image)
            }
        }
    }

    override fun getItemCount(): Int {
        if (list == null) return 0
        return list?.size!!
    }

    fun setList(list: List<Products>) {
        this.list = list
        notifyDataSetChanged()
    }
}