

enablePlugins(AndroidApp)
libraryDependencies ++= Seq(

  "com.android.support" % "appcompat-v7" % "25.3.1")

//libraryProject in Android := true


lazy val root = (project in file("."))
  .aggregate(cview)
  .dependsOn(cview)
  .settings(inThisBuild(List(

    platformTarget in Android := "android-25",
    scalaVersion := "2.11.8")))

lazy val cview = project