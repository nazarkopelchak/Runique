package com.nazarkopelchak.analyt.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.play.core.splitcompat.SplitCompat
import com.nazarkopelchak.analytics.data.di.analyticsModule
import com.nazarkopelchak.analytics.presentation.AnalyticsDashboardScreenRoot
import com.nazarkopelchak.analytics.presentation.di.analyticsPresentationModule
import com.nazarkopelchak.core.presentation.designsystem.RuniqueTheme
import org.koin.core.context.loadKoinModules

class AnalyticsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(listOf(analyticsModule, analyticsPresentationModule))
        SplitCompat.installActivity(this)

        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "analytics_dashboard"
                ) {
                    composable("analytics_dashboard") {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = { finish() }
                        )
                    }
                }
            }
        }
    }
}