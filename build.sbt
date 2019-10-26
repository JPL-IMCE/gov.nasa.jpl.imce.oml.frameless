
import com.typesafe.sbt.packager.SettingsHelper
import sbt.Keys._
import sbt._
import gov.nasa.jpl.imce.sbt._
import gov.nasa.jpl.imce.sbt.ProjectHelper._

updateOptions := updateOptions.value.withCachedResolution(true)

import scala.io.Source
import scala.util.control.Exception._

import ProjectRefHelper._

lazy val core = Project("omlFrameless", file("."))
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

    scalacOptions in (Compile,doc) ++= Seq(
      "-diagrams",
      "-doc-title", name.value,
      "-doc-root-content", baseDirectory.value + "/rootdoc.txt"),

    autoAPIMappings := true,
    apiURL := Some(url("https://jpl-imce.github.io/gov.nasa.jpl.imce.oml.frameless/latest/api/")),

    resolvers += Resolver.mavenLocal,
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
