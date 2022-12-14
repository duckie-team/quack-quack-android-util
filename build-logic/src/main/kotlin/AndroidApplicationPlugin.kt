@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.androidprojecttemplate.convention.ApplicationConstants
import land.sungbin.androidprojecttemplate.convention.PluginEnum
import land.sungbin.androidprojecttemplate.convention.applyPlugins
import land.sungbin.androidprojecttemplate.convention.configureApplication
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android 프레임워크의 Application 환경을 구성합니다.
 */
internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(
        target: Project,
    ) {
        with(
            receiver = target,
        ) {
            applyPlugins(
                PluginEnum.AndroidApplication,
                PluginEnum.AndroidKotlin,
            )

            extensions.configure<BaseAppModuleExtension> {
                configureApplication(
                    extension = this,
                )

                defaultConfig {
                    targetSdk = ApplicationConstants.targetSdk
                    versionName = ApplicationConstants.versionName
                    versionCode = ApplicationConstants.versionCode
                }
            }
        }
    }
}
