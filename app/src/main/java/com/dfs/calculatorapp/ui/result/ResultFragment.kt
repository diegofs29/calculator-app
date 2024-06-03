package com.dfs.calculatorapp.ui.result

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dfs.calculatorapp.MainViewModel

import com.dfs.calculatorapp.R
import com.dfs.calculatorapp.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}