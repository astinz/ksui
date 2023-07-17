group = "xyz.mcxross.ksui"

version = "1.2.5-beta"

plugins {
  kotlin("jvm") apply false
  id("com.android.library") apply false
  kotlin("multiplatform") apply false
  kotlin("plugin.serialization") apply false
  id("org.jetbrains.dokka") apply false
}

repositories {
  mavenCentral()
  google()
}
