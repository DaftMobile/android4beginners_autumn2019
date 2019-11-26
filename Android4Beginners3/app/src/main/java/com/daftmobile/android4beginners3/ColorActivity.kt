package com.daftmobile.android4beginners3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_color.*

class ColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        colorView.setBackgroundColor(extractColorFromIntent())
    }

    private fun extractColorFromIntent() = intent.getIntExtra(COLOR_KEY, 0)

    companion object {
        private const val COLOR_KEY = "color_key"

        fun intent(context: Context, color: Int) = Intent(context, ColorActivity::class.java)
                .putExtra(COLOR_KEY, color)
    }
}
