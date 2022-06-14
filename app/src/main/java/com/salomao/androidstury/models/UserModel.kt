package com.salomao.androidstury.models

data class UserModel(
    val id: Int,
    val imagem: String,
    val nome: String,
    val telefone: String,
    val cpf: String,
    val email: String,
    val textBio: String,
)
