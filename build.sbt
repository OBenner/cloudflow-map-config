
ThisBuild / scalaVersion := Settings.ScalaVersion.It
// ThisBuild /runLocalKafka :=Some("localhost:9092")

val appName = "cloudflow-map-config"
lazy val root = Project(id = appName, base = file("."))
  .settings(
    name := appName
  )
  .aggregate(
    pipeline,
    flink
  )
val ProjectName = "my-project"

lazy val pipeline = Project(id = ProjectName, base = file("flink-pipe"))
  .settings(name := ProjectName)
  .settings(runLocalKafka :=Some("localhost:9092"))
  .settings(
    Settings.commonSettings
  )
  .enablePlugins(CloudflowApplicationPlugin)
  .settings(
    blueprint := Some("blueprint.conf"),
    runLocalConfigFile := Some("flink-pipe/src/main/resources/local.conf"),
  )

lazy val flink = appModule("flink-module")
  .enablePlugins(CloudflowFlinkPlugin)
  .settings(
    libraryDependencies ++=
      Dependencies.Logging.LoggingDependencies
  )

def appModule(moduleID: String): Project = {
  Project(id = moduleID, base = file(moduleID))
    .settings(name := moduleID)
    .settings(
      Settings.commonSettings,
      libraryDependencies ++=
        Dependencies.Logging.LoggingDependencies
    )
}