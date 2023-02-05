package com.example.senanov.presentation.activity.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.senanov.data.database.AppDatabase
import com.example.senanov.data.network.ApiFactory
import com.example.senanov.presentation.activity.recycler.AdapterFilms
import com.example.senanovv2.R
import com.example.senanovv2.Screens.Ikrans.viewmodels.ViewModelMainFragment
import com.example.senanovv2.databinding.FragmentMainScreenBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FragmentMainScreen:Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding:FragmentMainScreenBinding
        get() = _binding?:throw Exception("FragmentChooseLevelBinding == null")

    private val viewModel by lazy { ViewModelProvider(this)[ViewModelMainFragment::class.java] }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterFilms()
        binding.rv.adapter = adapter

        adapter.bridge = object : AdapterFilms.OnReachEnd{
            override fun end() {
                viewModel.loadData(requireActivity().application)
            }
        }

        viewModel.loadData(requireActivity().application)
        viewModel.getDataFromDbLD(requireActivity().application).observe(viewLifecycleOwner){
            adapter.submitList(it)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}