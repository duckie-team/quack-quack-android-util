import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.androidprojecttemplate.convention.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Android 프레임워크의 Application 환경에서 Jetpack Compose 를 사용할 준비를 합니다.
 */
internal class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(
        target: Project,
    ) {
        with(
            receiver = target,
        ) {
            val extension = extensions.getByType<BaseAppModuleExtension>()

            configureCompose(
                extension = extension,
            )
        }
    }
}
