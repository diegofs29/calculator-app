package com.dfs.calculatorapp.ui.keyboard

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dfs.calculatorapp.R

class KeyboardFragment : Fragment(R.layout.fragment_keyboard) {

    companion object {
        fun newInstance() = KeyboardFragment()
    }

    private val viewModel: KeyboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_keyboard, container, false)
    }
}