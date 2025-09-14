plugins {
    //id("java-library")
    alias(libs.plugins.runique.jwm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.domain)
}
