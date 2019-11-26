package com.daftmobile.android4beginners3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        addButton.setOnClickListener(this::setResultAndFinish)
    }

    private fun setResultAndFinish(view: View) {
        val input = addInput.text.toString()
        val data = Intent().putExtra(INPUT_KEY, input)
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    companion object {
        const val REQUEST_CODE = 101
        const val INPUT_KEY = "input_key"

        fun intent(context: Context) = Intent(context, InputActivity::class.java)
    }
}
