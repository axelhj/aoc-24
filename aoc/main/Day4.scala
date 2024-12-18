package io.github.axelhj

import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

object Day4:
    case class Lookup(items: Array[Array[String]]):
        def apply(x: Int, y: Int) =
            println(items(x)(y).charAt(0))
            items(x)(y).charAt(0)

        def maxX() =
            items(0).size - 1

        def maxY() =
            items.size - 1

    class Matcher(val word: String, var position: Int = 0):
        def apply(letter: Char): Boolean =
            println("Matching " + word(position) + " " + letter)
            if letter == word(position) then
                position += 1
                if position + 1 == word.size then
                    position = 0
                    return true
                return false
            position = 0
            return false

    class Stepper(
        val items: Lookup,
        val matcher: Matcher,
        val stepX: Int,
        val stepY: Int,
        var x: Int,
        var y: Int,
        var matches: Int = 0
    ):
        def apply(): Boolean =
            if
                (x < 0 || x > items.maxX()) ||
                (y < 0 || y > items.maxY())
            then return false
            if matcher(items(x, y))
                then matches += 1
            x += stepX
            y += stepY
            true

    def run() =
        println("Go!")
        println(produce(os.read(os.pwd/"aoc"/"training-data"/"day4.txt")))
        // println(produce2(os.read(os.pwd/"aoc"/"training-data"/"day4.txt")))
        // println(produce(os.read(os.pwd/"aoc"/"scored-data"/"day4.txt")))
        // println(produce2(os.read(os.pwd/"aoc"/"scored-data"/"day4.txt")))
        println("Done!")

    def produce(content: String) =
        val lookup = Lookup(content.split("\r\n").map(_.split("")).transpose())

        val stepper = Stepper(
            lookup, 
            Matcher("XMAS"),
            1, 0,
            0, 0
        )
        while (stepper()) {}
        println(stepper.matches)


    def produce2(content: String) = {
        ""
    }
