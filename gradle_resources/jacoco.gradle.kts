tasks.register<JacocoMerge>("jacocoMerge") {
    description = "Merges the reports of UI and unit tests into a single exec file"
    executionData(
        fileTree(
            mapOf(
                "dir" to "$buildDir",
                "includes" to listOf("**/*.exec", "**/*.ec")
            )
        )
    )
    destinationFile = file("$buildDir/jacoco/fullCoverage.exec")
}
