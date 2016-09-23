import com.typesafe.sbt.packager.archetypes.JavaServerAppPackaging

organization := "com.iservport"

lazy val root = (project in file("."))
  .enablePlugins(JavaServerAppPackaging, UniversalDeployPlugin)
  .settings(
    name := "iservport-google-chart",
    version := "1.0.1.RELEASE",
    libraryDependencies ++= Seq(
      "org.scala-lang"             % "scala-library"    % "2.11.8",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.3",
      "org.webjars.bower"          % "angular-google-chart"         % "0.1.0",
      "org.scalatest"             %% "scalatest"        % "3.0.0"   % "test",
      "org.mockito"                % "mockito-all"      % "1.10.19" % "test"
    )
  )
  .settings(commonSettings)

scalaVersion := "2.11.8"

sbtVersion := "0.13.9"

lazy val commonSettings = Seq(
  resolvers in ThisBuild ++= Seq(
    "Helianto Releases"  at "s3://maven.helianto.org/release",
    "Helianto Snapshots" at "s3://maven.helianto.org/snapshot",
    "Helianto Development" at "s3://maven.helianto.org/devel"
  ),
  publishTo in ThisBuild := {
    val helianto = "s3://maven.helianto.org/"
    if (version.value.trim.endsWith("SNAPSHOT"))
      Some("Helianto Snapshots" at helianto + "snapshot")
    else if (version.value.trim.endsWith("RELEASE"))
      Some("Helianto Snapshots" at helianto + "release")
    else
      Some("Helianto Development"  at helianto + "devel")
  },
  credentials += Credentials(Path.userHome / ".sbt" / ".s3credentials"),
  publishMavenStyle := true
)

licenses in ThisBuild := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
