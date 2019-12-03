package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daftmobile.android4beginners4.robots.model.ListRobotsDataSource

object RobotViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(ExternalSourceRobotsViewModel::class.java) -> {
            modelClass.cast(ExternalSourceRobotsViewModel(ListRobotsDataSource()))!!
        }
        else -> throw IllegalArgumentException()
    }
}
