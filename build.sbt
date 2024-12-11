ThisBuild / scalaVersion := "3.5.2"
ThisBuild / organization := "io.github.axelhj"
Compile / name := "Aoc24"
Compile / scalaSource := baseDirectory.value / "aoc" / "main"
Global / onChangedBuildSource := ReloadOnSourceChanges
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.0"
