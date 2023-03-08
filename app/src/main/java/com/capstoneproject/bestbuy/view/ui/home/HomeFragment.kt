package com.capstoneproject.bestbuy.view.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.databinding.FragmentHomeBinding
import com.capstoneproject.bestbuy.model.products.Product
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.utils.UIState
import com.capstoneproject.bestbuy.utils.ViewType
import com.capstoneproject.bestbuy.view.adapter.BestBuyAdapter
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel

class HomeFragment : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val bestbuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    private val productAdapter by lazy {
        BestBuyAdapter {
            Log.d(TAG, "Item: $it")
            findNavController().navigate(R.id.action_nav_products_to_nav_details)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            adapter = productAdapter
        }

        //getProducts()

        return binding.root
    }

    private fun getProducts() {
        bestbuyViewModel.products.observe(viewLifecycleOwner) { state ->
            val viewTypeList: MutableList<ViewType> = mutableListOf()
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<ProductsResponse> -> {
                    Log.d(TAG, "getProductsFrag: $state")
                    productAdapter.updateItems((state.response.products ?: emptyList()) as List<Product>)
                }
                is UIState.ERROR -> {
                    state.error.localizedMessage?.let {
                        throw Exception("Error: $state")
                    }
                }
            }
        }
    }

}