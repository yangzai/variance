ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "variance"
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "kittens" % "3.0.0"
)
scalacOptions ++= Seq("-Ykind-projector:underscores")
