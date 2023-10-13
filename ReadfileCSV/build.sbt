ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "ReadfileCSV",
    libraryDependencies += "com.databricks" %% "spark-csv" % "1.5.0"
  )
