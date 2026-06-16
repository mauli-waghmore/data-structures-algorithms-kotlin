plugins {
    kotlin("jvm") version "2.0.21"
}

group = "io.github.mauliwaghmore.dsa"
version = "1.0." + fileTree("src") { include("*/*/**/*.kt") }.files.size

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

sourceSets {
    main {
        kotlin.srcDirs("src")
        resources.srcDirs("resources")
    }
    test {
        kotlin.srcDirs("test")
        resources.srcDirs("testResources")
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = false
    }
}

tasks.register<JavaExec>("runProblem") {
    group = "application"
    description = "Runs one problem's main(). Usage: ./gradlew runProblem -Pmain=<package.FileKt>"
    classpath = sourceSets.main.get().runtimeClasspath
    val target = project.findProperty("main") as String?
    target?.let { mainClass.set(it) }
    doFirst {
        require(target != null) {
            "Specify which problem to run, e.g. ./gradlew runProblem -Pmain=strings.greedy.LineWrapKt"
        }
    }
}
