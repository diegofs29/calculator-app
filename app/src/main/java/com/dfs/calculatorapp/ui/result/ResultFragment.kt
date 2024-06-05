package com.dfs.calculatorapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dfs.calculatorapp.MainViewModel
import com.dfs.calculatorapp.R
import com.dfs.calculatorapp.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentResultBinding

    private lateinit var toastResultLength: Toast

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toastResultLength =
            Toast.makeText(context, getString(R.string.result_too_long), Toast.LENGTH_LONG)
        binding.resultTextViewResult.doOnTextChanged { text, _, _, _ ->
            if ((text?.length ?: 0) == 15) {
                toastResultLength.show()
            }
        }
        viewModel.result.observe(viewLifecycleOwner) { result ->
            binding.resultTextViewResult.text = result
        }
        viewModel.operation.observe(viewLifecycleOwner) { operation ->
            binding.resultTextViewOperation.text = operation
        }
    }

}