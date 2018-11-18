package com.daftmobile.android4beginners3

import android.graphics.Color
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : LifecycleLoggingActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showColorButton.setOnClickListener(this::showColorActivity)
        inputButton.setOnClickListener(this::showInputActivity)
    }

    private fun showColorActivity(view: View) {
        // tutaj otwórz ColorActivity
    }

    private fun showInputActivity(view: View) {
        // tutaj otwórz InputActivity
    }

    fun generateRandomColor(): Int = Color.rgb(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
}
