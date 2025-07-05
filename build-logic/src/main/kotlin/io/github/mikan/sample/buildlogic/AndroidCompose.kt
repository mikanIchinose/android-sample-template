package io.github.mikan.sample.buildlogic

import io.github.mikan.sample.buildlogic.dsl.android
import io.github.mikan.sample.buildlogic.dsl.debugImplementation
import io.github.mikan.sample.buildlogic.dsl.implementation
import io.github.mikan.sample.buildlogic.dsl.library
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose() {
    plugins {
        apply(libs.plugin("kotlinCompose").pluginId)
    }

    android {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        implementation(platform(libs.library("androidxComposeBom")))
        implementation(libs.library("androidxUi"))
        implementation(libs.library("androidxUiGraphics"))
        implementation(libs.library("androidxUiToolingPreview"))
        implementation(libs.library("androidxMaterial3"))
        debugImplementation(libs.library("androidxUiTooling"))
        debugImplementation(libs.library("androidxUiTestManifest"))
    }
}
