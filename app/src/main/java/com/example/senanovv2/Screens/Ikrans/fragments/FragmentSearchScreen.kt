package com.example.senanov.presentation.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.senanovv2.databinding.FragmentSearchScreenBinding

class FragmentSearchScreen:Fragment(){

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding: FragmentSearchScreenBinding
        get() = _binding?:throw Exception("FragmentChooseLevelBinding == null")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}