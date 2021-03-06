# Projektor Gradle plugin

This Gradle plugin supports automatically gathering and publishing
the XML test results to the Projektor server. It listens to the 
end of the build, gathers up all the XML results generated by
`Test` tasks in the build, then sends those to the Projektor server.

Example Projektor report from the plugin's build: https://projektorlive.herokuapp.com/tests/U6RAQSZHFAME

## Use plugin

To apply this plugin to your project:

```
plugins {
  id "dev.projektor.publish" version "3.0.0"
}
```

See https://plugins.gradle.org/plugin/dev.projektor.publish for the latest version.

By default the plugin publishes results from all `Test` tasks in the project
when the build finishes.

The plugin also adds a `publishResults` task that lets you publish test
results from a build after it has executed (for example, if you didn't have auto-publish on)
This can be a good way to easily share a specific test failure with colleagues.

`./gradlew publishResults`

Note: If you have a multi-project build, please apply the plugin to the root project.

## Compatibility

| Plugin version | Server version | Java version |
| -------------- | -------------- | ------------ |
| 1.0.0 - 1.0.2  | 1.0.0+         | 8+           |
| 1.0.3+         | 1.0.6+         | 8+           |
| 2.0.0          | 2.0.0+         | 8+           |
| 3.0.0          | 2.0.0+         | 8+           |
| 4.0.0          | 2.0.0+         | 11+          |

## Configuration

All the configuration of the plugin is inside the `projektor` block. 
To use the plugin, first set the URL of the Projektor server:

```
projektor {
  serverUrl = "https://myserver"
}
```

If you want to disable the auto-publish of results at the end of the build:

```
projektor {
  serverUrl = "https://myserver"
  autoPublish = false
}
```

Or if you want to only publish results when the build fails,
set the `autoPublishOnFailureOnly` configuration value:

```
projektor {
  serverUrl = "https://myserver"
  autoPublishOnFailureOnly = true
}
```

There is also the option to not add the `publishResults` task: 

```
projektor {
  serverUrl = "https://myserver"
  publishTaskEnabled = false
```

You can also include results from arbitrary directories in your build with the `additionalResultsDirs` configuration option:

```
projektor {
  serverUrl = "https://myserver"
  additionalResultsDirs = ['build/testResultsDir']
```

### All configuration options

| Parameter                 | Type             | Default | Description                                |
| ------------------------- | ---------------- | ------- | ------------------------------------------ |
| serverUrl*                | `String`         | null    | Projektor server URL to publish results to |
| autoPublish               | `boolean`        | true    | Whether results are automatically published at the end of the build |
| autoPublishOnFailureOnly  | `boolean`        | true    | Whether results on automatically published at the end of the build only on failures |
| publishTaskEnabled        | `boolean`        | true    | Whether the `publishResults` task is added to support easily manually publishing results by running a task |
| publishToken              | `String`         | null    | Token to include in publish request to server (only needed when server has publish token set) |
| additionalResultsDirs     | `List<String>`   | []      | Additional directories to include results from. Useful when you want to include results from a task that isn't `Test` type |
| attachments               | `List<FileTree>` | []      | FileTrees to include as attachments to the test report and make available in the UI |

* _Required_
