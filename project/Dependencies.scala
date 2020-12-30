import sbt._

object Version {
  val Log4j2Version = "2.11.1"
}

object Dependencies {
  object Logging {
    lazy val Slf4j               = "com.typesafe.akka" %% "akka-slf4j" % "2.5.29"
    lazy val Disruptor           = "com.lmax" % "disruptor" % "3.4.2" % "runtime"
    lazy val Logback             = "ch.qos.logback" % "logback-classic" % "1.2.3"
    lazy val LoggingDependencies = Seq(Logback, Slf4j, Disruptor)
  }
}
