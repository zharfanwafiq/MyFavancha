package com.zharfan.myfavancha.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zharfan.myfavancha.R
import com.zharfan.myfavancha.databinding.FragmentMyAboutBinding

class MyAboutFragment : Fragment() {

    private var _binding: FragmentMyAboutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyAboutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//not usage for now,but in next update will change to single activity
}