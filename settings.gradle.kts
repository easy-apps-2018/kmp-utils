enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":shared")
rootProject.name = "KMP_Utils"

pluginManagement.repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencyResolutionManagement.repositories {
    google()
    mavenCentral()
}