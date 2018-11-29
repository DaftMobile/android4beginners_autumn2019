package com.daftmobile.android4beginners4.lights

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.LiveData

class LuminosityLiveData(private val sensorManager: SensorManager): LiveData<Luminosity>() {
    private val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    override fun onActive() {
        println("I have an observer!")
    }

    override fun onInactive() {
        println("I lost all observers! Sleep...")
    }

    private val listener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            value = Luminosity(event.values[0])
        }
    }
}
