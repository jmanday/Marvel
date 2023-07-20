object NetworkDependencies {
    object Versions {
        const val retrofit = "2.9.0"
        const val gson = "2.9.0"
        const val loggingInterceptor = "4.10.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}