package gov.nasa.jpl.imce.oml.frameless.conversions

import java.io.File
import java.lang.System

import ammonite.ops.Path
import gov.nasa.jpl.imce.oml.filesystem.lsRecOMLJsonZipFiles
import gov.nasa.jpl.imce.oml.frameless.OMLSpecificationTypedDatasets
import gov.nasa.jpl.imce.oml.tables.OMLSpecificationTables
import gov.nasa.jpl.imce.oml.tables.reader.readOMLZipFiles
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

import scala.collection.immutable.Seq
import scala.util.{Failure, Success}
import scala.{Array, StringContext, Unit}
import scala.Predef.String

object Tables2Parquet {

  def usage(): Unit = {
    System.err.println(s"Usage: <program> <oml.catalog.xml file> <dir>")
    System.exit(-1)
  }

  def main(args: Array[String]): Unit = {

    if (args.length != 2)
      usage()

    val catalogFile = new File(args(0))
    if (!catalogFile.exists() || !catalogFile.canRead)
      usage()

    val dir: Path = Path.expandUser(args(1))

    val omlZips: Seq[Path] = lsRecOMLJsonZipFiles(Path(catalogFile))

    val conf = new SparkConf()
      .setMaster("local")
      .setAppName(this.getClass.getSimpleName)

    implicit val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
    implicit val sqlContext = spark.sqlContext

    val omlTables: OMLSpecificationTables = readOMLZipFiles(omlZips)
    OMLSpecificationTypedDatasets.parquetWriteOMLSpecificationTables(omlTables, dir) match {
      case Success(_) =>
        ()
      case Failure(t) =>
        throw t
    }
  }
}
