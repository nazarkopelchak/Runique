package com.nazarkopelchak.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick : AnalyticsAction
}