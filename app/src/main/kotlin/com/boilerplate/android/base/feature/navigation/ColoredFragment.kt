package com.boilerplate.android.base.feature.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boilerplate.android.R

class ColoredFragment : Fragment() {

    companion object {
        val ARG_TAB_INDEX_KEY = "tab_index"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_colored, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (arguments?.getInt(ARG_TAB_INDEX_KEY)) {
            0 -> view.setBackgroundResource(R.color.background_tab_inspire)
            1 -> view.setBackgroundResource(R.color.background_tab_categories)
            2 -> view.setBackgroundResource(R.color.background_tab_cart)
            else -> view.setBackgroundResource(R.color.background_tab_account)
        }
    }
}