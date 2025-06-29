plugins {
    `kotlin-dsl`
    alias(libs.plugins.androidLint)
}

group = "io.github.mikan.sample.buildlogic"

dependencies {
    implementation(libs.bundles.plugins)
    lintChecks(libs.androidxLintGradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "sample.convention.android.application"
            implementationClass = "io.github.mikan.sample.convention.AndroidApplicationPlugin"
        }
        register("kotlinMultiplatform") {
            id = "sample.convention.kotlin.multiplatform"
            implementationClass = "io.github.mikan.sample.convention.KotlinMultiplatformPlugin"
        }
    }
}
