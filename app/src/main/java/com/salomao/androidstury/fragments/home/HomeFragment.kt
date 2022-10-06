package com.salomao.androidstury.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salomao.androidstury.R
import com.salomao.androidstury.models.AdapterBD
import com.salomao.androidstury.models.References


class HomeFragment : Fragment() {

    private lateinit var adapterBD: AdapterBD
    private lateinit var recyclerview: RecyclerView
    private val viewModel: HomeViewModel by viewModels() //delegate

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }

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

        viewModel.loadData()
        viewModel.variableQueVaiMudar.observe(viewLifecycleOwner){
            adapterBD.setDataSet(it)
        }
    }


    private fun initView(view: View) {
        //Localiza a view
        recyclerview = view.findViewById(R.id.recyclerview)
    }

    private fun initRecyclerView() {
        //cria Listener do adapter
        val listener = object : AdapterBD.OnItemClickListener {
            override fun onClick(item: References) {
                if (item.id == 9) {
                    //vai pra uma tela
                } else {
                    //vai pra outra
                }
                val bundle = Bundle()
                bundle.putInt("itemID", item.id)
                findNavController().navigate(R.id.action_recycleView_to_detailFragment, bundle)
            }
        }


        //Cria o adpter que vai ser usado na lista
        this.adapterBD = AdapterBD(listener)


        //Configura o RV
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = this.adapterBD

    }

}