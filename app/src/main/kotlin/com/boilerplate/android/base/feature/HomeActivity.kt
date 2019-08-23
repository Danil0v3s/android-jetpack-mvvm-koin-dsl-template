package com.boilerplate.android.base.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.boilerplate.android.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initNavigationControls()
        prepareUI()
    }

    private fun initNavigationControls() {
        val host = supportFragmentManager.findFragmentById(
            R.id.navigation_host_fragment
        ) as NavHostFragment? ?: return
        connectBottomNavigationToController(host.navController)
    }

    private fun prepareUI() {
        bottom_nav_view.itemIconTintList = null
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.navigation_host_fragment).navigateUp()

    private fun connectBottomNavigationToController(navController: NavController) =
        bottom_nav_view?.setupWithNavController(navController)
}