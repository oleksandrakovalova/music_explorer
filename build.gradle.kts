buildscript {
    extra.apply {
        set("compose_compiler_version", "1.5.15")
        set("compose_version", "1.7.8")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.8.1" apply false
    id("com.android.library") version "8.8.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false
    id("org.jetbrains.kotlin.jvm") version "2.0.20" apply false
    id("org.jetbrains.dokka") version "1.8.20"
}

true