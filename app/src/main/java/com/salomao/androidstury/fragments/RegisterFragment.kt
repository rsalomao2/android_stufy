package com.salomao.androidstury.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.salomao.androidstury.Mask
import com.salomao.androidstury.R


class RegisterFragment : Fragment() {

    private var etFone: TextInputEditText? = null
    private var btRegister: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findViews(view)
        setupTextListener()
        setupClicks()
    }

    private fun setupTextListener() {
        setupPhoneTextListener()
    }

    private fun setupPhoneTextListener() {
        //(41)98844-4123
        etFone?.let { editText ->
            editText.addTextChangedListener(Mask.insert("(##)#####-####", editText))
        }
    }

    private fun setupClicks() {
        btRegister?.setOnClickListener {
            validateFields()
        }
    }

    private fun findViews(view: View) {
        btRegister = view.findViewById<Button>(R.id.btRegister)
        etFone = view.findViewById<TextInputEditText>(R.id.etFone)
    }

    private fun validateFields() {
        validatePhone()
    }

    private fun validatePhone() {
        val phoneInput = etFone?.text.toString()

        val phoneOnly0 = "00000000000"
        val phoneOnly1 = "11111111111"
        val phoneOnly2 = "22222222222"
        val phoneOnly3 = "33333333333"
        val phoneOnly4 = "44444444444"
        val phoneOnly5 = "55555555555"
        val phoneOnly6 = "66666666666"
        val phoneOnly7 = "77777777777"
        val phoneOnly8 = "88888888888"
        val phoneOnly9 = "99999999999"

        val isSequential = when (phoneInput) {
            phoneOnly0,
            phoneOnly1,
            phoneOnly2,
            phoneOnly3,
            phoneOnly4,
            phoneOnly5,
            phoneOnly6,
            phoneOnly7,
            phoneOnly8,
            phoneOnly9 -> true
            else -> false
        }

        val hasAllNumber = phoneInput.length == 11

        if (isSequential || !hasAllNumber) {
            Toast.makeText(requireContext(), "Noooope", Toast.LENGTH_LONG).show()
        } else
            Toast.makeText(requireContext(), "Telefone Valido", Toast.LENGTH_LONG).show()
    }
}
