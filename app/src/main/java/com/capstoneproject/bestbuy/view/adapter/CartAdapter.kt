package com.capstoneproject.bestbuy.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.database.ProductTable
import com.capstoneproject.bestbuy.databinding.StoreViewItemBinding
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel

class CartAdapter(
    private val itemSet: MutableList<ProductTable> = mutableListOf(),
    private val onItemClick: (ProductTable) -> Unit
): RecyclerView.Adapter<CartViewHolder>() {
    fun updateItems(newItems: List<ProductTable>) {
        if(itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            StoreViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class CartViewHolder(
    private val binding: StoreViewItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductTable, onItemClick: (ProductTable) -> Unit) {
        binding.storeName.text = item.name
        binding.storePhone.text = item.price.toString()
        binding.storeAddress.text = item.addToCartUrl

        Glide
            .with(binding.root)
            .load(item.image)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_foreground)
            .into(binding.storeImage)

        itemView.setOnClickListener {
            onItemClick(item)
        }

    }
}