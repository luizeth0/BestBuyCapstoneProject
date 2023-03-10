package com.capstoneproject.bestbuy.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.databinding.FragmentDetailsBinding
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel
import com.google.android.material.snackbar.Snackbar


class Details : Fragment() {


    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val bestBuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        /*val images = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        val viewPager = binding.slider
        val adapter = ImagePagerAdapter(parentFragmentManager, images)
        adapter.also { viewPager.adapter = it }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getProductsDetails()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getProductsDetails() {
        binding.nameDetails.text = bestBuyViewModel.name
        //binding.addresDetails.text = bestBuyViewModel.loc
        //binding.phoneDetails.text = bestBuyViewModel.phone
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