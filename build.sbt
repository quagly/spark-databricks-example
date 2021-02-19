name := "spark-databricks-example"

version := "0.1"

scalaVersion := "2.12.10"

organization := "com.zignallabs"

idePackagePrefix := Some("com.zignallabs.sparkdatabricks")

parallelExecution in Test := false

libraryDependencies ++= Seq(
  // spark 3 drop supports only scala 2.12 so no need to specify scala version
  "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided",
  "com.holdenkarau" %% "spark-testing-base" % "3.0.1_1.0.0" % "test"
)


