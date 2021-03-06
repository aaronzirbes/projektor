package projektor.plugin.testkit.kotlin

import com.github.tomakehurst.wiremock.verification.LoggedRequest
import org.gradle.testkit.runner.GradleRunner
import projektor.plugin.testkit.ProjectSpec

import static org.gradle.testkit.runner.TaskOutcome.FAILED

class KotlinDslSpec extends ProjectSpec {
    File buildFile

    def setup() {
        buildFile = projectRootDir.newFile('build.gradle.kts')
        buildFile << """
            buildscript {
                repositories {
                    jcenter()
                }
            }

            plugins {
                id("groovy")
                id("dev.projektor.publish")
            }
            
            repositories {
                jcenter()
            }
            
            dependencies {
                "testImplementation"("org.spockframework:spock-core:1.3-groovy-2.5")
            }
            
             configure<projektor.plugin.ProjektorPublishPluginExtension> {
                serverUrl = "${serverUrl}"
            }
        """.stripIndent()
    }

    def "should publish results from test task to server"() {
        given:
        File testDirectory = specWriter.createTestDirectory(projectRootDir)
        specWriter.writeFailingSpecFile(testDirectory, "SampleSpec")

        String resultsId = "ABC123"
        resultsStubber.stubResultsPostSuccess(resultsId)

        when:
        def result = GradleRunner.create()
                .withProjectDir(projectRootDir.root)
                .withArguments('test')
                .withPluginClasspath()
                .buildAndFail()

        then:
        result.task(":test").outcome == FAILED

        and:
        !result.output.contains("Projektor plugin enabled but no server specified")
        result.output.contains("View Projektor report at: ${serverUrl}/tests/${resultsId}")

        and:
        List<LoggedRequest> resultsRequests = resultsStubber.findResultsRequests()
        resultsRequests.size() == 1
    }
}
