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
        binding.keyboardButton0.setOnClickListener { viewModel.addNumberToOperation("0") }
        binding.keyboardButton1.setOnClickListener { viewModel.addNumberToOperation("1") }
        binding.keyboardButton2.setOnClickListener { viewModel.addNumberToOperation("2") }
        binding.keyboardButton3.setOnClickListener { viewModel.addNumberToOperation("3") }
        binding.keyboardButton4.setOnClickListener { viewModel.addNumberToOperation("4") }
        binding.keyboardButton5.setOnClickListener { viewModel.addNumberToOperation("5") }
        binding.keyboardButton6.setOnClickListener { viewModel.addNumberToOperation("6") }
        binding.keyboardButton7.setOnClickListener { viewModel.addNumberToOperation("7") }
        binding.keyboardButton8.setOnClickListener { viewModel.addNumberToOperation("8") }
        binding.keyboardButton9.setOnClickListener { viewModel.addNumberToOperation("9") }

        binding.keyboardButtonDecimal.setOnClickListener { viewModel.addNumberToOperation(".") }
        binding.keyboardButtonNegative.setOnClickListener { viewModel.addSingleOperatorToOperation("-") }

        binding.keyboardButtonAdd.setOnClickListener { viewModel.addOperatorToOperation("+") }
        binding.keyboardButtonSubtract.setOnClickListener { viewModel.addOperatorToOperation("-") }
        binding.keyboardButtonMultiply.setOnClickListener { viewModel.addOperatorToOperation("×") }
        binding.keyboardButtonDivide.setOnClickListener { viewModel.addOperatorToOperation("÷") }
        binding.keyboardButtonEquals.setOnClickListener { viewModel.calculate() }

        binding.keyboardButtonInverse.setOnClickListener { viewModel.addSingleOperatorToOperation("inv") }
        binding.keyboardButtonSquare.setOnClickListener { viewModel.addSingleOperatorToOperation("sq") }
        binding.keyboardButtonSqrt.setOnClickListener { viewModel.addSingleOperatorToOperation("sqrt") }
        binding.keyboardButtonPercentage.setOnClickListener { viewModel.addSingleOperatorToOperation("%") }
        binding.keyboardButtonCe.setOnClickListener { viewModel.addSingleOperatorToOperation("CE") }
        binding.keyboardButtonC.setOnClickListener { viewModel.addSingleOperatorToOperation("C") }

        binding.keyboardButtonDel.setOnClickListener { viewModel.delete() }
    }
}