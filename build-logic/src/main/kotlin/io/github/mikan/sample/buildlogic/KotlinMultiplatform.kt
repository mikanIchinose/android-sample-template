package io.github.mikan.sample.buildlogic

import com.android.build.api.dsl.androidLibrary
import io.github.mikan.sample.buildlogic.dsl.kotlinMultiplatform
import io.github.mikan.sample.buildlogic.dsl.library
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import io.github.mikan.sample.buildlogic.dsl.version
import org.gradle.api.Project

internal fun Project.configureKotlinMultiplatform() {
    plugins {
        apply(libs.plugin("kotlinMultiplatform").pluginId)
        apply(libs.plugin("androidKotlinMultiplatformLibrary").pluginId)
    }

    kotlinMultiplatform {
        androidLibrary {
            compileSdk = libs.version("compileSdk").toInt()
            minSdk = libs.version("minSdk").toInt()

            withHostTestBuilder {
            }

            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }.configure {
                instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }

        iosX64()
        iosArm64()
        iosSimulatorArm64()

        with(sourceSets) {
            commonMain.dependencies {
                implementation(libs.library("kotlinStdlib"))
            }
            commonTest.dependencies {
                implementation(libs.library("kotlinTest"))
            }
            androidMain.dependencies {
            }
            getByName("androidDeviceTest").dependencies {
                implementation(libs.library("runner"))
                implementation(libs.library("core"))
                implementation(libs.library("junit"))
            }
            iosMain.dependencies {
            }
        }
    }
}
