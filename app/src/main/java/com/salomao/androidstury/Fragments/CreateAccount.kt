package com.salomao.androidstury.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.salomao.androidstury.R


class CreateAccount : Fragment() {


    private var nameText: TextInputEditText? = null
    private var nameTextContainer: TextInputLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonCreateAcc = view.findViewById<TextView>(R.id.buttonCreateRegister)
        nameText = view.findViewById<TextInputEditText>(R.id.nomeEditText)
        nameTextContainer = view.findViewById<TextInputLayout>(R.id.nomeContainer)


        buttonCreateAcc?.setOnClickListener{
            validateName()
        }
    }

    private fun validateName() {
        val name = nameText?.text
        if (name!!.isBlank()) {
            nameTextContainer?.error = "Campo obrigatório"
        }else
            nameTextContainer?.error = null
    }
}
