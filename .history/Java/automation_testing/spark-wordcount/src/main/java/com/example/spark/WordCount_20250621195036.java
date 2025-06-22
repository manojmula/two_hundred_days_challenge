package com.example.spark;

import org.apache.spark.api.java.*;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        // Strt Spark Session
        SparkSession = SparkSession.builder()
        .appName("Java Spark word count")
        .master("local[*]")
        .getOrCreate();

        JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());

        // Load data from text file
        JavaRDD<String> lines = sc.textFile("input.txt");

        // Word count logic
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        JavaPairRDD<String, Integer> pairs = words.mapToPair(word -> new Tuple2<>(word, 1));

        JavaPairRDD<String, Integer> counts = pairs.reduceByKey(Integer::sum);

        // Save ot print putput
        counts.forEach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));

        // Stop Spark
        spark.stop();
    }
}