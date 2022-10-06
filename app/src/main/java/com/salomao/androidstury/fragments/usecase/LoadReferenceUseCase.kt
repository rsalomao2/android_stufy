package com.salomao.androidstury.fragments.usecase

import com.salomao.androidstury.fragments.repository.ReferenceRepository
import com.salomao.androidstury.models.References

class LoadReferenceUseCase(
    val repository : ReferenceRepository
) {
    fun load(): ArrayList<References> {
        val dadosDaLista = repository.loadReferenceList()
        dadosDaLista.filter {
            it.telefone.isNotEmpty()
        }
        return dadosDaLista
    }
}