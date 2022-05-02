package com.salomao.androidstury

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.res_item_bancodedados.*


class createAccount : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewCreateAccount = inflater.inflate(R.layout.fragment_create_account, container, false)

        return viewCreateAccount
    }


}