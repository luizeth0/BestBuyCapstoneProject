package com.capstoneproject.bestbuy.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.databinding.ProductViewItemBinding
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.products.Product
import com.capstoneproject.bestbuy.utils.ViewType

class ProductAdapter(
    private val itemSet: MutableList<Product> = mutableListOf(),
    private val onItemClick: (Product) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateItems(newItems: List<Product>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ProductViewHolder(
                ProductViewItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )


    override fun getItemCount(): Int = itemSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ProductViewHolder).bind(
                itemSet[position],
                onItemClick
        )
}

class ProductViewHolder(
    private val binding: ProductViewItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product, onItemClick: (Product) -> Unit) {
        binding.productImage.setImageResource(R.mipmap.ic_launcher_foreground)
        binding.productName.text = item.name
        binding.productPrice.text = item.salePrice.toString()
        //binding.productRating.rating = (item.customerReviewAverage?.toFloat() ?: 0.0) as Float
        binding.productSku.text = item.sku.toString()

        Glide
            .with(binding.root)
            .load(item.image)
            .transform(CenterCrop(), RoundedCorners(60))
            .placeholder(R.mipmap.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.productImage)

        itemView.setOnClickListener {
            onItemClick(item)

        }

    }

}