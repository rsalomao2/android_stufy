package com.salomao.androidstury.Fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.salomao.androidstury.Mask
import com.salomao.androidstury.R
import kotlinx.android.synthetic.main.fragment_create_account.*


class CreateAccount : Fragment() {

    private var nameText: TextInputEditText? = null
    private var nameTextContainer: TextInputLayout? = null

    private var lastNameText: TextInputEditText? = null
    private var lastNameTextContainer: TextInputLayout? = null

    private var emailText: TextInputEditText? = null
    private var emailTextContainer: TextInputLayout? = null

    private var phoneText: TextInputEditText? = null
    private var phoneTextContainer: TextInputLayout? = null

    private var cpfText: TextInputEditText? = null
    private var cpfTextContainer: TextInputLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val buttonCreateAcc = view.findViewById<TextView>(R.id.buttonCreateRegister)

        findViewID()


        buttonCreateAcc?.setOnClickListener {
            Validates()
        }
    }

    private fun findViewID() {
        nameText = view?.findViewById<TextInputEditText>(R.id.nameEditText)
        nameTextContainer = view?.findViewById<TextInputLayout>(R.id.nameContainer)

        lastNameText = view?.findViewById<TextInputEditText>(R.id.lastNameEditText)
        lastNameTextContainer = view?.findViewById<TextInputLayout>(R.id.lastNameContainer)

        emailText = view?.findViewById<TextInputEditText>(R.id.emailEditText)
        emailTextContainer = view?.findViewById<TextInputLayout>(R.id.emailContainer)

        phoneText = view?.findViewById<TextInputEditText>(R.id.foneEditText)
        phoneTextContainer = view?.findViewById<TextInputLayout>(R.id.foneContainer)

        cpfText = view?.findViewById<TextInputEditText>(R.id.cpfEditText)
        cpfTextContainer = view?.findViewById<TextInputLayout>(R.id.cpfContainer)

    }

    private fun Validates() {
        nameCheck()
        lastNameCheck()
        emailCheck()
        phoneCheck()
        phoneMask()

    }

    private fun nameCheck(){
        val nameLength = nameText?.text?.length
        val nameBlank = nameText?.text
        if (nameBlank!!.isBlank()) {
            nameTextContainer?.error = "Campo obrigatório"
        } else if (nameLength.toString() != "" && nameLength!! > 0 && nameLength < 4) {
            nameTextContainer?.error = "Nome muito curto"
        } else
            nameTextContainer?.error = null
    }

    private fun lastNameCheck(){
        val lastNameLength = lastNameText?.text?.length
        val lastNameBlank = lastNameText?.text
        if (lastNameBlank!!.isBlank()) {
            lastNameTextContainer?.error = "Campo obrigatório"
        } else if (lastNameLength.toString() != "" && lastNameLength!! > 0 && lastNameLength < 4) {
            lastNameTextContainer?.error = "Nome muito curto"
        } else
            lastNameTextContainer?.error = null
    }


    private fun emailCheck() {
        val emailCheck = emailText?.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailCheck).matches()) {
            emailTextContainer?.error = "Email inválido"
        } else
            emailTextContainer?.error = null
    }

    private fun phoneMask() {
        //(41)98844-4123
        phoneText?.let { editText ->
            editText.addTextChangedListener(Mask.insert("(##)#####-####", editText))
        }
    }

    private fun phoneCheck(){
        val phoneInputLenght = phoneText?.length()
        val phoneInput = phoneText?.text.toString()
        if (phoneInput.isBlank()){
            foneContainer.error = "Campo obrigatório"
        }else if (phoneInputLenght.toString() != "" && phoneInputLenght!! < 11){
            foneContainer.error = "Telefone inválido"
        } else
            foneContainer.error = null
    }
}
