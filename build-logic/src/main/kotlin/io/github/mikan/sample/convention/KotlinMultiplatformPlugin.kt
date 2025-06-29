package io.github.mikan.sample.convention

import io.github.mikan.sample.buildlogic.configureKotlinMultiplatform
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class KotlinMultiplatformPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureKotlinMultiplatform()
        }
    }
}