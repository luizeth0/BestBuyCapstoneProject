package com.capstoneproject.bestbuy.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstoneproject.bestbuy.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private val binding by lazy {
        FragmentSlideshowBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return binding.root
    }

}