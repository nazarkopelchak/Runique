import com.android.build.api.dsl.DynamicFeatureExtension
import com.nazarkopelchak.convention.ExtensionTypes
import com.nazarkopelchak.convention.addUiLayerDependencies
import com.nazarkopelchak.convention.configureAndroidCompose
import com.nazarkopelchak.convention.configureBuildTypes
import com.nazarkopelchak.convention.configureKotlinAndroid
import com.nazarkopelchak.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidDynamicFeatureConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.dynamic-feature")
                apply("org.jetbrains.kotlin.android")
                apply(libs.findPlugin("kotlin.compose").get().get().pluginId)
            }

            extensions.configure<DynamicFeatureExtension> {

                configureKotlinAndroid(this)
                configureAndroidCompose(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionTypes = ExtensionTypes.DYNAMIC_FEATURE
                )
            }

            dependencies {
                addUiLayerDependencies(target)
                "testImplementation"(kotlin("test"))
            }
        }
    }
}