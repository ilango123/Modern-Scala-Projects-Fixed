package com.packt.modern.chapter4

import org.apache.spark.sql.SparkSession

trait SpamWrapper {

  val hamSetFileName = "inbox2.txt"

  val spamFileName ="junk2.txt"

  //The entry point to programming Spark with the Dataset and DataFrame API.
  //This is the SparkSession

  lazy val session: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("spam-classifier-pipeline")
      .getOrCreate()
  }

}























