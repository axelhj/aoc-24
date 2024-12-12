package io.github.axelhj

import scala.collection.mutable.ArrayBuffer

object Day2:
    def run() =
        println("Go!")
        println(produce(os.read(os.pwd/"aoc"/"training-data"/"day2.txt")))
        println(produce(os.read(os.pwd/"aoc"/"scored-data"/"day2.txt")))
        println("Done!")

    def produce(content: String) =
        content.split("\\n").map(_.split("""\s""").map(_.toInt))
            .map(line => {
                var res = Iterator[Array[Int]]()
                if line(0) < line(1) then
                    res = ((line.head - 1) +: line).sliding(2,1)
                        .takeWhile((a) => {
                            a(0) < a(1) &&
                            a(1) - a(0) < 4 &&
                            a(1) - a(0) > 0
                        })
                else
                    res = ((line.head + 1) +: line).sliding(2,1)
                        .takeWhile((a) => {
                            a(0) > a(1) &&
                            a(0) - a(1) < 4 &&
                            a(0) - a(1) > 0
                        })
                res.size == line.size
            }).filter((a: Boolean) => a).size
