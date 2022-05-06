package com.salomao.androidstury

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btRegister = view.findViewById<Button>(R.id.btRegister)
        btRegister.setOnClickListener {
            Toast.makeText(requireContext(), "Funciona", Toast.LENGTH_LONG).show()
        }
    }
}
