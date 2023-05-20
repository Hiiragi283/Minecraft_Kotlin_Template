/**
 * Thanks to MirrgieRiana!
 * Source: https://qiita.com/MirrgieRiana/items/0077dc3b0e1561b3b0e7
 */

import wtf.gofancy.fancygradle.patch.Patch

val modVersion: String = "0.0.0"
val mavenGroup: String = "com.template"
val archivesBaseName: String = "Template"

plugins {
    id("idea")
    id("java")
    id("java-library")
    id("net.minecraftforge.gradle") version "5.1.+"
    id("wtf.gofancy.fancygradle") version "1.0.1"
    kotlin("jvm") version "1.8.+"
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

version = modVersion
group = mavenGroup

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
    options.encoding = "UTF-8"
}

minecraft {

    mappings("stable", "39-1.12")
    accessTransformer("src/main/resources/META-INF/accesstransformer.cfg")

    runs {
        create("client") {
            workingDirectory(project.file("client"))
            args("username", "your_name")
            property("forge.logging.console.level", "debug")
            property("forge.logging.markers", "REGISTRIES")
        }
        create("server") {
            workingDirectory(project.file("server"))
            args("username", "your_name")
            property("forge.logging.console.level", "debug")
            property("forge.logging.markers", "REGISTRIES")
        }
    }
}

repositories {
    maven("https://cursemaven.com")
}

dependencies {

    minecraft("net.minecraftforge:forge:1.12.2-14.23.5.2860")
    implementation(kotlin("stdlib-jdk8", "1.8.21"))
    //Deobfuscated Dependencies
    api(fg.deobf("curse.maven:shadowfacts-forgelin-248453:2785465"))
    implementation(fg.deobf("curse.maven:had-enough-items-557549:4451828"))
    implementation(fg.deobf("curse.maven:the-one-probe-245211:2667280"))
    //Normal Dependencies
    implementation(fg.deobf("curse.maven:dans-mouse-tweaks-461660:3962479"))
    implementation(fg.deobf("curse.maven:infinity-item-editor-290958:3802759"))
    implementation(fg.deobf("curse.maven:itemzoom-261725:2643616"))
    implementation(fg.deobf("curse.maven:placebo-283644:2694382"))

}

tasks {
    processResources {
        inputs.property("version", modVersion)

        filesMatching("mcmod.info") {
            expand("version" to modVersion)
        }
    }
}

fancyGradle {
    patches {
        patch(Patch.RESOURCES, Patch.COREMODS, Patch.CODE_CHICKEN_LIB, Patch.ASM)
    }
}