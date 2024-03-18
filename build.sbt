Compile / run / fork := true

val scala3Version = "3.4.0"

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4" withSources() withJavadoc()

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "cats-example",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )

javaOptions ++= Seq(
   "-Dcats.effect.tracing.mode=full",
   "-Dcats.effect.tracing.buffer.size=1024"
)