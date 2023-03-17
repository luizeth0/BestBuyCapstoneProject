package com.capstoneproject.bestbuy.view.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.database.ProductTable
import com.capstoneproject.bestbuy.databinding.FragmentCartBinding
import com.capstoneproject.bestbuy.utils.UIState
import com.capstoneproject.bestbuy.view.adapter.BestBuyAdapter
import com.capstoneproject.bestbuy.view.adapter.CartAdapter
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel

class CartFragment : Fragment() {

    private val binding by lazy {
        FragmentCartBinding.inflate(layoutInflater)
    }

    private val bestbuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    private val cartAdapter by lazy {
        CartAdapter {
            //findNavController().navigate(R.id.action_nav_cart_to_nav_details)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.rvProductsHistory.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = cartAdapter
        }
        getProductsHistory()


        return binding.root
    }

    private fun getProductsHistory() {
        bestbuyViewModel.productHistory.observe(viewLifecycleOwner) { state ->
            val viewTypeList: MutableList<ProductTable> = mutableListOf()
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<List<ProductTable>> -> {
                    state.response.forEach {
                        viewTypeList.add(it)
                    }
                    Log.d(ContentValues.TAG, "getProductsFrag: $state")
                    cartAdapter.updateItems(viewTypeList)
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