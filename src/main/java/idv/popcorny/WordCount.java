package idv.popcorny;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Tuple2<String, Integer>> result = sc.textFile("input.txt")
                .flatMap(line -> Arrays.asList(line.split(" ")))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b)
                .collect();


        result.forEach((tuple) -> System.out.printf("%s -> %d\n", tuple._1(), tuple._2()));
    }
}
