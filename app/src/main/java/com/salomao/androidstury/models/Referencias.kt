package com.salomao.androidstury.models

import java.io.Serializable

data class Referencias(
    var imagem: String,
    var nome: String,
    var telefone: String,
    var cpf: String,
    var email: String,
    ) : Serializable