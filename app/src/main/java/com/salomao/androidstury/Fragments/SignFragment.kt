package com.salomao.androidstury.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.salomao.androidstury.R


class SignFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?) : View? {

        // Inflate the layout for this fragment
        val viewSign = inflater.inflate(R.layout.fragment_sign, container, false)


        // Botão do Face
        val buttonFace = viewSign.findViewById<TextView>(R.id.facebook_Button)
        buttonFace.setOnClickListener {
            findNavController().navigate(R.id.action_signFragment_to_email_Fragment)
        }

        // Botão do Google
        val buttonGoogle = viewSign.findViewById<TextView>(R.id.google_Button)
        buttonGoogle.setOnClickListener {
            findNavController().navigate(R.id.action_signFragment_to_email_Fragment)
        }

        //Botão do Email
        val buttonEmail = viewSign.findViewById<TextView>(R.id.email_Button)
        buttonEmail.setOnClickListener {
            findNavController().navigate(R.id.action_signFragment_to_email_Fragment)
        }

        return viewSign
    }

}