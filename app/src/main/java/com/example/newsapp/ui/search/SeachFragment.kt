package com.example.newsapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentSeachBinding

class SeachFragment : Fragment() {

    private var binding: FragmentSeachBinding?=null
    private val mBinding get() =binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSeachBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }
}