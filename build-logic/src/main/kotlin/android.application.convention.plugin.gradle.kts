/**
 * plugins {
 *     id("com.android.application")
 *     id("org.jetbrains.kotlin.plugin.compose")
 *     id("org.jetbrains.kotlin.android")
 * }
 *
 * android {
 *     compileSdk = liba.versions.compileSdk.get().toInt()
 *     defaultConfig {
 *         minSdk = liba.versions.minSdk.get().toInt()
 *     }
 *     compileOptions {
 *         sourceCompatibility = JavaVersion.VERSION_11
 *         targetCompatibility = JavaVersion.VERSION_11
 *     }
 *     buildFeatures {
 *         compose = true
 *     }
 * }
 *
 * kotlin {
 *     compilerOptions {
 *         allWarningsAsErrors.set(properties["warningsAsErrors"] as? Boolean ?: false)
 *         jvmTarget.set(JvmTarget.JVM_11)
 *     }
 * }
 *
 * dependencies {
 *     implementation(platform(libs.androidxComposeBom))
 *     implementation(libs.androidxUi)
 *     implementation(libs.androidxUiGraphics)
 *     implementation(libs.androidxUiToolingPreview)
 *     implementation(libs.androidxMaterial3)
 *     debugImplementation(libs.androidxUiTooling)
 *     debugImplementation(libs.androidxUiTestManifest)
 * }
 */

import io.github.mikan.sample.buildlogic.configureAndroid
import io.github.mikan.sample.buildlogic.configureAndroidCompose
import io.github.mikan.sample.buildlogic.configureKotlin
import io.github.mikan.sample.buildlogic.libs
import io.github.mikan.sample.buildlogic.plugin

with(plugins) {
    apply(libs.plugin("androidApplication").pluginId)
}

configureAndroid()
configureAndroidCompose()
configureKotlin()
