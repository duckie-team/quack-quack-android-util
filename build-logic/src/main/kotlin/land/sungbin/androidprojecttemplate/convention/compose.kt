@file:Suppress("UnstableApiUsage")

package land.sungbin.androidprojecttemplate.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Jetpack Compose 를 사용하기 위한 그레이들 환경을 설정합니다.
 *
 * @param extension 설정할 그레이들의 [CommonExtension]
 */
internal fun Project.configureCompose(
    extension: CommonExtension<*, *, *, *>,
) {
    extension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().toString()
        }

        dependencies {
            setupCompose(
                core = libs.findBundle("compose-core").get(),
                debug = libs.findBundle("compose-debug").get(),
            )
        }
    }
}
