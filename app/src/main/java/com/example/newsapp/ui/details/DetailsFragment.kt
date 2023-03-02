package com.example.newsapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var binding: FragmentDetailsBinding?=null
    private val mBinding get() =binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }
}