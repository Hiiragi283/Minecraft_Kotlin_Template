pluginManagement {

    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        maven("https://gitlab.com/api/v4/projects/26758973/packages/maven")
        maven("https://maven.minecraftforge.net")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "net.minecraftforge.gradle" -> useModule("net.minecraftforge.gradle:ForgeGradle:5.1.11")
            }
        }
    }
}

rootProject.name = "template"