package com.github.mikemedina.nexusuploader.inbound.controllers

import com.github.mikemedina.nexusuploader.inbound.dtos.NexusUploadDto
import com.github.mikemedina.nexusuploader.inbound.html.HtmlGenerator.generateSuccessfulFileUploadMessageHtml
import com.github.mikemedina.nexusuploader.inbound.html.HtmlGenerator.generateUploadFormHtml
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.client.RestTemplate
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths

@Controller
class CodeController(val restTemplate: RestTemplate) {

    val UPLOAD_FOLDER = System.getenv()["USERPROFILE"] + "/Desktop/"

    @PostMapping(value = "upload")
    fun postFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        val bytes = file.bytes
        val path = Paths.get(UPLOAD_FOLDER + file.originalFilename)
        Files.write(path, bytes)

        return ResponseEntity(generateSuccessfulFileUploadMessageHtml(file.originalFilename), HttpStatus.CREATED)
    }

    @PutMapping(value = "upload-to-nexus")
    fun putFile(@RequestParam("file") file: MultipartFile) {
        // TODO: This entire method is broken
        val server = "TODO"
        val dto = NexusUploadDto(
                server = server,
                url = "$server/repository",
                repo = "TODO",
                user = "publish:publish",
                group = "group",
                artifact = "artifact",
                version = "version",
                fileName = "fileName")

        restTemplate.put(dto.url, file)
    }

    @GetMapping(value = "form")
    fun getForm() = ResponseEntity(generateUploadFormHtml(), HttpStatus.OK)

}
