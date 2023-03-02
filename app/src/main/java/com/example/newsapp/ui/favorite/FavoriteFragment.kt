package com.example.newsapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    private var binding: FragmentFavoriteBinding? = null
    private val mBinding get() =binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }
}