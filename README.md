# Introduction

This is a very very simple spark application. In this application, we show how to use [gradle shadowjar plugin](http://imperceptiblethoughts.com/shadow/) to create a shadow(uber) jar and then submit it to the spark cluster.

## How to Use

1. Build the Shardow Jar (Uber Jar)

    ```bash
    ./gradlew shadowJar
    ```
    
2. Submit the jar

    ```bash
    $SPARK_HOME/bin/spark-submit --master=<spark-master> build/libs/spark-wordcount-all.jar
    ```

Good luck and happy Sparking!!!
