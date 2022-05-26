package com.salomao.androidstury.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.salomao.androidstury.R
import com.salomao.androidstury.models.DataSorce


class DetailFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar) as Toolbar
        toolbar.setupWithNavController(findNavController())

        items()


    }

    private fun items() {
        val clickedItemId: Int? = arguments?.getInt("itemID")
        val dataSource = DataSorce.createDataSet()
        val clickedItem = dataSource.find {
            it.id == clickedItemId
        }
        view?.findViewById<CollapsingToolbarLayout>(R.id.titlle)?.title = clickedItem?.nome

        val imageView = view?.findViewById<ImageView>(R.id.im_input_image)
        if (imageView != null) {
            Glide.with(this)
                .load(clickedItem?.imagem)
                .into(imageView)
        }

        val ivProfileView = view?.findViewById<ImageView>(R.id.iv_profile)
        if (ivProfileView != null) {
            Glide.with(this)
                .load(clickedItem?.imagem)
                .circleCrop()
                .into(ivProfileView)
        }
    }
}