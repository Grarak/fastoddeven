import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.grarak"
version = "1.0.0"

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "io.github.grarak.fastoddeven"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "fastoddeven", version.toString())

    pom {
        name = "Fastoddeven"
        description = "A quick math library"
        inceptionYear = "2024"
        url = "https://github.com/Grarak/fastoddeven"
        licenses {
            license {
                name = "MIT License"
                url = "http://www.opensource.org/licenses/mit-license.php"
                distribution = "repo"
            }
        }
        developers {
            developer {
                id = "Grarak"
                name = "Grarak"
                url = "https://github.com/Grarak/"
            }
        }
        scm {
            url = "https://github.com/Grarak/fastoddeven/"
            connection = "scm:git:git://github.com/Grarak/fastoddeven.git"
            developerConnection = "scm:git:ssh://git@github.com/Grarak/fastoddeven.git"
        }
    }
}
