package com.github.mikemedina.nexusuploader.inbound.html

import com.github.mikemedina.nexusuploader.UnitTest
import com.github.mikemedina.nexusuploader.inbound.html.HtmlGenerator.generateSuccessfulFileUploadMessageHtml
import com.github.mikemedina.nexusuploader.inbound.html.HtmlGenerator.generateUploadFormHtml
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@Category(UnitTest::class)
@RunWith(MockitoJUnitRunner::class)
class AnswerConverterUnitTest {

    @Test
    fun generateSuccessfulFileUploadMessageHtml_fileName_returnsExpectedHtml() {
        val fileName = "file-name"
        val actual = generateSuccessfulFileUploadMessageHtml(fileName)
        val expected =
            """
                <html>
                  <head>
                    <link rel="Stylesheet" type="text/css" href="style.css">
                  </head>
                  <body>
                    <style>p.file-name {
                    text-align: center;
                    font-size: 28px;
                }

                p.success-header {
                    color: green;
                    font-size: 60px;
                }</style>
                    <div class="form-wrapper">
                      <p class="success-header">Upload Successful</p>
                      <p class="file-name">$fileName</p>
                    </div>
                  </body>
                </html>

            """.trimIndent()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun generateUploadFormHtml_returnsExpectedHtml() {
        val actual = generateUploadFormHtml()
        val expected =
            """
                <html>
                  <head>
                    <link rel="Stylesheet" type="text/css" href="style.css">
                  </head>
                  <body>
                    <div class="form-wrapper">
                      <h1>Nexus Upload</h1>
                      <form action="https://53b9bf40.ngrok.io/upload" enctype="multipart/form-data" method="post"><input type="file" name="file"><br><br><input type="submit"></form>
                    </div>
                  </body>
                </html>

            """.trimIndent()
        assertThat(actual).isEqualTo(expected)
    }

}

