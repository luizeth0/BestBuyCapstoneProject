package com.capstoneproject.bestbuy.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.databinding.ImagesViewItemBinding
import com.capstoneproject.bestbuy.databinding.ProductViewItemBinding
import com.capstoneproject.bestbuy.databinding.StoreViewItemBinding
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.domain.StoreDomain
import com.capstoneproject.bestbuy.model.products.Image
import com.capstoneproject.bestbuy.utils.ViewType

class BestBuyAdapter(
    private val itemSet: MutableList<ViewType> = mutableListOf(),
    private val onItemClick: (ProductDomain) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    fun updateItems(newItems: MutableList<ViewType>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
            setData(newItems)
        }
    }

    // Create a separate list to store the original items
    private val originalItems: MutableList<ViewType> = mutableListOf()

    fun setData(items: List<ViewType>) {
        originalItems.clear()
        originalItems.addAll(items)
        itemSet.clear()
        itemSet.addAll(items)
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        val filteredItems = if (query.isBlank()) {
            // If the query is blank, restore the original items
            originalItems.toMutableList()
        } else {
            // Otherwise, filter the items based on the query
            originalItems.filter { item ->
                when (item) {
                    is ViewType.PRODUCT -> item.productList.name.contains(query, ignoreCase = true)
                    is ViewType.IMAGES_PRODUCT -> item.imageList.href!!.contains(query, ignoreCase = true)
                    is ViewType.STORE -> item.storeList.name.contains(query, ignoreCase = true)
                }
            }.toMutableList()
        }

        // Update your list with filtered items
        itemSet.clear()
        itemSet.addAll(filteredItems)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                ProductViewHolder(
                    ProductViewItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            1 -> {
                ImagesViewHolder(
                    ImagesViewItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            }
            else -> {
                StoreViewHolder(
                    StoreViewItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }


    override fun getItemCount(): Int = itemSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        when (val item = itemSet[position]) {
            is ViewType.PRODUCT -> (holder as ProductViewHolder).bind(
                item.productList,
                onItemClick
            )
            is ViewType.IMAGES_PRODUCT -> (holder as ImagesViewHolder).bind(
                item.imageList,
            )
            is ViewType.STORE -> (holder as StoreViewHolder).bind(
                item.storeList
            )
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (itemSet[position]) {
            is ViewType.PRODUCT -> 0
            is ViewType.IMAGES_PRODUCT -> 1
            is ViewType.STORE -> 2
        }
}

class ProductViewHolder(
    private val binding: ProductViewItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductDomain, onItemClick: (ProductDomain) -> Unit) {
        binding.productImage.setImageResource(R.mipmap.ic_launcher_foreground)
        binding.productName.text = item.name
        binding.productPrice.text = "$ " + item.price.toString()
        //binding.productRating.rating = item.rating.toFloat()
        //binding.productSku.text = item.sku.toString()

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

}class ImagesViewHolder(
    private val binding: ImagesViewItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Image) {
        binding.images.setImageResource(R.mipmap.ic_launcher_foreground)
        //binding.test.text = item.name
        //binding.productPrice.text = item.price.toString()
        //binding.productRating.rating = item.rating.toFloat()
        //binding.productSku.text = item.sku.toString()

        Glide
            .with(binding.root)
            .load(item.href)
            .transform(CenterCrop(), RoundedCorners(60))
            .placeholder(R.mipmap.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.images)

        itemView.setOnClickListener {

        }

    }

}class StoreViewHolder(
    private val binding: StoreViewItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: StoreDomain) {
        binding.storeName.text = "🏪  " + item.name
        binding.storePhone.text = "📞  " + item.phone
        binding.storeType.text = "📍  " + item.locationType
        binding.storeAddress.text = "🗺️  " + "${item.address} ${item.address2} ${item.city} ${item.region} ${item.fullPostalCode}"

        itemView.setOnClickListener {
            //onItemClick2(item)
        }

    }

}
/*
class ImagePagerAdapter(fragmentManager: FragmentManager, private val images: List<Int>) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(images[position])
    }

    override fun getCount(): Int {
        return images.size
    }
}*/