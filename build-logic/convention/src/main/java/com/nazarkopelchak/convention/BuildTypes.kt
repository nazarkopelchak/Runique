package com.nazarkopelchak.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionTypes: ExtensionTypes
) {
    commonExtension.apply {
        buildFeatures {
            buildConfig = true
        }

        val apiKey = gradleLocalProperties(project.rootDir, providers).getProperty("API_KEY")
        when(extensionTypes) {
            ExtensionTypes.APPLICATION -> {
                extensions.configure<ApplicationExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(apiKey)
                        }
                        release {
                            configureReleaseBuildType(apiKey, commonExtension)
                        }
                    }
                }
            }
            ExtensionTypes.LIBRARY -> {
                extensions.configure<LibraryExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(apiKey)
                        }
                        release {
                            configureReleaseBuildType(apiKey, commonExtension)
                        }
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuildType(apiKey: String) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")    // This syntax is necessary for buildConfigField
    buildConfigField("String", "BASE_URL", "\"https://runique.pl-coding.com:8080\"")    //TODO Replace the base url
}

private fun BuildType.configureReleaseBuildType(
    apiKey: String,
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")    // This syntax is necessary for buildConfigField
    buildConfigField("String", "BASE_URL", "\"https://runique.pl-coding.com:8080\"")    //TODO Replace the base url

    isMinifyEnabled = true
    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}