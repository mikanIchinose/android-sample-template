androidApplication {
    namespace = "io.github.mikan.sample"

    feature {
        enabled = true
    }

    dependencies {
        implementation("androidx.core:core-ktx:1.16.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.1")
        implementation("androidx.activity:activity-compose:1.10.1")
        implementation("androidx.compose.material3:material3")
    }
}
