@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.api.dsl.ManagedVirtualDevice
import com.android.build.gradle.TestExtension
import land.sungbin.androidprojecttemplate.convention.ApplicationConstants
import land.sungbin.androidprojecttemplate.convention.PluginEnum
import land.sungbin.androidprojecttemplate.convention.applyPlugins
import land.sungbin.androidprojecttemplate.convention.configureApplication
import land.sungbin.androidprojecttemplate.convention.implementations
import land.sungbin.androidprojecttemplate.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies

/**
 * Android 프레임워크에 의존적인 밴치마크 모듈을 구성합니다.
 *
 * benchmark-ui-components-app 모듈의 baseline profiles 을 생성하기 위해
 * 사용됩니다.
 */
internal class AndroidBenchmarkPlugin : Plugin<Project> {
    override fun apply(
        target: Project,
    ) {
        with(
            receiver = target,
        ) {
            applyPlugins(
                PluginEnum.AndroidTest,
                PluginEnum.AndroidKotlin,
            )

            extensions.configure<TestExtension> {
                configureApplication(
                    extension = this,
                )

                defaultConfig {
                    targetSdk = ApplicationConstants.targetSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                // targetProjectPath = throw Throwable("targetProjectPath is not set.")
                // experimentalProperties["android.experimental.self-instrumenting"] = true

                // testOptions {
                //     managedDevices {
                //         devices {
                //             create(
                //                 name = "pixel6Api31",
                //                 type = ManagedVirtualDevice::class,
                //             ) {
                //                 device = "Pixel 6"
                //                 apiLevel = 31
                //                 systemImageSource = "aosp"
                //             }
                //         }
                //     }
                // }
            }

            dependencies {
                implementations(
                    libs.findBundle("benchmark").get(),
                )
            }
        }
    }
}
