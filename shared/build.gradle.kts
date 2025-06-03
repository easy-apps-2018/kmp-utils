import org.jetbrains.kotlin.gradle.dsl.JvmTarget

import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    androidTarget().compilations.all {
        compileTaskProvider.configure {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_23)
            }
        }
    }
    
    val xcf = XCFramework()
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
        it.binaries.framework {
            xcf.add(this)
            isStatic = true
            baseName = "shared"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(libs.navigation.compose)
            implementation(libs.compose.components.resources)
        }
    }
}

publishing.publications.withType<MavenPublication> {
    version = "0.0.0.1"
    groupId = "com.easyapps"
    artifactId = "kmputils"
}

android {
    compileSdk = 35
    namespace = "com.easyapps.kmputils"
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_23
        targetCompatibility = JavaVersion.VERSION_23
    }
}
