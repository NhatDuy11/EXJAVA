ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "untitled2",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.8",
      libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.8"

)
