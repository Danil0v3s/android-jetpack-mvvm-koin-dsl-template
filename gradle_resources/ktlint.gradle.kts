val ktlint: Configuration by configurations.creating
val htmlReporter: Configuration by configurations.creating

dependencies {
    ktlint(Libs.ktLint.ktlint)
    htmlReporter(Libs.ktLint.htmlReporter)
}

/**
 * Check for lint issues on kotlin code
 */
tasks.register<JavaExec>("ktCheck") {
    group = "verification"
    description = "Check Kotlin code style."
    classpath = ktlint
    main = "com.github.shyiko.ktlint.Main"
    args(
        "--android",
        "src/**/*.kt",
        "--reporter=plain",
        "--reporter=html,artifact=me.cassiano:ktlint-html-reporter:0.1.2,output=${buildDir}/reports/ktlint/ktlint_report.html",
        "--reporter=checkstyle,output=${buildDir}/reports/ktlint/ktlint-report-in-checkstyle-format.xml"
    )
}

/**
 * Detect lint issues and automatically format/fix kotlin code
 */
tasks.register<JavaExec>("ktFormat") {
    group = "kotlin Formatting"
    description = "Fix Kotlin code style deviations."
    args("-F", "src/**/*.kt")
    classpath = ktlint
    main = "com.github.shyiko.ktlint.Main"
}