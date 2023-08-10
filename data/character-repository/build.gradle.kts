plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.jmanday.character_repository"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        // defining fields just used by compile time
        buildConfigField("String", "PUBLIC_KEY", "\"410d8d5ca72063c4ea4f60b06b35dd18\"")
        buildConfigField("String", "TS", "\"1\"")
        buildConfigField("String", "HASH_KEY", "\"1be845961364a54c6668f492c58e0644dbbace176410d8d5ca72063c4ea4f60b06b35dd18\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":domain:character"))
    implementation(project(":data:character-remote"))

    KotlinxDependencies.apply {
        implementation(kotlinCoroutines)
    }

    DIDependencies.apply {
        implementation(hiltAndroid)
        kapt(dagerHiltCompiler)
    }

    TestDependencies.apply {
        testImplementation(junit)
        testImplementation(mockk)
        androidTestImplementation(androidEspresso)
        testImplementation(coroutinesTest)
        androidTestImplementation(coroutinesTest)
    }
}