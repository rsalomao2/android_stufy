package com.salomao.androidstury.fragments.repository

import com.salomao.androidstury.models.DataSorce
import com.salomao.androidstury.models.References

class ReferenceRepository {
    fun loadReferenceList(): ArrayList<References>{
        return DataSorce.createDataSet()//ASYNC - 0.0018 ANR - Application Not Responding
    }
}
