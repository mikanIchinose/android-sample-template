package io.github.mikan.sample.buildlogic

import io.github.mikan.sample.buildlogic.dsl.alias
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension


internal fun Project.configureKotlin() {
    plugins {
        alias(libs.plugin("kotlinAndroid"))
    }

    configure<KotlinAndroidProjectExtension> {
        compilerOptions {
            // Treat all Kotlin warning as errors
            allWarningsAsErrors.set(properties["warningsAsErrors"] as? Boolean ?: false)
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
}