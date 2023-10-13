ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.10.7"

lazy val root = (project in file("."))
  .settings(
    name := "test_livy"
  )
