package io.github.mikan.sample.convention

import io.github.mikan.sample.buildlogic.configureAndroid
import io.github.mikan.sample.buildlogic.configureAndroidCompose
import io.github.mikan.sample.buildlogic.configureDetekt
import io.github.mikan.sample.buildlogic.configureKotlin
import io.github.mikan.sample.buildlogic.configureUnitTest
import io.github.mikan.sample.buildlogic.dsl.alias
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins {
                alias(libs.plugin("androidApplication"))
            }

            configureKotlin()
            configureAndroid()
            configureAndroidCompose()
            configureDetekt()
            configureUnitTest()
        }
    }
}