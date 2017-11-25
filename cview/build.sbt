enablePlugins(AndroidLib)

//android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

libraryDependencies ++=
  "com.android.support" % "appcompat-v7" % "25.3.1" ::
  Nil
