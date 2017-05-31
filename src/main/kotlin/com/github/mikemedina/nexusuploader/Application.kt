package com.github.mikemedina.nexusuploader

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {
    @Bean
    open fun restTemplate() = RestTemplateBuilder().build()
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
