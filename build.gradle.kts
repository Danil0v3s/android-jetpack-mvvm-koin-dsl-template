buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.Gradle.androidGradlePlugin)
        classpath(Libs.Gradle.kotlinGradlePlugin)
        classpath(Libs.Gradle.jacocoGradlePlugin)
        classpath(Libs.Gradle.googleServicesGradlePlugin)
        classpath(Libs.Gradle.proguard)
        classpath(Libs.Gradle.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}