@file:Suppress(
    "UnstableApiUsage",
    "DSL_SCOPE_VIOLATION",
)

plugins {
    id(ConventionEnum.AndroidApplication)
    id(ConventionEnum.AndroidApplicationCompose)
}

android {
    namespace = "land.sungbin.androidprojecttemplate"
}

dependencies {
    implementations(
        libs.ktx.core,
        libs.util.oss.license,
        libs.util.logeukes,
        libs.util.systemuicontroller,
        libs.androidx.appcompat,
        libs.androidx.splash,
        libs.androidx.datastore,
    )
}
