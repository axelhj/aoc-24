ThisBuild / scalaVersion := "3.5.2"
ThisBuild / organization := "io.github.axelhj"
ThisBuild / name := "Aoc24"
Compile / scalaSource := baseDirectory.value / "aoc" / "main"
Global / onChangedBuildSource := ReloadOnSourceChanges
