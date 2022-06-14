package com.salomao.androidstury.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.salomao.androidstury.R
import kotlinx.android.synthetic.main.res_item_bancodedados.view.input_CPF
import kotlinx.android.synthetic.main.res_item_bancodedados.view.input_email
import kotlinx.android.synthetic.main.res_item_bancodedados.view.input_name
import kotlinx.android.synthetic.main.res_item_bancodedados.view.input_phone
import kotlinx.android.synthetic.main.res_item_bancodedados.view.perfil

class AdapterBD(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<UserModel> = ArrayList()

    interface OnItemClickListener {
        fun onClick(item: UserModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReferenciasViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.res_item_bancodedados, parent, false),
            listener
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReferenciasViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(list: List<UserModel>) {
        this.items = list
        notifyDataSetChanged()
    }

    class ReferenciasViewHolder constructor(
        itemView: View,
        val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        private val referenciaName = itemView.input_name
        private val referenciaTelefone = itemView.input_phone
        private val referenciaCpf = itemView.input_CPF
        private val referenciaEmail = itemView.input_email
        private val referenciaImagem = itemView.perfil


        fun bind(userModel: UserModel) {

            referenciaName.text = userModel.nome
            referenciaTelefone.text = userModel.telefone
            referenciaEmail.text = userModel.email

            val requestOptions = RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(userModel.imagem)
                .into(referenciaImagem)

            itemView.setOnClickListener {
                listener.onClick(userModel)
            }
        }

    }

}