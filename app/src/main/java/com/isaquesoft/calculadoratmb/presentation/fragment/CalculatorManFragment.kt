package com.isaquesoft.calculadoratmb.presentation.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.isaquesoft.calculadoratmb.R
import com.isaquesoft.calculadoratmb.databinding.CalculatorManFragmentBinding

/**
 * Created by Isaque Nogueira on 14/09/2024
 */
class CalculatorManFragment : Fragment() {
    private lateinit var binding: CalculatorManFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = CalculatorManFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            buttonCalculator.setOnClickListener {
                calculateTmb()
            }
        }
    }

    private fun calculateTmb() {
        with(binding) {
            textTmbResult.text = context?.getString(R.string.tmb)
            val peso = editTextPeso.text.toString()
            val altura = editTextAltura.text.toString()
            val idade = editTextIdade.text.toString()

            if (TextUtils.isEmpty(peso) || peso == "0") {
                editTextPeso.error = context?.getString(R.string.peso_inv_lido)
                editTextPeso.requestFocus()
                return
            }

            if (TextUtils.isEmpty(altura) || altura == "0") {
                editTextAltura.error = context?.getString(R.string.altura_inv_lida)
                editTextAltura.requestFocus()
                return
            }

            if (TextUtils.isEmpty(idade) || idade == "0") {
                editTextIdade.error = context?.getString(R.string.idade_inv_lida)
                editTextIdade.requestFocus()
                return
            }

            val tmb =
                88.362 + (13.397 * peso.toDouble()) + (4.799 * altura.toDouble()) - (5.677 * idade.toDouble())
            textTmbResult.text = context?.getString(R.string.tmb) + " $tmb"
        }
    }
}
