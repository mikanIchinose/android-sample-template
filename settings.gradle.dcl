pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Disabled declarative gradle to avoid plugin conflicts
    id("org.gradle.experimental.android-ecosystem").version("0.1.44")
    id("org.gradle.experimental.kmp-ecosystem").version("0.1.44") // For the Kotlin JVM Library used by :lint
}

dependencyResolutionManagement {
    repositoriesMode = FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
    }
}


defaults {
    androidApplication {
        jdkVersion = 17
        minSdk = 21
        targetSdk = 36
        compileSdk = 36

        versionCode = 1
        versionName = "1.0"
        applicationId = "io.github.mikan.sample"

        lint {
            enabled = true
        }

        compose {
            enabled = true
        }

        hilt {
            enabled = true
        }
    }

    androidLibrary {
        jdkVersion = 17
        minSdk = 21
        targetSdk = 36
        compileSdk = 36

        lint {
            enabled = true
        }

        compose {
            enabled = true
        }

        hilt {
            enabled = true
        }
    }

    androidTest {
        jdkVersion = 17
        minSdk = 26
        compileSdk = 36
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Sample"
include(":app")
