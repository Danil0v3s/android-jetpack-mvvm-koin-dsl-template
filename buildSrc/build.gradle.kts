import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

repositories {
    jcenter()
}