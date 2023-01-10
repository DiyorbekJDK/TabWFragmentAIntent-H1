package com.diyorbek.tabwfragmentaintenth1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.diyorbek.tabwfragmentaintenth1.R
import com.diyorbek.tabwfragmentaintenth1.adapter.NewAdapter
import com.diyorbek.tabwfragmentaintenth1.databinding.FragmentFourthBinding
import com.diyorbek.tabwfragmentaintenth1.databinding.FragmentThirdBinding
import com.diyorbek.tabwfragmentaintenth1.util.Constats
class FourthFragment : Fragment(R.layout.fragment_fourth) {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFourthBinding.bind(view)

        bikViews()
    }

    private fun bikViews() {
        val newAdapter = NewAdapter()
        binding.rv.adapter = newAdapter
        newAdapter.submitList(Constats.techList())
        newAdapter.onClick = {
            val bundle = bundleOf("picture" to it)
            findNavController().navigate(R.id.action_fatherFragment_to_infoFragment,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}