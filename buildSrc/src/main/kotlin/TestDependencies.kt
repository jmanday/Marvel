object TestDependencies {
    object Version {
        const val junit = "4.13.2"
        const val androidJunit = "1.1.5"
        const val androidEspresso = "3.5.1"
    }

    const val junit = "junit:junit:${Version.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Version.junit}"
    const val androidEspresso = "androidx.test.espresso:espresso-core:${Version.junit}"
}