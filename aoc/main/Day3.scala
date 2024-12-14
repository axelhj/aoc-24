package io.github.axelhj

import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

object Day3:
    def run() =
        println("Go!")
        println(produce(os.read(os.pwd/"aoc"/"training-data"/"day3.txt")))
        println(produce2(os.read(os.pwd/"aoc"/"training-data"/"day3.txt")))
        println(produce(os.read(os.pwd/"aoc"/"scored-data"/"day3.txt")))
        println(produce2(os.read(os.pwd/"aoc"/"scored-data"/"day3.txt")))
        println("Done!")

    def produce(content: String) =
        """mul\(([\d]{1,3}),([\d]{1,3})\)""".r.findAllMatchIn(content)
            .map((m: Regex.Match) => m.group(1).toInt * m.group(2).toInt)
            .sum

    def produce2(content: String) = {
        var on = true
        """(mul)\(([\d]{1,3}),([\d]{1,3})\)|(do\(\))|(don't\(\))""".r.findAllMatchIn(content)
            .map((m: Regex.Match) =>
                // println(m.group(0))
                // val c = m.group(1)
                if on && m.group(1) == "mul" then
                    println("ON")
                    m.group(2).toInt * m.group(3).toInt
                else if m.group(0) == "do()" then
                    println(m.group(0))
                    println("Set on")
                    on = true
                    0
                else if m.group(0) == "don't()" then
                    println(m.group(0))
                    println("Set off")
                    on = false
                    0
                else
                    println("OFF")
                    0
            )
            .sum
    }
