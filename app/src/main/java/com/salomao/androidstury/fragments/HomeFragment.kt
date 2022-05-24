package com.salomao.androidstury.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salomao.androidstury.models.AdapterBD
import com.salomao.androidstury.models.DataSorce
import com.salomao.androidstury.models.References
import com.salomao.androidstury.R


class HomeFragment : Fragment() {

    private lateinit var adapterBD: AdapterBD
    private lateinit var recyclerview: RecyclerView

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar!!.show()}

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
        val listener = object: AdapterBD.OnItemClickListener{
            override fun onClick(item: References) {
                val bundle = Bundle()
                bundle.putInt("itemID", item.id)
                findNavController().navigate(R.id.action_recycleView_to_detailFragment, bundle)
            }

        }

        this.adapterBD = AdapterBD(listener)


        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = this.adapterBD

    }

}