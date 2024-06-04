package com.dfs.calculatorapp.ui.keyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dfs.calculatorapp.MainViewModel
import com.dfs.calculatorapp.R
import com.dfs.calculatorapp.databinding.FragmentKeyboardBinding

class KeyboardFragment : Fragment(R.layout.fragment_keyboard) {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentKeyboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeyboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.keyboardButton0.setOnClickListener { viewModel.addToOperation("0") }
    }
}