package com.example.newsapp.ui.details


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var binding: FragmentDetailsBinding?=null
    private val mBinding get() =binding!!
    private val bungleArgs: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleArg = bungleArgs.article
        articleArg.let { article ->
            article.urlToImage?.let {
                Glide.with(this).load (article.urlToImage).into (mBinding.headerImage)
            }
            mBinding.headerImage.clipToOutline=true
            mBinding.articleDetailsTitle.text=article.title
            mBinding.articleDetailDescriptionText.text=article.description

            mBinding.articleDetailButton.setOnClickListener {
                try {
                    Intent()
                        .setAction(Intent.ACTION_VIEW)
                        .addCategory(Intent.CATEGORY_BROWSABLE)
                        .setData(Uri.parse(takeIf { URLUtil.isValidUrl(article.url)}
                            ?.let {
                            article.url
                            } ?:"http://google.com"))
                        .let {
                                ContextCompat.startActivity(requireContext(),it ,null)
                        }
                    }
                catch (e: Exception){
                Toast.makeText(context,"There device don't have any browser", Toast.LENGTH_SHORT)
                }
            }
        }
    }
}