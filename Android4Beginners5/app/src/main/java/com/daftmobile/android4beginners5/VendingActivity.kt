package com.daftmobile.android4beginners5

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daftmobile.android4beginners5.joke.JokeVendingViewModel
import kotlinx.android.synthetic.main.activity_vending.*

class VendingActivity : AppCompatActivity() {

    private val viewModel: VendingViewModel by viewModels<JokeVendingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vending)
        setupClickListeners()
        observeData()
    }

    private fun observeData() {
        viewModel.itemVended().observe(this, Observer(vendedItemTextView::setText))
        viewModel.vendingError().observe(this, Observer(::showVendingErrorDialog))
        viewModel.currentDeposit().observe(this, Observer(this::updateDeposit))
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
