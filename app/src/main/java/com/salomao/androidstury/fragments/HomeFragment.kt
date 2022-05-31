package com.salomao.androidstury.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salomao.androidstury.R
import com.salomao.androidstury.models.AdapterBD
import com.salomao.androidstury.models.DataSource
import com.salomao.androidstury.network.ApiUser
import com.salomao.androidstury.network.RetrofitSetup
import com.salomao.androidstury.network.UserNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var adapterBD: AdapterBD
    private lateinit var recyclerview: RecyclerView

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
        loadUserList()
    }

    private fun initView(view: View) {
        recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
    }

    private fun loadUserList() {
        val apiInterface: ApiUser = RetrofitSetup.createService(ApiUser::class.java)
        val call: Call<List<UserNetwork>> = apiInterface.getUsers()
        call.enqueue(object : Callback<List<UserNetwork>> {
            override fun onResponse(
                call: Call<List<UserNetwork>>,
                response: Response<List<UserNetwork>>
            ) {
                if (response.isSuccessful) {
                    val userNetworkList = response.body()
                    val userNetworkWithUrlList = userNetworkList?.map {
                        it.copy(imageUrl = DataSource.getUrl())
                    }
                    if (!userNetworkWithUrlList.isNullOrEmpty()) {
                        adapterBD.setDataSet(userNetworkWithUrlList)
                    }
                } else {
                    Log.e("###", response.message())
                }
            }

            override fun onFailure(call: Call<List<UserNetwork>>, t: Throwable) {
                Log.e("###", t.message ?: "")
            }
        })
    }

    private fun initRecyclerView() {
        val listener = object : AdapterBD.OnItemClickListener {
            override fun onClick(item: UserNetwork) {
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