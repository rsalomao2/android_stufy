package com.salomao.androidstury.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.salomao.androidstury.R


class GoogleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val viewGoogle = inflater.inflate(R.layout.fragment_google, container, false)


        //Button

        val buttonLogin = viewGoogle.findViewById<TextView>(R.id.facebook_login)
        buttonLogin.setOnClickListener() {
            findNavController().navigate(R.id.action_googleFragment_to_recycleView)
        }


        return viewGoogle

    }

}