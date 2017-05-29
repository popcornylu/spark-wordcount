package idv.popcornylu.spark;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf();
        JavaSparkContext sc = new JavaSparkContext(conf);

        List<String> lines = Arrays.asList(
                "Hello World",
                "Second line",
                "Third line");

        List<Tuple2<String, Integer>> result = sc.parallelize(lines)
        .map(line -> StringUtils.upperCase(line))
        .flatMap(line -> Arrays.asList(line.split(" ")).iterator())
        .mapToPair(word -> new Tuple2<>(word, 1))
        .reduceByKey((l, r) -> l + r)
        .collect();

        result.forEach(System.out::println);
    }
}
