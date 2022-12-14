@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import land.sungbin.androidprojecttemplate.convention.ApplicationConstants
import land.sungbin.androidprojecttemplate.convention.PluginEnum
import land.sungbin.androidprojecttemplate.convention.applyPlugins
import land.sungbin.androidprojecttemplate.convention.configureApplication

/**
 * Android 프레임워크의 Library 환경을 구성합니다.
 */
internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(
        target: Project,
    ) {
        with(
            receiver = target,
        ) {
            applyPlugins(
                PluginEnum.AndroidLibrary,
                PluginEnum.AndroidKotlin,
            )

            extensions.configure<LibraryExtension> {
                configureApplication(
                    extension = this,
                )

                buildFeatures {
                    buildConfig = false
                }

                defaultConfig.targetSdk = ApplicationConstants.targetSdk
            }
        }
    }
}
