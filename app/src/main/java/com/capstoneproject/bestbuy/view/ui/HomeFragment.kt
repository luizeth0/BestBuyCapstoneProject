package com.capstoneproject.bestbuy.view.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.databinding.FragmentHomeBinding
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.utils.UIState
import com.capstoneproject.bestbuy.utils.ViewType
import com.capstoneproject.bestbuy.view.adapter.BestBuyAdapter
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel

class HomeFragment : Fragment() {
    var search: String =""

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val bestbuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    private val productAdapter by lazy {
        BestBuyAdapter {
            Log.d(TAG, "Item: $it")
            bestbuyViewModel.sku = it.sku
            bestbuyViewModel.name = it.name
            bestbuyViewModel.price = it.price
            bestbuyViewModel.img = it.image
            bestbuyViewModel.type = it.type
            bestbuyViewModel.rating = it.rating
            bestbuyViewModel.reviewcount = it.reviewcount
            bestbuyViewModel.desc = it.plot
            bestbuyViewModel.addcart = it.addToCartUrl
            findNavController().navigate(R.id.action_nav_products_to_nav_details)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        getProducts()

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            adapter = productAdapter
        }
        binding.searchProduct.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    search = it
                    productAdapter.filter(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    search = it
                    productAdapter.filter(it)
                }
                return true
            }
        })


        return binding.root
    }

    private fun getProducts() {
        bestbuyViewModel.products.observe(viewLifecycleOwner) { state ->
            val viewTypeList: MutableList<ViewType> = mutableListOf()
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<List<ProductDomain>> -> {
                    state.response.forEach {
                        viewTypeList.add(ViewType.PRODUCT(it))
                    }
                    Log.d(TAG, "getProductsFrag: $state")
                    productAdapter.updateItems(viewTypeList)
                    binding.searchProduct.setQuery(search, true)
                    Log.d(TAG, "valueSearch: $search ")
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