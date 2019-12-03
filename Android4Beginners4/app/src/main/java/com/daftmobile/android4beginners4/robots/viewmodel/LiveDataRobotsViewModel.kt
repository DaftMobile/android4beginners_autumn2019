package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners4.robots.model.Robot
import com.daftmobile.android4beginners4.robots.model.RobotGenerator

class LiveDataRobotsViewModel: RobotsViewModel, ViewModel() {

    private val robotsMutableList = mutableListOf<Robot>()
    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()

    override fun getRobotList(): LiveData<String> = mutableLiveData

    override fun addRobot() {
        robotsMutableList.add(RobotGenerator.generate())
        mutableLiveData.value = robotsMutableList.joinToString("\n") { it.name }
    }
}
