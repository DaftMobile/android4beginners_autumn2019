package com.daftmobile.android4beginners3

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
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
        lifecycle.addObserver(LoggingLifecycleObserver())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // sprawdzamy, czy mamy rezultat
        if (requestCode == InputActivity.REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // wykręcamy numer
                val phoneIntent = phoneIntent(data?.getStringExtra(InputActivity.INPUT_KEY))
                if (phoneIntent.canBeOpened()) startActivity(phoneIntent)
            } else {
                println("Error: $resultCode")
            }
        }
    }

    private fun phoneIntent(phoneNumber: String?) = Intent(Intent.ACTION_DIAL)
            .setData(Uri.parse("tel:$phoneNumber"))

    private fun Intent.canBeOpened() = packageManager.queryIntentActivities(this, PackageManager.MATCH_DEFAULT_ONLY).isNotEmpty()

    // otwieramy Activity z parametrem
    private fun showColorActivity(view: View) = startActivity(
        ColorActivity.intent(this, generateRandomColor())
    )

    // otwieramy Activity, żeby uzyskać od niego rezultat
    private fun showInputActivity(view: View) = startActivityForResult(
        InputActivity.intent(this),
        InputActivity.REQUEST_CODE
    )

    private fun generateRandomColor(): Int = Color.rgb(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
}
