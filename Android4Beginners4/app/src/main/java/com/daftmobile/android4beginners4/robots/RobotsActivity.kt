package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daftmobile.android4beginners4.R
import com.daftmobile.android4beginners4.robots.viewmodel.ExternalSourceRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.RobotViewModelFactory
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel
import kotlinx.android.synthetic.main.activity_robots.*

class RobotsActivity : AppCompatActivity() {

    private val viewModel: RobotsViewModel by viewModels<ExternalSourceRobotsViewModel> { RobotViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots)
        addRobotFab.setOnClickListener { viewModel.addRobot() }
        viewModel.getRobotList().observe(this, Observer { robotTextView.text = it })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.robots_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addMenuItem -> viewModel.addRobot()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
