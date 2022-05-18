package com.salomao.androidstury.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.salomao.androidstury.R


class LoginFragment : Fragment() {

    private var validationEmailText: TextInputEditText? = null
    private var containerEmail: TextInputLayout? = null

    private var validationPasswordText: TextInputEditText? = null
    private var containerPassword: TextInputLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
    }

    private fun isEmailValid(emailImputed: String): Boolean {
        val listOfValidEmails = listOf(
            "rafael@hotmail.com",
            "a@b.c"
        )
        return if (listOfValidEmails.contains(emailImputed)){
            containerEmail?.error = null
            true
        }else{
            containerEmail?.error = "Email incorreto"
            false
        }
    }

    private fun isPasswordValid(isValidPassword: String): Boolean {
        val listOfValidPwd = listOf(
            "12345",
            "123"
        )
        return if (listOfValidPwd.contains(isValidPassword)){
            containerPassword?.error = null
            true
        }else{
            containerPassword?.error = "Senha incorreta"
            false
        }
    }

    private fun setupViews() {

        validationEmailText = view?.findViewById(R.id.loginEmailText)
        containerEmail = view?.findViewById(R.id.loginEmailContainer)

        validationPasswordText = view?.findViewById(R.id.loginPasswordText)
        containerPassword = view?.findViewById(R.id.loginPasswordContainer)

        val buttonLogin = view?.findViewById<TextView>(R.id.tvLogin)
        buttonLogin?.setOnClickListener {
            validateLogin()
        }

        val buttonCreate = view?.findViewById<TextView>(R.id.criarNovaConta)

        buttonCreate?.setOnClickListener {
            findNavController().navigate(R.id.action_email_Fragment_to_createAccount)
        }
    }

    private fun validateLogin() {
        val imputedEmail = validationEmailText?.text.toString()
        val imputedPassword = validationPasswordText?.text.toString()

        if (isEmailValid(imputedEmail) && isPasswordValid(imputedPassword)) {
            findNavController().navigate(R.id.action_email_Fragment_to_recycleView)
        }
        findNavController().navigate(R.id.action_email_Fragment_to_recycleView)
    }
}
