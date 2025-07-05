package io.github.mikan.sample.buildlogic

import io.github.mikan.sample.buildlogic.dsl.alias
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import org.gradle.api.Project

internal fun Project.configureKmpCompose() {
    plugins {
        alias(libs.plugin("kotlinCompose"))
    }
}