import io.github.mikan.sample.buildlogic.configureAndroid
import io.github.mikan.sample.buildlogic.configureAndroidCompose
import io.github.mikan.sample.buildlogic.configureKotlin
import io.github.mikan.sample.buildlogic.libs
import io.github.mikan.sample.buildlogic.plugin

with(plugins) {
    apply(libs.plugin("androidLibrary").pluginId)
}

configureAndroid()
configureAndroidCompose()
configureKotlin()
