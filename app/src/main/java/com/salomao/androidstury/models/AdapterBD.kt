package com.salomao.androidstury.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.salomao.androidstury.R
import com.salomao.androidstury.network.UserNetwork
import kotlinx.android.synthetic.main.res_item_bancodedados.view.*

class AdapterBD (private val listener: OnItemClickListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<UserNetwork> = ArrayList()

    interface OnItemClickListener {
        fun onClick(item: UserNetwork)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReferenciasViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_bancodedados, parent, false),
            listener
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is ReferenciasViewHolder ->{
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(list: List<UserNetwork>){

        this.items = list

    }

    class ReferenciasViewHolder constructor(
        itemView: View,
    val listener: OnItemClickListener
    ): RecyclerView.ViewHolder(itemView) {

        private val referenciaName = itemView.input_name
        private val referenciaTelefone = itemView.input_phone
        private val referenciaCpf = itemView.input_CPF
        private val referenciaEmail = itemView.input_email
        private val referenciaImagem = itemView.perfil


        fun bind(userNetwork: UserNetwork){

            referenciaName.text = userNetwork.name
            referenciaTelefone.text = userNetwork.phone
            referenciaEmail.text = userNetwork.email

            val requestOptions = RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(userNetwork.imageUrl)
                .into(referenciaImagem)

            itemView.setOnClickListener{
                listener.onClick(userNetwork)
            }
        }

    }

}