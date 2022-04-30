package com.salomao.androidstury.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.salomao.androidstury.R


class Email_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val viewEmail = inflater.inflate(R.layout.fragment_email, container, false)


        //Button

        val buttonLogin = viewEmail.findViewById<TextView>(R.id.facebook_login)
        buttonLogin.setOnClickListener() {
            findNavController().navigate(R.id.action_email_Fragment_to_recycleView)
        }


        return viewEmail
    }

}