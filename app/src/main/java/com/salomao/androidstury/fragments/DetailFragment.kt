package com.salomao.androidstury.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.salomao.androidstury.models.References
import com.salomao.androidstury.R


class DetailFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clickedItem: References = arguments?.getSerializable("item") as References
        view.findViewById<CollapsingToolbarLayout>(R.id.titlle).title = clickedItem.nome
        view.findViewById<TextView>(R.id.tv_bio).text = clickedItem.textBio

    }
}
