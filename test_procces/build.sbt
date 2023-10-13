ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "test_procces",
      libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.4.0",
      libraryDependencies += "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0"


  )
