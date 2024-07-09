package com.harana.sdk.shared.models.data

import com.harana.sdk.shared.models.data.connection_types._
import com.harana.sdk.shared.models.data.connection_types.next._

import scala.collection.immutable.SortedMap

object ConnectionTypes {

  val AzureKusto = new AzureKusto
  val AzureSqlDb = new AzureSqlDb
  val BigQuery = new BigQuery
  val Cassandra = new Cassandra
  val Ceph = new Ceph
  val Clickhouse = new Clickhouse
  val Cloudant = new Cloudant
  val Couchbase = new Couchbase
  val CouchDb = new CouchDb
  val Druid = new Druid
  val Elasticsearch = new Elasticsearch
  val Exasol = new Exasol
  val GoogleAnalytics = new GoogleAnalytics
  val GoogleSheets = new GoogleSheets
  val GoogleSpanner = new GoogleSpanner
  val Greenplum = new Greenplum
  val HaranaFiles = new HaranaFiles
  val Influx = new Influx
  val Kdb = new Kdb
  val Kinetica = new Kinetica
  val MariaDb = new MariaDb
  val Marketo = new Marketo
  val MemSql = new MemSql
  val MongoDb = new MongoDb
  val MySql = new MySql
  val Neo4j = new Neo4j
  val Netsuite = new Netsuite
  val Oracle = new Oracle
  val OrientDb = new OrientDb
  val PostgreSql = new PostgreSql
  val Redis = new Redis
  val Redshift = new Redshift
  val S3 = new S3
  val Salesforce = new Salesforce
  val Sftp = new Sftp
  val Snowflake = new Snowflake
  val SqlServer = new SqlServer
  val Workday = new Workday
  val Zuora = new Zuora

  private val connectionTypes = List(
    Cassandra,
    Elasticsearch,
    Exasol,
    MariaDb,
    MongoDb,
    MySql,
    Oracle,
    PostgreSql,
    Redshift,
    S3,
    Sftp,
    Snowflake,
    SqlServer,
  )


  private val connectionTypesByName = connectionTypes.map(at => name(at) -> at).toMap

  def list = SortedMap[String, ConnectionType]() ++ connectionTypesByName
  def get(name: String) = connectionTypesByName(name)
  def get(connectionType: ConnectionType) = connectionTypesByName(name(connectionType))
  def name(connectionType: ConnectionType) = connectionType.getClass.getSimpleName
  def getById(id: String) = connectionTypes.find(_.id == id).head
}