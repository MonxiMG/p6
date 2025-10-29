plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "es.ua.eps.filmoteca"
    compileSdk = 36

    defaultConfig {
        applicationId = "es.ua.eps.filmoteca"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

        //APUNTES DE CLASE
        implementation("androidx.appcompat:appcompat:1.7.0")
        implementation("androidx.core:core-ktx:1.15.0")
        implementation("com.google.android.material:material:1.12.0")
        implementation("androidx.activity:activity-ktx:1.9.3")
        implementation("androidx.fragment:fragment-ktx:1.6.2")
        implementation("androidx.recyclerview:recyclerview:1.3.2")

        // Navigation Component (para menús y fragmentos)
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

        // Testing
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test:core:1.5.0")
        androidTestImplementation("androidx.test:runner:1.5.2")
        androidTestImplementation("androidx.test:rules:1.5.0")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation("androidx.test.espresso:espresso-idling-resource:3.5.1")

}