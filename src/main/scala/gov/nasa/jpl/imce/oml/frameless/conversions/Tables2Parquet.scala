/*
 * Copyright 2017 Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gov.nasa.jpl.imce.oml.frameless.conversions

import java.io.File
import java.lang.System

import ammonite.ops.Path
import gov.nasa.jpl.imce.oml.resolver.FileSystemUtilities
import gov.nasa.jpl.imce.oml.frameless.OMLSpecificationTypedDatasets
import gov.nasa.jpl.imce.oml.tables.OMLSpecificationTables
import gov.nasa.jpl.imce.oml.resolver.TableUtilities
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

    val omlZips: Seq[Path] = FileSystemUtilities.lsRecOMLJsonZipFiles(Path(catalogFile))

    val conf = new SparkConf()
      .setMaster("local")
      .setAppName(this.getClass.getSimpleName)

    implicit val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
    implicit val sqlContext = spark.sqlContext

    val omlTables: OMLSpecificationTables = TableUtilities.readOMLZipFiles(omlZips)
    OMLSpecificationTypedDatasets.parquetWriteOMLSpecificationTables(omlTables, dir) match {
      case Success(_) =>
        ()
      case Failure(t) =>
        throw t
    }
  }
}