package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daftmobile.android4beginners4.R
import com.daftmobile.android4beginners4.robots.viewmodel.LiveDataRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel

class RobotsActivity : AppCompatActivity() {

    private val viewModel: RobotsViewModel = LiveDataRobotsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots)
    }
}
