
import com.typesafe.sbt.packager.SettingsHelper
import sbt.Keys._
import sbt._
import gov.nasa.jpl.imce.sbt._
import gov.nasa.jpl.imce.sbt.ProjectHelper._

updateOptions := updateOptions.value.withCachedResolution(true)

import scala.io.Source
import scala.util.control.Exception._

import ProjectRefHelper._

lazy val core = Project("oml-frameless", file("."))
  .enablePlugins(IMCEGitPlugin)
  .settings(IMCEPlugin.strictScalacFatalWarningsSettings)
  .settings(
    IMCEKeys.licenseYearOrRange := "2016",
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

    // skip doc on stage
    mappings in (Compile, packageDoc) := Seq(),

    resolvers += Resolver.bintrayRepo("jpl-imce", "gov.nasa.jpl.imce"),

    resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
    scalacOptions in (Compile, compile) += s"-P:artima-supersafe:config-file:${baseDirectory.value}/project/supersafe.cfg",
    scalacOptions in (Test, compile) += s"-P:artima-supersafe:config-file:${baseDirectory.value}/project/supersafe.cfg",
    scalacOptions in (Compile, doc) += "-Xplugin-disable:artima-supersafe",
    scalacOptions in (Test, doc) += "-Xplugin-disable:artima-supersafe",

    libraryDependencies ++= Seq(
    
      "com.lihaoyi" %% "ammonite" % Settings.versions.ammonite cross CrossVersion.full,
      
      "org.typelevel" %% "cats-core" % Settings.versions.catsCoreVersion,
      "io.circe" %% "circe-generic" % Settings.versions.circeVersion,
      "io.circe" %% "circe-literal" % Settings.versions.circeVersion,
      "io.circe" %% "circe-optics" % Settings.versions.circeVersion,
      "io.circe" %% "circe-parser" % Settings.versions.circeVersion
    ),

    libraryDependencies ++= List(
      "org.typelevel" %% "frameless-cats"      % Settings.versions.framelessVersion,
      "org.typelevel" %% "frameless-dataset"   % Settings.versions.framelessVersion,
      "org.typelevel" %% "frameless-ml"        % Settings.versions.framelessVersion
    )
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
