package com.github.mikemedina.nexusuploader.inbound.html

import kotlinx.html.*
import kotlinx.html.stream.createHTML

object HtmlGenerator {

    val FORM_SUBMIT_URL = "https://53b9bf40.ngrok.io/upload"

    fun generateSuccessfulFileUploadMessageHtml(fileName: String) =
        createHTML(prettyPrint = true).html {
            head {
                styleLink(url = "style.css")
            }
            body {
                style(content =
                """
                   p.file-name {
                       text-align: center;
                       font-size: 28px;
                   }

                   p.success-header {
                       color: green;
                       font-size: 60px;
                   }
                """.trimIndent())

                div(classes = "form-wrapper") {
                    p(classes = "success-header") { +"Upload Successful" }
                    p(classes = "file-name") { +fileName }
                }
            }
        }

    fun generateUploadFormHtml() =
         createHTML(prettyPrint = true).html {
            head {
                styleLink(url = "style.css")
            }
            body {
                div(classes = "form-wrapper") {
                    h1 { +"Nexus Upload" }
                    postForm(action = FORM_SUBMIT_URL, encType = FormEncType.multipartFormData) {
                        input(type = InputType.file, name = "file")
                        br; br
                        input(type = InputType.submit)
                    }
                }
            }
        }

}