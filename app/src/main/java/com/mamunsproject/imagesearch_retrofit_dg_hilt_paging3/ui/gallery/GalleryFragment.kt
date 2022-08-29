package com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.R
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.adapter.UnsplashPhotoPagingAdapter
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.databinding.FragmentGalleryBinding
import com.mamunsproject.imagesearch_retrofit_dg_hilt_paging3.mvvm.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()

    // to protect from memory Leak
    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGalleryBinding.bind(view)

        val adapter = UnsplashPhotoPagingAdapter()

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }


        // this function will trigger when the value of our viewmodel changes
        viewModel.photos.observe(viewLifecycleOwner) {
            //connect data to adapter
            adapter.submitData(viewLifecycleOwner.lifecycle, it)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}