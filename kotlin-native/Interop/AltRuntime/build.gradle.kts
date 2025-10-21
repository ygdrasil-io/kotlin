import org.gradle.kotlin.dsl.project

plugins {
    kotlin("multiplatform")
}


kotlin {

    jvm()

    if (kotlinBuildProperties.isInIdeaSync) {
        val hostOs = System.getProperty("os.name")
        val isMingwX64 = hostOs.startsWith("Windows")
        val nativeTarget = when {
            hostOs == "Mac OS X" -> macosX64("native")
            hostOs == "Linux" -> linuxX64("native")
            isMingwX64 -> mingwX64("native")
            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
        }
        nativeTarget.compilerOptions {
            freeCompilerArgs.addAll(
                    listOf(
                            "-Xallow-kotlin-package",
                            "-Xexpect-actual-classes",
                            "-nostdlib",
                    )
            )
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":kotlin-stdlib"))
            }
        }

        nativeMain {
            kotlin {
                srcDir("$rootDir/kotlin-native/runtime/src/main/kotlin")
            }
        }
    }
}