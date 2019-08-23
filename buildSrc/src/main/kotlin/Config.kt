import org.gradle.api.Project
import java.io.File

class Config {
    companion object {
        // Minimum version code, to adjust when the native app goes live to ensure we can upgrade from the old app
        private const val versionCodeMin = 0
        private const val versionFilePath = "metadata/version_name.txt"

        const val compileSdkVersion = 28
        const val minSdkVersion = 19
        const val targetSdkVersion = 28

        fun getVersionCode(project: Project): Int {
            return versionCodeMin + (project.findProperty("versionCode") ?: 1).toString().toInt()
        }

        fun getVersionName(project: Project): String {
            return File("${project.rootDir}/$versionFilePath").readText()
        }

        fun getAndroidKeystoreFile(androidKeystorePath: String?): File? {
            return if (androidKeystorePath == null || androidKeystorePath.isEmpty()) {
                null
            } else {
                File(androidKeystorePath)
            }
        }
    }
}
