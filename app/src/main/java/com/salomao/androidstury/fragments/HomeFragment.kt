package com.salomao.androidstury.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salomao.androidstury.R
import com.salomao.androidstury.models.AdapterBD
import com.salomao.androidstury.models.DataSorce
import com.salomao.androidstury.models.Referencias


class HomeFragment : Fragment() {

    private lateinit var adapterBD: AdapterBD
    private lateinit var recyclerview: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycle_view, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initRecyclerView()
        addDataSource()
    }

    private fun initView(view: View) {
        recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
    }

    private fun addDataSource() {
        val dataSource = DataSorce.createDataSet()
        this.adapterBD.setDataSet(dataSource)
    }

    private fun initRecyclerView() {
        val lister = object: AdapterBD.OnItemClickListener{
            override fun onClick(item: Referencias) {
                val bundle = Bundle()
                bundle.putSerializable("VACA", item)
                findNavController().navigate(R.id.action_recycleView_to_detailFragment, bundle)
            }
        }
        this.adapterBD = AdapterBD(lister)

        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = this.adapterBD

    }
}