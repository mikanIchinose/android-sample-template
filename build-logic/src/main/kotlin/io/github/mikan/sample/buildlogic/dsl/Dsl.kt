package io.github.mikan.sample.buildlogic.dsl

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>()
        .named("libs")

internal fun VersionCatalog.version(name: String) = findVersion(name).get().requiredVersion

internal fun VersionCatalog.library(name: String) = findLibrary(name).get()

internal fun VersionCatalog.plugin(name: String) = findPlugin(name).get()

internal fun VersionCatalog.bundle(name: String) = findBundle(name).get().get()

internal fun DependencyHandlerScope.implementation(artifact: Any) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.debugImplementation(artifact: Any) {
    add("debugImplementation", artifact)
}

internal fun DependencyHandlerScope.testImplementation(artifact: Any) {
    add("testImplementation", artifact)
}

private val Project.androidApplication: ApplicationExtension
    get() = extensions.getByType<ApplicationExtension>()

private val Project.androidLibrary: LibraryExtension
    get() = extensions.getByType<LibraryExtension>()

internal fun Project.androidApplication(actions: ApplicationExtension.() -> Unit) {
    androidApplication.actions()
}

internal fun Project.androidLibrary(actions: LibraryExtension.() -> Unit) {
    androidLibrary.actions()
}

internal fun Project.android(action: CommonExtension<*, *, *, *, *, *>.() -> Unit) {
    runCatching { androidLibrary }
        .recoverCatching { androidApplication }
        .onFailure { println("Could not find Library or Application extension from this project") }
        .getOrThrow()
        .action()
}

internal fun Project.kotlinMultiplatform(action: KotlinMultiplatformExtension.() -> Unit) {
    extensions.getByType<KotlinMultiplatformExtension>().action()
}

internal fun Project.plugins(action: PluginManager.() -> Unit) {
    pluginManager.action()
}

internal fun PluginManager.alias(plugin: Provider<PluginDependency>) {
    apply(plugin.get().pluginId)
}
