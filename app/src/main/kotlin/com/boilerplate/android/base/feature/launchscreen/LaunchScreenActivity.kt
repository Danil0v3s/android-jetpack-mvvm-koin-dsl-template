package com.boilerplate.android.base.feature.launchscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.boilerplate.android.R
import com.boilerplate.android.base.feature.HomeActivity
import org.koin.android.ext.android.inject

class LaunchScreenActivity : AppCompatActivity() {
    private val viewModel: LaunchScreenViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launchscreen_activity)

        viewModel.fetchDummyData().observe(this, Observer { data ->
            openHomeView()
        })
    }

    private fun openHomeView() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}