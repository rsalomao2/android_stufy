package com.salomao.androidstury.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.salomao.androidstury.R
import kotlinx.android.synthetic.main.res_item_bancodedados.view.*

class AdapterBD: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Referencias> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReferenciasViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_bancodedados, parent, false)
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

    fun setDataSet(referenc: List<Referencias>){

        this.items = referenc

    }

    class ReferenciasViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        private val referenciaName = itemView.person_name
        private val referenciaTelefone = itemView.person_telefone
        private val referenciaCpf = itemView.person_CPF
        private val referenciaEmail = itemView.person_Email
        private val referenciaImagem = itemView.perfil


        fun bind(referencia: Referencias){

            referenciaName.text = referencia.nome
            referenciaTelefone.text = referencia.telefone
            referenciaCpf.text = referencia.cpf
            referenciaEmail.text = referencia.email

            val requestOptions = RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(referencia.imagem)
                .into(referenciaImagem)

        }

    }

}