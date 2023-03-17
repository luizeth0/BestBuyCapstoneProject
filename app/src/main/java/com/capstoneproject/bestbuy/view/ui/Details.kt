package com.capstoneproject.bestbuy.view.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.database.ProductsDAO
import com.capstoneproject.bestbuy.databinding.FragmentDetailsBinding
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.utils.UIState
import com.capstoneproject.bestbuy.view.adapter.BestBuyAdapter
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.migration.CustomInjection.inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class Details : Fragment () {

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val bestBuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    private val productAdapter by lazy {
        BestBuyAdapter {
            Log.d(ContentValues.TAG, "Item: $it")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Saved in the cart, ready for quote", Snackbar.ANIMATION_MODE_SLIDE)
                .setAction("Saved", null).show()

            val sku = bestBuyViewModel.sku
            val name = bestBuyViewModel.name
            val image = bestBuyViewModel.img
            val type = bestBuyViewModel.type
            val price = bestBuyViewModel.price
            val rating = bestBuyViewModel.rating
            val reviewCounts = bestBuyViewModel.reviewcount
            val plot = bestBuyViewModel.desc
            val addCart = bestBuyViewModel.addcart
            val product = ProductDomain(sku, image, name, type, price, rating, reviewCounts, plot, addCart, emptyList())
            GlobalScope.launch(Dispatchers.IO) {
                bestBuyViewModel.saveProduct(product)
            }

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getProductsDetails()

        binding.rvImages.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = productAdapter
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getProductsDetails() {
        binding.detailsName.text = bestBuyViewModel.name
        binding.detailsSku.text = bestBuyViewModel.sku.toString()
        binding.detailsType.text = bestBuyViewModel.type
        binding.detailsPrice.text = "$ ${bestBuyViewModel.price}"
        binding.detailsDescription.text = bestBuyViewModel.desc
        binding.ratingDetail.rating = bestBuyViewModel.rating.toFloat()

        Glide
            .with(binding.root)
            .load(bestBuyViewModel.img)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetails)
    }

}