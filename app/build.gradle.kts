@file:Suppress("DEPRECATION")

plugins {
    alias(libs.plugins.android.application)
    kotlin("android") version "1.8.22"
}

android {
    namespace = "com.example.option3"
    compileSdk = 34
    apply(plugin = "com.android.application")
    apply(plugin = "kotlin-android")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.example.option3"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        externalNativeBuild {
            cmake {
                file("src/main/cpp/CMakeLists.txt")
            }
        }
    }



    buildFeatures {
        viewBinding = true
    }
}


dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.20")
    implementation(libs.monitor)
    implementation(libs.ext.junit)
    testImplementation(libs.junit.junit)
}

tasks.register<Jar>("jar") {
    archiveBaseName.set("Option3")
    archiveVersion.set("1.0")
    destinationDirectory.set(file("${project.buildDir}/libs"))

    // Include all Java files in the JAR
    from(fileTree("src/main/java")) {
        include("**/*.class") // Ensure only .class files are included
    }

    from("src/main/resources") // Include resources if any

    manifest {
        attributes(
            "Main-Class" to "com.example.option3.MainClass"
        )
    }
}



