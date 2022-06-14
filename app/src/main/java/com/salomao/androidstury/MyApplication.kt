package com.salomao.androidstury

import android.app.Application
import com.salomao.androidstury.database.ModelPreferencesManager

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ModelPreferencesManager.with(this)
    }
}
