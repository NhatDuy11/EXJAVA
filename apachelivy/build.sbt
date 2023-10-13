ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.10.5"

lazy val root = (project in file("."))
  .settings(
    name := "apachelivy"
  )
libraryDependencies += "commons-io" % "commons-io" % "2.11.0"
libraryDependencies += "org.apache.livy" % "livy-api" % "0.7.1-incubating"
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.3.2"
