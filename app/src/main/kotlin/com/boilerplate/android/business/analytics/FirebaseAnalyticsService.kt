package com.boilerplate.android.business.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalyticsService(private val fAnalytics: FirebaseAnalytics) :
    AnalyticsService {

    override fun sendAnalyticsEvent(event: AnalyticsEvents, params: Bundle) {
        fAnalytics.logEvent(event.name, params)
    }
}