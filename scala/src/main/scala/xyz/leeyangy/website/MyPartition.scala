package xyz.leeyangy.website

import breeze.numerics.log
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.Partitioner
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author liyangyang
 * @Date: 2023/04/21 23:14
 * @Package xyz.leeyangy.demo
 * @Version 1.0
 * @Description:
 *
 *
 *
 * 真坑啊，文件居然是从hdfs中读取的
 * spark-submit --master spark://master:7077 --executor-memory 512M --executor-cores 1 --class  xyz.leeyangy.website.ToDistribute scala-1.0.jar /input/word.txt work/out
 *
 * 输入输出文件写死
 * spark-submit --master spark://master:7077 --executor-memory 512M --executor-cores 1 --class  xyz.leeyangy.website.ToDistribute scala-1.0.jar
 *
 *
 */
class MyPartition(numParts: Int) extends Partitioner {

  override def numPartitions: Int = numParts

  override def getPartition(key: Any): Int = {
    if (key.toString().toInt % 2 == 0) {
      0
    } else {
      1
    }
  }

  override def equals(other: Any): Boolean = other match {
    case mypartition: MyPartition => mypartition.numPartitions == numPartitions
    case _ => false
  }
}

object ToDistribute {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test partition").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    //    raceData.csv
    //    val input = args(0)
    //    val output = args(1)
    //    val input = "hdfs://master:8020/user/hadoop/spark_input/raceData.csv"
    //    val output = "hdfs://master:8020/user/hadoop/spark_output/raceData.txt"
    val data = sc.textFile(args(0)).map {
      x => val y = x.split(","); (y(0), y(1))
    }

    // TODO
    /**
     *     删除hdfs文件
     *     hdfs配置
     */
    val path = new Path(args(1))
    val output = new org.apache.hadoop.fs.Path(args(1))
    val hdfs = org.apache.hadoop.fs.FileSystem.get(java.net.URI.create("hdfs://master:8020"),sc.hadoopConfiguration)
    // TODO 这里要改  预期结果是 "hdfs://master:8020/user/hadoop/spark_output/result.log"
    // TODO 实际结果是                             /user/hadoop/spark_output/result.log
    if (hdfs.exists(path)) hdfs.delete(path, true)
    val data2 = data.partitionBy(new MyPartition(2))
    data2.repartition(1).saveAsTextFile(args(1))
  }
}
