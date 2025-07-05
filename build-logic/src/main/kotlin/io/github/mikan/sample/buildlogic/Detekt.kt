package io.github.mikan.sample.buildlogic

import io.github.mikan.sample.buildlogic.dsl.alias
import io.github.mikan.sample.buildlogic.dsl.library
import io.github.mikan.sample.buildlogic.dsl.libs
import io.github.mikan.sample.buildlogic.dsl.plugin
import io.github.mikan.sample.buildlogic.dsl.plugins
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

internal fun Project.configureDetekt() {
    plugins {
        alias(libs.plugin("detekt"))
    }

    dependencies {
        detektPlugins(libs.library("detektFormatting"))
    }

    detekt {
        parallel = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        buildUponDefaultConfig = true
        autoCorrect = false
        source.setFrom(project.files("./").asFileTree)
    }

    tasks.withType<Detekt> {
        include("**/*.kt")
        include("**/*.kts")
        exclude("**/resources/**")
        exclude("**/build/**")
    }
}

private fun Project.detekt(action: DetektExtension.() -> Unit) {
    configure<DetektExtension> {
        action()
    }
}

private fun DependencyHandlerScope.detektPlugins(artifact: Any) {
    "detektPlugins"(artifact)
}
