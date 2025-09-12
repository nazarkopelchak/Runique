plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jwm.ktor)
}

android {
    namespace = "com.nazarkopelchak.auth.data"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}