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
            textTmbResult.text = requireContext().getString(R.string.tmb)
            val peso = editTextPeso.text.toString()
            val altura = editTextAltura.text.toString()
            val idade = editTextIdade.text.toString()

            if (TextUtils.isEmpty(peso) || peso == "0") {
                editTextPeso.error = "Peso inválido"
                editTextPeso.requestFocus()
                return
            }

            if (TextUtils.isEmpty(altura) || altura == "0") {
                editTextAltura.error = "Altura inválida"
                editTextAltura.requestFocus()
                return
            }

            if (TextUtils.isEmpty(idade) || idade == "0") {
                editTextIdade.error = "Idade inválida"
                editTextIdade.requestFocus()
                return
            }

            val tmb =
                447.593 + (9.247 * peso.toDouble()) + (3.098 * altura.toDouble()) - (4.330 * idade.toDouble())
            textTmbResult.text = requireContext().getString(R.string.tmb) + " $tmb"
        }
    }
}
