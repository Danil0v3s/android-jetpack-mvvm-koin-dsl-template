package com.boilerplate.android.base.feature.launchscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.boilerplate.android.R
import com.boilerplate.android.base.feature.HomeActivity
import org.koin.android.ext.android.inject

class LaunchScreenActivity : AppCompatActivity() {
    private val viewModel: LaunchScreenViewModel by inject()

    private val launchScreenDuration = 500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launchscreen_activity)
        viewModel.onViewLoaded()

        Handler().postDelayed({
            openHomeView()
        }, launchScreenDuration)
    }

    private fun openHomeView() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}