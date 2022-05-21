package com.salomao.androidstury.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.salomao.androidstury.Mask
import com.salomao.androidstury.R


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

    private var passwordText: TextInputEditText? = null
    private var passwordContainer: TextInputLayout? = null


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
        masks()

        buttonCreateAcc?.setOnClickListener {
            Validates()
        }
    }

    private fun masks() {
        phoneMask()
        cpfMask()
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

        passwordText = view?.findViewById<TextInputEditText>(R.id.passworldEditText)
        passwordContainer = view?.findViewById<TextInputLayout>(R.id.passwordContainer)

    }


    private fun Validates() {

        nameCheck()
        lastNameCheck()
        emailCheck()
        phoneCheck()
        cpfCheck()
        passwordCheck()

        if (nameCheck() && lastNameCheck() && emailCheck() && phoneCheck() && cpfCheck() && passwordCheck()){
            Toast.makeText(requireContext(), "esta ok", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(requireContext(), "nao esta ok", Toast.LENGTH_SHORT).show()
    }


    private fun passwordCheck(): Boolean {
        val password = passwordText?.text
        val passwordLenght = passwordText?.text?.length

        val isValidPassword1 = passwordLenght != null && passwordLenght < 9
        val isValidPassword2 = password?.matches(".*[A-Z].*".toRegex()) == false
        val isValidPassword3 = password?.matches(".*[a-z].*".toRegex()) == false
        val isValidPassword4 = password?.matches(".*[!@#$%^&*+=/?].*".toRegex()) == false
        val isValidPassword5 = password?.matches(".*[0-9].*".toRegex()) == false

        when {
            isValidPassword1 -> {
                passwordContainer?.error = "A senha precisa conter 9 caracteres"
            }
            isValidPassword2 -> {
                passwordContainer?.error = "A senha precisa conter uma letra maiúscula"
            }
            isValidPassword3 -> {
                passwordContainer?.error = "A senha precisa conter uma letra minúscula"
            }
            isValidPassword4 -> {
                passwordContainer?.error = "A senha precisa conter um caracter especial"
            }
            isValidPassword5 -> {
                passwordContainer?.error = "A senha precisa conter um numero"
            }
            else -> passwordContainer?.error = null
        }

        return !isValidPassword1 && !isValidPassword2 && !isValidPassword3 && !isValidPassword4 && !isValidPassword5

    }



    private fun nameCheck(): Boolean {
        val nameLength = nameText?.text?.length
        val nameBlank = nameText?.text

        val isValidName1 = nameBlank!!.isBlank()
        val isValidName2 = nameLength.toString() != "" && nameLength!! > 0 && nameLength < 4

        when {
            isValidName1 -> {
                nameTextContainer?.error = "Campo obrigatório"
            }
            isValidName2 -> {
                nameTextContainer?.error = "Nome muito curto"
            }
            else -> nameTextContainer?.error = null
        }

        return !isValidName1 && !isValidName2
    }




    private fun lastNameCheck(): Boolean {
        val lastNameLength = lastNameText?.text?.length
        val lastNameBlank = lastNameText?.text

        val isValidLastName1 = lastNameBlank!!.isBlank()
        val isValidLastName2 = lastNameLength.toString() != "" && lastNameLength!! > 0 && lastNameLength < 4


        when {
            isValidLastName1 -> {
            lastNameTextContainer?.error = "Campo obrigatório"
            }
            isValidLastName2 -> {
            lastNameTextContainer?.error = "Nome muito curto"
            }
            else -> lastNameTextContainer?.error = null
        }
        return !isValidLastName1 && !isValidLastName2
    }


    private fun emailCheck(): Boolean {
        val emailCheck = emailText?.text.toString()

        val isValidEmail = !Patterns.EMAIL_ADDRESS.matcher(emailCheck).matches()

        when {
            isValidEmail -> {
                emailTextContainer?.error = "Email inválido"
            }
            else -> emailTextContainer?.error = null
        }

        return !isValidEmail

    }

    private fun phoneMask() {
        //(41)98844-4123
        phoneText?.let { editText ->
            editText.addTextChangedListener(Mask.insert("(##)#####-####", editText))
        }
    }

    private fun phoneCheck(): Boolean {
        val phoneInputLenght = phoneText?.length()
        val phoneInput = phoneText?.text.toString()

        val isValidPhone1 = phoneInput.isBlank()
        val isValidPhone2 = phoneInputLenght.toString() != "" && phoneInputLenght!! != 14

        when {
            isValidPhone1 -> {
                phoneTextContainer?.error = "Campo obrigatório"
            }
            isValidPhone2 -> {
                phoneTextContainer?.error = "Telefone inválido"
            }
            else -> phoneTextContainer?.error = null
        }

       return !isValidPhone1 && !isValidPhone2
    }

    private fun cpfMask() {
        //(41)98844-4123
        cpfText?.let { editText ->
            editText.addTextChangedListener(Mask.insert("###.###.###-##", editText))
        }
    }

    private fun cpfCheck(): Boolean {
        val cpfInputLenght = cpfText?.length()
        val phoneInput = cpfText?.text.toString()

        val isValidCpf1 = phoneInput.isBlank()
        val isValidCpf2 = cpfInputLenght.toString() != "" && cpfInputLenght!! != 14

        when {
            isValidCpf1 -> {
                cpfTextContainer?.error = "Campo obrigatório"
            }
            isValidCpf2 -> {
                cpfTextContainer?.error = "CPF inválido"
            }
            else -> cpfTextContainer?.error = null
        }

        return !isValidCpf1 && !isValidCpf2
    }

}

