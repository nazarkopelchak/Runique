plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jwm.ktor)
}

android {
    namespace = "com.nazarkopelchak.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}