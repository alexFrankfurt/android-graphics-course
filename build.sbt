import android.ProjectLayout.Gradle

enablePlugins(AndroidApp)
platformTarget := "android-22"
libraryDependencies ++= Seq(

  "com.android.support" % "appcompat-v7" % "22.2.1")

//libraryProject in Android := true
