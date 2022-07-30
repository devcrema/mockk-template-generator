plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jetbrains.intellij") version "1.7.0"
}

group = "io.github.devcrema"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.2.4")
    plugins.set(listOf("Kotlin", "java"))
}
tasks {
    patchPluginXml {
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """
            .trimIndent())
    }
}