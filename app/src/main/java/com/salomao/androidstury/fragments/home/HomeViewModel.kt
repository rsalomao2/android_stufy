package com.salomao.androidstury.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salomao.androidstury.fragments.usecase.LoadReferenceUseCase
import com.salomao.androidstury.models.References

class HomeViewModel(
    val loadReferenceUseCase: LoadReferenceUseCase
) : ViewModel() {
    var variableQueVaiMudar = MutableLiveData<ArrayList<References>>()


    fun loadData() {
        variableQueVaiMudar.value = loadReferenceUseCase.load()
    }
}


/** MVVM
 *
 * HomeFragment -> HomeVideModel -> UserRepository -> VM -> Fragment
 */

//Clean Achtecture
/** Repository Pattern
 *  Encapsular logica de obtenção dos dados, seja eles vindo API ou BD
 */

/** Use Case
 * Encapsula logica de Negopcio e logica de processamentos DADOS
 *
 * Fragment -> VM -> UseCase -> Repository (List<Movie>)-> UseCase (Juntar os 2)-> VM -> Fragment
 * Fragment2 -> VM2 -> UseCase -> Repository (List<Movie>)-> UseCase -> Repository (List<Genero>) -> UseCase (Juntar os 2) -> VM -> Fragment
 */
