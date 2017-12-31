
import com.typesafe.sbt.packager.SettingsHelper
import sbt.Keys._
import sbt._
import gov.nasa.jpl.imce.sbt._
import gov.nasa.jpl.imce.sbt.ProjectHelper._

updateOptions := updateOptions.value.withCachedResolution(true)

import scala.io.Source
import scala.util.control.Exception._

import ProjectRefHelper._

def tablesRule: PartialFunction[ModuleID, URL] = {
  case ModuleID("gov.nasa.jpl.imce", "gov-nasa-jpl-imce-oml-tables_2.11", _, _, _, _, _, _, _, _, _) =>
    url("https://jpl-imce.github.io/gov.nasa.jpl.imce.oml.tables/latest/api/index.html")
}

lazy val core = Project("omlFrameless", file("."))
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalDeployPlugin)
  .enablePlugins(IMCEGitPlugin)
  .settings(IMCEPlugin.strictScalacFatalWarningsSettings)
  .settings(
    IMCEKeys.licenseYearOrRange := "2017",
    IMCEKeys.organizationInfo := IMCEPlugin.Organizations.omf,

    buildInfoPackage := Settings.namespace,
    buildInfoKeys ++= Seq[BuildInfoKey](BuildInfoKey.action("buildDateUTC") { buildUTCDate.value }),

    projectID := {
      val previous = projectID.value
      previous.extra(
        "build.date.utc" -> IMCEKeys.buildUTCDate.value,
        "artifact.kind" -> "generic.library")
    },

    IMCEKeys.targetJDK := IMCEKeys.jdk18.value,
    git.baseVersion := Settings.version,
    // include all test artifacts
    publishArtifact in Test := true,

    scalaVersion := Settings.versions.scala,

    topLevelDirectory := Some("OMLFrameless"),

    // Generate scripts for each main application discovered.
    mainClass in Compile := None,

    // Needed to transitively get dependencies from the gov.nasa.jpl.imce:imce.third_party.* zip aggregates
    classpathTypes += "zip",
    classpathTypes += "linux.gtk.x86_64.tar.gz",

    SettingsHelper.makeDeploymentSettings(Universal, packageZipTarball in Universal, "tgz"),

    mappings in Universal := {
      val s = streams.value
      val prev = (mappings in Universal).value
      s.log.warn(s"universal:mappings => ${prev.size} entries...")
      var oks: Int = 0
      var exs: Int = 0
      val result = prev.filterNot { case (f, n) =>
        val ok = f.name.endsWith(".tar.gz") ||
          f.name.endsWith("-resource.zip") ||
          n.contains("test") ||
          (f.name.endsWith("log4j-1.2.17.zip") && n == "lib/log4j.log4j-1.2.17.jar") ||
          n == "lib/ch.qos.logback.logback-classic-1.0.7.jar" ||
          n == "lib/ch.qos.logback.logback-core-1.0.7.jar"
        if (ok) exs += 1 else oks += 1
        ok
      }
      s.log.warn(s"universal:mappings => ${prev.size} entries (kept $oks; removed $exs) => ${result.size} filtered")
      result
    },

    scalacOptions in (Compile,doc) ++= Seq(
      "-diagrams",
      "-doc-title", name.value,
      "-doc-root-content", baseDirectory.value + "/rootdoc.txt"),

    autoAPIMappings in (Compile,doc) := true,
    apiURL := Some(url("https://jpl-imce.github.io/gov.nasa.jpl.imce.oml.frameless/latest/api/index.html")),

    resolvers += Resolver.bintrayRepo("jpl-imce", "gov.nasa.jpl.imce"),

    resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
    scalacOptions in (Compile, compile) += s"-P:artima-supersafe:config-file:${baseDirectory.value}/project/supersafe.cfg",
    scalacOptions in (Test, compile) += s"-P:artima-supersafe:config-file:${baseDirectory.value}/project/supersafe.cfg",
    scalacOptions in (Compile, doc) += "-Xplugin-disable:artima-supersafe",
    scalacOptions in (Test, doc) += "-Xplugin-disable:artima-supersafe",

    libraryDependencies ++= List(
      // frameless-cats 0.4.0 has an outdated dependency on cats-core 1.0.0-MF.
      "org.typelevel" %% "frameless-cats"      % Settings.versions.framelessVersion exclude("org.typelevel", "cats-core_" + scalaBinaryVersion.value),
      "org.typelevel" %% "frameless-dataset"   % Settings.versions.framelessVersion,
      "org.typelevel" %% "frameless-ml"        % Settings.versions.framelessVersion
    ),

    libraryDependencies ++= Seq(
    
      "com.lihaoyi" %% "ammonite" % Settings.versions.ammonite cross CrossVersion.full,
      
      "org.typelevel" %% "cats-core" % Settings.versions.catsCoreVersion,
      "org.typelevel" %% "cats-effect" % Settings.versions.catsEffectVersion,
      "org.typelevel" %% "cats-mtl-core" % Settings.versions.catsMTLVersion,
      "io.circe" %% "circe-generic" % Settings.versions.circeVersion,
      "io.circe" %% "circe-literal" % Settings.versions.circeVersion,
      "io.circe" %% "circe-optics" % Settings.versions.circeVersion,
      "io.circe" %% "circe-parser" % Settings.versions.circeVersion
    ),
    dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-paranamer" % Settings.versions.spark_jackson % "compile",
    dependencyOverrides += "com.fasterxml.jackson.module" %% "jackson-module-scala" % Settings.versions.spark_jackson % "compile"
  )
  .dependsOnSourceProjectRefOrLibraryArtifacts(
    "oml-resolver",
    "gov.nasa.jpl.imce.oml.resolver",
    Some("compile;test->compile"),
    Seq(
      "gov.nasa.jpl.imce" %% "gov.nasa.jpl.imce.oml.resolver"
        % Settings.versions.oml_resolver
        % "compile" withSources(),

      "gov.nasa.jpl.imce" %% "gov.nasa.jpl.imce.oml.resolver"
        % Settings.versions.oml_resolver artifacts
        Artifact("gov.nasa.jpl.imce.oml.resolver", "zip", "zip", "resource")
    )
  )
