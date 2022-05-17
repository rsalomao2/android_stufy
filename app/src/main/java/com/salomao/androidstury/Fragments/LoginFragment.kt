package com.salomao.androidstury.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.salomao.androidstury.R
import org.w3c.dom.Text


class LoginFragment : Fragment() {

    private var validationEmailText: TextInputEditText? = null
    private var validationEmailContainer: TextInputLayout? = null

    private var validationPasswordText: TextInputEditText? = null
    private var validationPasswordContainer: TextInputLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        views()

    }

    private fun checkLogin() {
        val isNotValidEmail = validationEmailContainer
        val isValidEmail = validationEmailText?.text

        val isNotValidPassword = validationPasswordContainer
        val isValidPassword = validationPasswordText?.text

        if (isValidEmail.toString() != "rafael@hotmail.com"){
            isNotValidEmail?.error = "Email incorreto"
        } else
            isNotValidEmail?.error = null

        if (isValidPassword.toString() != "12345"){
            isNotValidPassword?.error = "Senha incorreta"
        } else
            isNotValidPassword?.error = null
    }

    private fun views(){

        validationEmailText = view?.findViewById<TextInputEditText>(R.id.loginEmailText)
        validationEmailContainer = view?.findViewById<TextInputLayout>(R.id.loginEmailContainer)

        validationPasswordText = view?.findViewById<TextInputEditText>(R.id.loginPasswordText)
        validationPasswordContainer= view?.findViewById<TextInputLayout>(R.id.loginPasswordContainer)

        val buttonLogin = view?.findViewById<TextView>(R.id.tvLogin)
        buttonLogin?.setOnClickListener() {
            isValid()
        }

        val buttonCreate = view?.findViewById<TextView>(R.id.criarNovaConta)
        buttonCreate?.setOnClickListener() {
            findNavController().navigate(R.id.action_email_Fragment_to_createAccount)
        }
    }

    private fun isValid(){
        val validEmail = validationEmailText?.text.toString()
        val validPassword = validationPasswordText?.text.toString()

        val emailCorrect = when (validEmail){
            "rafael@hotmail.com" -> true
            else -> false
        }

        val passwordCorrect = when (validPassword){
            "12345" -> true
            else -> false
        }

        if (emailCorrect && passwordCorrect){
            findNavController().navigate(R.id.action_email_Fragment_to_recycleView)
        } else
            return checkLogin()
    }
}