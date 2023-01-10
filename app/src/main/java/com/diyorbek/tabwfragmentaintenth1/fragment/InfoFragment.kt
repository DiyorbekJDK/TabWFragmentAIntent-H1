package com.diyorbek.tabwfragmentaintenth1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diyorbek.tabwfragmentaintenth1.R
import com.diyorbek.tabwfragmentaintenth1.adapter.NewAdapter
import com.diyorbek.tabwfragmentaintenth1.databinding.FragmentInfoBinding
import com.diyorbek.tabwfragmentaintenth1.model.Photo

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private var photo: Photo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photo = arguments?.getParcelable("picture")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)
        afaf()
    }

    private fun afaf() {
        photo?.let { p ->
            binding.imageVIew.setImageResource(p.icon)
        }
    }

}