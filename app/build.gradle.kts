import com.android.build.gradle.internal.dsl.TestOptions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("jacoco-android")
    id("androidx.navigation.safeargs.kotlin")
//    id("com.google.gms.google-services")
}

jacoco {
    toolVersion = Libs.jacocoToolsVersion
}

jacocoAndroidUnitTestReport {
    csv.enabled(false)
    html.enabled(true)
    xml.enabled(true)
}

android {

    defaultConfig {
        compileSdkVersion(Config.compileSdkVersion)
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        versionCode = Config.getVersionCode(project)
        versionName = Config.getVersionName(project)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }

    compileOptions {
        this.sourceCompatibility = JavaVersion.VERSION_1_8
        this.targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("debug").java.srcDirs("src/debug/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }

    signingConfigs {
        create("release") {
            storeFile = Config.getAndroidKeystoreFile(System.getenv("ANDROID_KEYSTORE"))
            storePassword = System.getenv("ANDROID_KEYSTORE_PASSWORD")
            keyAlias = System.getenv("ANDROID_KEY_ALIAS")
            keyPassword = System.getenv("ANDROID_KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            isTestCoverageEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = true
            isZipAlignEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions("default")
    productFlavors {
        create("base") {
            applicationId = "com.boilerplate.android"
            setDimension("default")
        }
    }

    testOptions {
        unitTests(delegateClosureOf<TestOptions.UnitTestOptions> {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
            all(KotlinClosure1<Any, Test>({
                (this as Test).also { testTask ->
                    testTask.extensions.getByType(JacocoTaskExtension::class.java).isIncludeNoLocationClasses = true
                }
            }, this))
        })
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.multidex)
    implementation(Libs.kotlin)
    implementation(Libs.Appcompat.appcompat)
    implementation(Libs.Appcompat.preferences)
    implementation(Libs.Appcompat.kotlinCore)
    implementation(Libs.Support.design)
    implementation(Libs.Support.navigationFragment)
    implementation(Libs.UI.navigationUi)
    implementation(Libs.Support.fragment)
    implementation(Libs.UI.constraintLayout)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.viewModel)
    implementation(Libs.Network.retrofit2)
    implementation(Libs.Network.okhttp3)
    implementation(Libs.Network.loggingInterceptor)
    implementation(Libs.Network.moshi)
    implementation(Libs.Network.retrofit2ConverterMoshi)
    implementation(Libs.Room.runtime)
    kapt(Libs.Room.compiler)
    implementation(Libs.Room.ktx)
    implementation(Libs.kotlinCoroutinesAndroid)
    implementation(Libs.firebase)
    implementation(Libs.multidex)
    implementation(Libs.UI.shimmer)

    testImplementation(Libs.Test.fragment)
    testImplementation(Libs.Test.robolectric)
    testImplementation(Libs.Test.runner)
    testImplementation(Libs.Test.androidJunit)
    testImplementation(Libs.Test.rules)
    testImplementation(Libs.Test.core)
    testImplementation(Libs.Test.archCore)
    testImplementation(Libs.Test.coroutines)

    testImplementation(Libs.Test.mockitoInline)
    testImplementation(Libs.Test.koin)
    androidTestImplementation(Libs.Test.espressoCore)
}

apply(from = "../gradle_resources/jacoco.gradle.kts")
apply(from = "../gradle_resources/ktlint.gradle.kts")