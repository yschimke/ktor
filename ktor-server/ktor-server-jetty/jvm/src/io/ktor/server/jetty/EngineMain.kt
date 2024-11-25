/*
 * Copyright 2014-2019 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.server.jetty

import io.ktor.server.config.*
import io.ktor.server.engine.*

/**
 * Jetty engine
 */
@Deprecated(
    "The ktor-server-jetty module is deprecated and will be removed in the next major release as it " +
        "references an outdated version of Jetty. Please use the ktor-server-jetty-jakarta module instead."
)
public object EngineMain {
    /**
     * Main function for starting EngineMain with Jetty
     * Creates an embedded Jetty application with an environment built from command line arguments.
     */
    @JvmStatic
    public fun main(args: Array<String>) {
        val config = CommandLineConfig(args)
        val server = EmbeddedServer(config.rootConfig, Jetty) {
            takeFrom(config.engineConfig)
            loadConfiguration(config.rootConfig.environment.config)
        }
        server.start(true)
    }

    private fun JettyApplicationEngineBase.Configuration.loadConfiguration(config: ApplicationConfig) {
        val deploymentConfig = config.config("ktor.deployment")
        loadCommonConfiguration(deploymentConfig)
    }
}
