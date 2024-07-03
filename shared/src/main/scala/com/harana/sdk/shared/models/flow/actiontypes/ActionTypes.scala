package com.harana.sdk.shared.models.flow.actiontypes

import com.harana.sdk.shared.models.flow.ActionTypeInfo
import com.harana.sdk.shared.models.flow.actiontypes.input._
import com.harana.sdk.shared.models.flow.actiontypes.output._
import com.harana.sdk.shared.models.flow.actiontypes.query._
import com.harana.sdk.shared.models.flow.actiontypes.transform._

import scala.collection.immutable.SortedMap

object ActionTypes {

  private val actionTypes = List(
//    new GetAzureKustoInfo,
//    new GetAzureSqlDbInfo,
//    new GetBigQueryInfo,
    new GetCassandraInfo,
//    new GetCephInfo,
//    new GetClickhouseInfo,
//    new GetCloudantInfo,
//    new GetCouchbaseInfo,
//    new GetCouchDbInfo,
//    new GetDruidInfo,
//    new GetElasticsearchInfo,
//    new GetExasolInfo,
//    new GetGoogleAnalyticsInfo,
//    new GetGoogleSheetsInfo,
//    new GetGoogleSpannerInfo,
//    new GetGreenplumInfo,
    new GetHaranaFilesInfo,
//    new GetInfluxInfo,
//    new GetKdbInfo,
//    new GetKineticaInfo,
    new GetMariaDbInfo,
//    new GetMarketoInfo,
//    new GetMemSqlInfo,
    new GetMongoDbInfo,
    new GetMySqlInfo,
//    new GetNeo4jInfo,
//    new GetNetsuiteInfo,
    new GetOracleInfo,
//    new GetOrientDbInfo,
    new GetPostgreSqlInfo,
//    new GetRedisInfo,
    new GetRedshiftInfo,
    new GetS3Info,
//    new GetSalesforceInfo,
    new GetSftpInfo,
    new GetSnowflakeInfo,
    new GetSqlServerInfo,
//    new GetWorkdayInfo,
//    new GetZuoraInfo,
//    new PutAzureKustoInfo,
//    new PutAzureSqlDbInfo,
//    new PutBigQueryInfo,
    new PutCassandraInfo,
//    new PutCephInfo,
//    new PutClickhouseInfo,
//    new PutCloudantInfo,
//    new PutCouchbaseInfo,
//    new PutCouchDbInfo,
//    new PutDruidInfo,
//    new PutElasticsearchInfo,
//    new PutExasolInfo,
//    new PutGoogleAnalyticsInfo,
//    new PutGoogleSheetsInfo,
//    new PutGoogleSpannerInfo,
//    new PutGreenplumInfo,
    new PutHaranaFilesInfo,
//    new PutInfluxInfo,
//    new PutKdbInfo,
//    new PutKineticaInfo,
    new PutMariaDbInfo,
//    new PutMemSqlInfo,
    new PutMongoDbInfo,
    new PutMySqlInfo,
//    new PutNeo4jInfo,
//    new PutNetsuiteInfo,
    new PutOracleInfo,
//    new PutOrientDbInfo,
//    new PutPostgreSqlInfo,
//    new PutRedisInfo,
    new PutRedshiftInfo,
    new PutS3Info,
//    new PutSalesforceInfo,
    new PutSftpInfo,
    new PutSnowflakeInfo,
    new PutSqlServerInfo,
    new ExecuteSQLInfo,
    new AddColumnInfo,
    new DistinctInfo,
    new DropColumnsInfo,
    new FilterInfo,
    new ForkInfo,
    new JoinInfo,
    new MergeInfo,
    new RenameColumnInfo,
    new SelectColumnsInfo,
    new SubtractInfo,
    new TransposeInfo
  )

  private val actionTypesByName = actionTypes.map(at => name(at) -> at).toMap
  
  def list = SortedMap[String, ActionTypeInfo]() ++ actionTypesByName
  def get(name: String) = actionTypesByName(name)
  def get(actionTypeInfo: ActionTypeInfo) = actionTypesByName(name(actionTypeInfo))

  def name(actionTypeInfo: ActionTypeInfo) = {
    val cls = actionTypeInfo.getClass.getSimpleName
    cls.substring(0, cls.length - 4)
  }
}