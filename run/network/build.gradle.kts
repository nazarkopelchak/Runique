plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jwm.ktor)
}

android {
    namespace = "com.nazarkopelchak.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}