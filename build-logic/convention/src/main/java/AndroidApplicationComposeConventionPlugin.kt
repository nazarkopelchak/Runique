import com.android.build.api.dsl.ApplicationExtension
import com.nazarkopelchak.convention.configureAndroidCompose
import com.nazarkopelchak.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("runique.android.application")
            pluginManager.apply(libs.findPlugin("kotlin.compose").get().get().pluginId)

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}