package projektor.plugin

import okhttp3.OkHttpClient
import org.gradle.api.file.FileTree
import org.gradle.api.internal.AbstractTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import projektor.plugin.attachments.AttachmentsClient
import projektor.plugin.attachments.AttachmentsPublisher
import projektor.plugin.results.ResultsClient
import projektor.plugin.client.ClientConfig
import projektor.plugin.results.ResultsLogger
import projektor.plugin.results.grouped.GroupedResults

class ProjektorManualPublishTask extends AbstractTask {

    @Input
    String serverUrl

    @Input
    @Optional
    String publishToken

    @Input
    @Optional
    List<String> additionalResultsDirs = []

    @InputFiles
    @Optional
    List<FileTree> attachments = []

    @TaskAction
    void publish() {
        File projectDir = project.projectDir
        ProjectTestResultsCollector projectTestTaskResultsCollector = ProjectTestResultsCollector.fromAllTasks(
                project.getAllTasks(false).get(project),
                projectDir,
                additionalResultsDirs,
                logger
        )

        if (projectTestTaskResultsCollector.hasTestGroups()) {
            OkHttpClient okHttpClient = new OkHttpClient()
            ClientConfig clientConfig = new ClientConfig(serverUrl, java.util.Optional.ofNullable(publishToken))
            GroupedResults groupedResults = projectTestTaskResultsCollector.createGroupedResults()

            ResultsClient resultsClient = new ResultsClient(
                    okHttpClient,
                    clientConfig,
                    logger
            )
            PublishResult publishResult = resultsClient.sendResultsToServer(groupedResults)

            new ResultsLogger(logger).logReportResults(publishResult)

            if (attachments) {
                AttachmentsClient attachmentsClient = new AttachmentsClient(okHttpClient, clientConfig, logger)
                new AttachmentsPublisher(attachmentsClient, logger).publishAttachments(publishResult.publicId, attachments)
            }
        } else {
            logger.info("No test tasks found in project ${project.name}")
        }
    }
}
