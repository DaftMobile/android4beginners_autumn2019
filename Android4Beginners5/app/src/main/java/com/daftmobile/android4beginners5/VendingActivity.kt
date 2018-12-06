package com.daftmobile.android4beginners5

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.daftmobile.android4beginners5.sweets.SweetsVendingViewModel
import kotlinx.android.synthetic.main.activity_vending.*

class VendingActivity : AppCompatActivity() {

    private val viewModel: VendingViewModel by viewModels<SweetsVendingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vending)
        setupClickListeners()
        observeData()
    }

    private fun observeData() {
        // TODO Implement
    }

    private fun setupClickListeners() {
        depositButton.setOnClickListener {
            viewModel.depositCoin()
        }
        vendButton.setOnClickListener {
            viewModel.vend(barNameInput.text.toString())
        }
    }

    private fun updateDeposit(deposit: Int?) {
        depositTextView.text = getString(R.string.current_coin_label, deposit)
    }

    private fun showVendingErrorDialog(error: String?) {
        AlertDialog.Builder(this)
                .setTitle(R.string.nope)
                .setMessage(error)
                .setPositiveButton(android.R.string.ok, null)
                .show()
    }
}
