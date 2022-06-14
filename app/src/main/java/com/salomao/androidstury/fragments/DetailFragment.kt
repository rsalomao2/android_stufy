package com.salomao.androidstury.fragments

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
import com.salomao.androidstury.database.ModelPreferencesManager


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
        if (clickedItemId != null){
            val clickedItem = ModelPreferencesManager.getById(ModelPreferencesManager.USER_KEY, clickedItemId)
            val tvTitle = view?.findViewById<CollapsingToolbarLayout>(R.id.titlle)
            val imageView = view?.findViewById<ImageView>(R.id.im_input_image)
            val ivProfile = view?.findViewById<ImageView>(R.id.iv_profile)
            val tvName = view?.findViewById<TextView>(R.id.tv_userName)
            val tvEmail = view?.findViewById<TextView>(R.id.tv_email)

            tvTitle?.title = clickedItem?.nome

            if (imageView != null) {
                Glide.with(this)
                    .load(clickedItem?.imagem)
                    .into(imageView)
            }

            if (ivProfile != null) {
                Glide.with(this)
                    .load(clickedItem?.imagem)
                    .circleCrop()
                    .into(ivProfile)
            }

            tvName?.text = clickedItem?.nome
            tvEmail?.text = clickedItem?.email
        }
    }
}
