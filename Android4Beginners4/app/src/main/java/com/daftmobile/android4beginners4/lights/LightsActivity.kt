package com.daftmobile.android4beginners4.lights

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daftmobile.android4beginners4.R
import kotlinx.android.synthetic.main.activity_lights.*

class LightsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lights)
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        LuminosityLiveData(sensorManager).observe(this, Observer(this::updateView))
    }

    private fun updateView(luminosity: Luminosity?) {
        if (luminosity == null) return
        luxView.text = luminosity.lux.toString()
        luxView.alpha = luminosity.fractionOfIndoorLight
    }
}
