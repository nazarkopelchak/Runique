plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.nazarkopelchak.analytics.presentation"
}

dependencies {

    implementation(projects.analytics.domain)
}