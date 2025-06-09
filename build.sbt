import sbt._
import com.harana.sbt.common._

val sdk = haranaCrossProject("sdk").in(file("."))
  .settings(
    libraryDependencies ++=
      Library.circe.value ++
      Library.testing.value :+
      Library.izumiReflect.value :+
      Library.squants.value
  )
  .jsSettings()
  .jvmSettings(
    libraryDependencies ++=
      Library.logging.value ++
      Library.osgi.value ++
      Library.spark.value ++
      Library.testing.value :+

      Library.bouncycastle.value :+
      Library.commonsIo.value :+
      Library.commonsLang3.value :+
      Library.config.value :+
      Library.graalvm.value :+
      Library.gson.value :+
      Library.guice.value :+
      Library.jodaTime.value :+
      Library.junixSocketCommon.value :+
      Library.nscalaTime.value :+
      Library.reflections.value :+
      Library.scalajsStubs.value,
    unmanagedBase := baseDirectory.value / "lib"
  )

val root = haranaRootProject(sdk)
