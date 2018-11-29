package com.daftmobile.android4beginners4.lights

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daftmobile.android4beginners4.R
import kotlinx.android.synthetic.main.activity_lights.*

class LightsActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lights)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onStart() {
        super.onStart()
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(listener)
    }

    private fun updateView(luminosity: Luminosity?) {
        if (luminosity == null) return
        luxView.text = luminosity.lux.toString()
        luxView.alpha = luminosity.fractionOfIndoorLight
    }

    private val listener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            val luminosity = Luminosity(event.values[0])
            updateView(luminosity)
        }
    }
}
