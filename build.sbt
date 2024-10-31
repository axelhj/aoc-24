ThisBuild / scalaVersion := "3.5.2"
ThisBuild / organization := "io.github.axelhj"

lazy val csd = project
  .in(file("csd/main"))
  .aggregate(model)
  .dependsOn(model)
  .settings(
    name := "Csd24",
    Compile / run := "io.github.axelhj.Main",
    Global / onChangedBuildSource := ReloadOnSourceChanges,
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "3.3.1",
      "org.scala-lang" %% "toolkit" % "0.6.0"
    )
  )

lazy val model = project
  .in(file("csd/model"))
  .settings(
    name := "Csd24Model",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "3.3.1",
      "org.scala-lang" %% "toolkit" % "0.6.0"
    )
  )
