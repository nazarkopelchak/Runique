plugins {
    alias(libs.plugins.runique.jwm.library)
//    id("java-library")
}

dependencies {
    implementation(projects.core.domain)
}
