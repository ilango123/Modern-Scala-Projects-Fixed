package com.packt.modern.chapter3

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.RandomForestClassifier
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.functions

import org.apache.spark.rdd.RDD
import org.apache.spark.util.IntParam
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql._




object StockPricePipeline extends StockWrapper {

  val schema= StructType(Array(
    StructField("Date",        DateType,false),
    StructField("Open",        DoubleType,false),
    StructField("High",          DoubleType,true),
    StructField("low",            DoubleType,true),
    StructField("Close",             DoubleType,true),
    StructField("Adj_Close",             DoubleType,true),
    StructField("Volume",         DoubleType,true)
  ))

  def main(args: Array[String]): Unit = {

    //val cokeDF = parseRDD(session.sparkContext.textFile("coke.csv")).toDF.cache()

    /*
    Build a new Dataframe with the Coca Cola dataset
     */

    val cokeDF2 = buildStockFrame(dataSetPath + "Coke.csv")

    println("Coco Cola Dataframe is: " + cokeDF2.show())


    //val waltDF = parseRDD(session.sparkContext.textFile("WaltDisney.csv")).toDF.cache()

    /*
   Build a new Dataframe with the Walt Disney Historical Prices dataset
    */

    val waltDF2 = buildStockFrame(dataSetPath + "WaltDisney.csv")

    println("Walt Disney Dataframe is: " + waltDF2.show)


  }

}

