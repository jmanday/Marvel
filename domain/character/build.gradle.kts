plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jmanday.marvelcharacter"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    KotlinxDependencies.apply {
        implementation(kotlinCoroutines)
    }

    AndroidxDependencies.apply {
        implementation(coreKtx)
    }

    DIDependencies.apply {
        implementation(javaxInject)
    }

    TestDependencies.apply {
        testImplementation(junit)
        testImplementation(mockk)
        testImplementation(coroutinesTest)
    }

}