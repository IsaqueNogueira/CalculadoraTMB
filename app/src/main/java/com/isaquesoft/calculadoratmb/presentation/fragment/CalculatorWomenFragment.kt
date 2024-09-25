package com.isaquesoft.calculadoratmb.presentation.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.isaquesoft.calculadoratmb.R
import com.isaquesoft.calculadoratmb.databinding.CalculatorWomenFragmentBinding

/**
 * Created by Isaque Nogueira on 14/09/2024
 */
class CalculatorWomenFragment : Fragment() {
    private lateinit var binding: CalculatorWomenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = CalculatorWomenFragmentBinding.inflate(inflater, container, false)
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
                655 + (9.6 * peso.toDouble()) + (1.8 * altura.toDouble()) - (4.7 * idade.toDouble())
            textTmbResult.text = context?.getString(R.string.tmb) + " ${String.format("%.2f", tmb)}"
        }
    }
}
