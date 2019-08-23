package com.boilerplate.android.business.analytics

import android.os.Bundle

interface AnalyticsService {
    fun sendAnalyticsEvent(event: AnalyticsEvents, params: Bundle)
}