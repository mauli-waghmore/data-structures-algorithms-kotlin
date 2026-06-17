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
    group = "dsa"
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

fun humanize(name: String): String =
    name.replace(Regex("([a-z0-9])([A-Z])"), "$1 $2")
        .replace(Regex("([A-Z]+)([A-Z][a-z])"), "$1 $2")

tasks.register("newProblem") {
    group = "dsa"
    description = "Scaffolds a solution + test. Usage: ./gradlew newProblem -Pid=category.technique.Name"
    doLast {
        val id = project.findProperty("id") as String?
            ?: throw GradleException("Usage: ./gradlew newProblem -Pid=category.technique.Name")
        val parts = id.split(".")
        if (parts.size < 3) {
            throw GradleException("id must be category.technique.Name, e.g. arrays.two_pointers.TwoSum")
        }
        val name = parts.last()
        val pkg = parts.dropLast(1).joinToString(".")
        val pkgPath = parts.dropLast(1).joinToString("/")
        val solution = file("src/$pkgPath/$name.kt")
        val test = file("test/$pkgPath/${name}Test.kt")
        if (solution.exists()) {
            throw GradleException("Already exists: ${solution.relativeTo(projectDir)}")
        }
        val title = humanize(name)
        val fn = name.replaceFirstChar { it.lowercase() }
        solution.parentFile.mkdirs()
        test.parentFile.mkdirs()
        solution.writeText(
            """
            package $pkg

            /**
             * $title
             * ${"-".repeat(title.length)}
             * TODO: state the problem in a sentence or two.
             *
             * Example:
             *   input -> output
             *
             * Approach:  TODO
             * Time:      O(?)
             * Space:     O(?)
             */
            fun $fn() {
                TODO("implement $title")
            }

            fun main() {
                $fn()
            }
            """.trimIndent() + "\n"
        )
        test.writeText(
            """
            package $pkg

            import kotlin.test.Test

            class ${name}Test {

                @Test
                fun `solves the example`() {
                }
            }
            """.trimIndent() + "\n"
        )
        println("✅ Created:")
        println("   ${solution.relativeTo(projectDir)}")
        println("   ${test.relativeTo(projectDir)}")
        println("▶  Run it later with: ./gradlew runProblem -Pmain=$pkg.${name}Kt")
    }
}

tasks.register("reviewRandom") {
    group = "dsa"
    description = "Picks a random solved problem to revisit."
    doLast {
        val files = fileTree("src") { include("*/*/**/*.kt") }.files.toList()
        if (files.isEmpty()) {
            println("No problems yet — add one with: ./gradlew newProblem -Pid=category.technique.Name")
            return@doLast
        }
        val pick = files.random()
        val rel = pick.relativeTo(projectDir).path
        val trimmed = rel.removePrefix("src/").removeSuffix(".kt").split("/")
        val pkg = trimmed.dropLast(1).joinToString(".")
        val name = trimmed.last()
        println("🎯 Revisit this one (try to re-solve it from scratch):")
        println("   $rel")
        println("▶  ./gradlew runProblem -Pmain=$pkg.${name}Kt")
    }
}
