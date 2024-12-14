package io.github.axelhj

import scala.collection.mutable.ArrayBuffer

object Day1:
    def run() =
        println("Go!")
        println(produce(os.read(os.pwd/"aoc"/"training-data"/"day1.txt")))
        println(produce(os.read(os.pwd/"aoc"/"scored-data"/"day1.txt")))
        println("Done!")

    def produce(content: String) =
        val lines = content.split("\\n").map(_.split("""\s+"""))
        val colA = ArrayBuffer[Int]()
        val colB = ArrayBuffer[Int]()
        for (line <- lines)
            colA += line(0).toInt
            colB += line(1).toInt
        colA.sorted.zip(colB.sorted).map(e => (e._1 - e._2).abs).sum
