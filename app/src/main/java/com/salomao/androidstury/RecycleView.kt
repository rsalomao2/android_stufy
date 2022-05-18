package com.salomao.androidstury

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salomao.androidstury.models.AdapterBD
import com.salomao.androidstury.models.DataSorce


class RecycleView : Fragment() {

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

        this.adapterBD = AdapterBD()


        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = this.adapterBD

    }
}