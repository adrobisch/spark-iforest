val sparkV = "2.2.0"

lazy val commonSettings = Seq(
  organization := "com.drobisch",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.12"
)

lazy val iforest = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "spark-iforest",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkV % Provided,
      "org.apache.spark" %% "spark-mllib" % sparkV % Provided,
      "org.apache.spark" %% "spark-mllib" % sparkV % Test classifier "tests",
      "org.scalatest" %% "scalatest" % "3.0.0" % Test
    )
  )

lazy val example = (project in file("example"))
  .settings(commonSettings)
  .settings(
    name := "spark-iforest-example",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkV,
      "org.apache.spark" %% "spark-mllib" % sparkV
    )
  ).dependsOn(iforest)