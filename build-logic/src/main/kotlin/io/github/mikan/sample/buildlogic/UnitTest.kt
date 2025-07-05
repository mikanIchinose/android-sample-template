package io.github.mikan.sample.buildlogic

import io.github.mikan.sample.buildlogic.dsl.library
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.testImplementation
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureUnitTest() {
    dependencies {
        testImplementation(libs.library("kotlinTest"))
    }
}