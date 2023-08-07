object TestDependencies {
    object Versions {
        const val junit = "4.13.2"
        const val androidJunit = "1.1.5"
        const val androidEspresso = "3.5.1"
        const val coroutinesTest = "1.6.4"
        const val mockitoKotlin = "4.1.0"
        const val mockk = "1.13.5"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val androidEspresso = "androidx.test.espresso:espresso-core:${Versions.androidEspresso}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val mokitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}