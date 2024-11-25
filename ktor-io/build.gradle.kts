/*
 * Copyright 2014-2024 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */


plugins {
    alias(libs.plugins.kover)
}

kotlin {
    createCInterop("mutex", posixTargets()) {
        definitionFile = File(projectDir, "posix/interop/mutex.def")
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.io.core)
            }
        }
        commonTest {
            dependencies {
                api(project(":ktor-test-dispatcher"))
            }
        }
    }
}
