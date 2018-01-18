import sbt._
import Keys._

object Settings {

  val name = "gov.nasa.jpl.imce.omf.frameless"

  val namespace = "gov.nasa.jpl.imce.omf.frameless"

  val organization = "gov.nasa.jpl.imce"

  val version = "0.12.0"

  object versions {
    val scala = "2.11.11"
    val oml_resolver = "0.91.1"
    val ammonite = "1.0.3"
    val circeVersion = "0.9.0-M2"
    val catsCoreVersion = "1.0.0-RC1"
    val catsEffectVersion = "0.5"
    val catsMTLVersion = "0.1.0"
    val framelessVersion = "0.4.0"

    // spark requirements
    val spark_jackson="2.8.10"
  }
}