package com.github.mikemedina.nexusuploader.inbound.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class NexusUploadDto(
        @JsonProperty("server")
        val server: String,
        @JsonProperty("url")
        val url: String,
        @JsonProperty("repo")
        val repo: String,
        @JsonProperty("user")
        val user: String,
        @JsonProperty("group")
        val group: String,
        @JsonProperty("artifact")
        val artifact: String,
        @JsonProperty("version")
        val version: String,
        @JsonProperty("fileName")
        val fileName: String)
