import sbt._
import com.harana.sbt.common._

val sdk = haranaCrossProject("sdk").in(file("."))
  .settings(
    libraryDependencies ++=
      Library.circe.value ++
        Library.testing.value :+
        Library.izumiReflect.value :+
        Library.shapeless.value :+
        Library.squants.value
  )
  .jsSettings(
    libraryDependencies +=
      Library.scalajsDom.value
  )
  .jvmSettings(
    libraryDependencies ++=
      Library.googleServiceApi.value ++
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
      Library.javaMail.value :+
      Library.jodaTime.value :+
      Library.junixSocketCommon.value :+
      Library.nscalaTime.value :+
      Library.reflections.value :+
      Library.scalajsStubs.value :+
      Library.svmSubs.value,
    unmanagedBase := baseDirectory.value / "lib"
  )

val root = haranaRootProject(sdk)
