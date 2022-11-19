@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    `kotlin-dsl`
}

group = "land.sungbin.androidprojecttemplate.convention"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.build.kotlin)
    implementation(libs.build.kover)
    implementation(libs.build.gradle.agp)
}

gradlePlugin {
    val prefix = "template"
    plugins {
        // TODO: benchmark setup
        // register("androidQuackUiComponentsBenchmarkPlugin") {
        //     id = "$prefix.android.quack.ui.components.benchmark"
        //     implementationClass = "AndroidQuackUiComponentsBenchmarkPlugin"
        // }
        register("androidApplicationPlugin") {
            id = "$prefix.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidApplicationComposePlugin") {
            id = "$prefix.android.application.compose"
            implementationClass = "AndroidApplicationComposePlugin"
        }
        register("androidLibraryPlugin") {
            id = "$prefix.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidLibraryComposePlugin") {
            id = "$prefix.android.library.compose"
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("androidLibraryComposeUiTestPlugin") {
            id = "$prefix.android.library.compose.uitest"
            implementationClass = "AndroidLibraryComposeUiTestPlugin"
        }
        register("jvmJunit4Plugin") {
            id = "$prefix.jvm.junit4"
            implementationClass = "JvmJUnit4Plugin"
        }
        register("jvmLibraryPlugin") {
            id = "$prefix.jvm.library"
            implementationClass = "JvmLibraryPlugin"
        }
        register("dependencyGraphPlugin") {
            id = "$prefix.jvm.dependency.graph"
            implementationClass = "DependencyGraphPlugin"
        }
    }
}
