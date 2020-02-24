package projektor.attachment

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import io.ktor.server.testing.withTestApplication
import java.io.File
import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test
import projektor.ApplicationTestCase
import projektor.TestSuiteData
import projektor.incomingresults.randomPublicId
import projektor.server.api.TestRun
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ListAttachmentsApplicationTest : ApplicationTestCase() {
    @Test
    fun `should add attachments to test run then list them`() {
        val publicId = randomPublicId()
        assetStoreEnabled = true

        withTestApplication(::createTestApplication) {
            handleRequest(HttpMethod.Get, "/run/$publicId") {
                testRunDBGenerator.createTestRun(
                        publicId,
                        listOf(
                                TestSuiteData("testSuite1",
                                        listOf("testSuite1TestCase1", "testSuite1TestCase2"),
                                        listOf(),
                                        listOf()
                                )
                        )
                )
            }.apply {
                val responseRun = objectMapper.readValue(response.content, TestRun::class.java)
                assertNotNull(responseRun)

                expectThat(responseRun.id).isEqualTo(publicId.id)
            }

            handleRequest(HttpMethod.Post, "/run/$publicId/attachments/test-attachment.txt") {
                setBody(File("src/test/resources/test-attachment.txt").readBytes())
            }.apply {
                expectThat(response.status()).isEqualTo(HttpStatusCode.OK)
            }
            handleRequest(HttpMethod.Post, "/run/$publicId/attachments/test-run-summary.png") {
                setBody(File("src/test/resources/test-run-summary.png").readBytes())
            }.apply {
                expectThat(response.status()).isEqualTo(HttpStatusCode.OK)
            }

            handleRequest(HttpMethod.Get, "/run/$publicId/attachments") {
            }.apply {
                expectThat(response.status()).isEqualTo(HttpStatusCode.OK)

                val attachmentsResponse = objectMapper.readValue(response.content, GetAttachmentsResponse::class.java)
                assertNotNull(attachmentsResponse)
            }
        }
    }
}