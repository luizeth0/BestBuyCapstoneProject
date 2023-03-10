package com.capstoneproject.bestbuy.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstoneproject.bestbuy.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private val binding by lazy {
        FragmentCartBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return binding.root
    }
}