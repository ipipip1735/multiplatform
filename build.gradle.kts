plugins {
    kotlin("multiplatform") version "1.5.20"
}

group = "mine"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {


    //自定义源码集（放置在最开始的地方）
//    sourceSets {
////        val jvmSis by creating {
////            dependencies {
////                implementation("org.apache.maven:maven-artifact:3.8.1")
////            }
////        }
//
////        val kik by creating {
////            dependencies {
////                implementation("org.apache.maven:maven-artifact:3.8.1")
////            }
////        }
////        println("${kik.hashCode()}|kik = ${kik}")
//    }

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
//            println("this is $this")
        }

        compilations {
            val main by compilations.getting {
                defaultSourceSet {
                    dependencies {
                        implementation("org.apache.maven:maven-artifact:3.8.1")
                    }
                }


//                println("~~~~~~~~~~~defaultSourceSet = ${defaultSourceSet}")
//                println("~~~~~~~~~~~defaultSourceSet.hashCode() = ${defaultSourceSet.hashCode()}")
//                println("~~~~~~~~~~~kotlinSourceSets = ${kotlinSourceSets}")
//                println("~~~~~~~~~~~allKotlinSourceSets = ${allKotlinSourceSets}")
            }


            val sis by compilations.creating {
                println("~~~~~~~~~~~defaultSourceSet = ${defaultSourceSet}")
                println("~~~~~~~~~~~kotlinSourceSets = ${kotlinSourceSets}")
                println("~~~~~~~~~~~allKotlinSourceSets = ${allKotlinSourceSets}")

                sourceSets.forEach {
                    println("${it.hashCode()}|it is $it")
                }

                compileDependencyFiles.files.forEach { println("compileDependencyFiles.files|it = ${it}") }
                output.allOutputs.files.forEach { println("output.allOutputs.files|it = ${it}") }
                output.classesDirs.files.forEach { println("output.classesDirs.files|it = ${it}") }

//                kotlinSourceSets.add(sourceSets["kik"])

                println("~~~~~~~~~~~defaultSourceSet = ${defaultSourceSet}")
                println("~~~~~~~~~~~kotlinSourceSets = ${kotlinSourceSets}")
                println("~~~~~~~~~~~allKotlinSourceSets = ${allKotlinSourceSets}")
            }

        }

        testRuns["test"].executionTask.configure {
            useJUnit()
        }
//        withJava()
    }
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    //自定义属性
//    jvm("junit") {
//        attributes.attribute(testFrameworkAttribute, "junit")
//    }

    //遍历所有目标
//    targets.all{
//        println("this is $this")
//    }

    //给目标增加属性
//    val testFrameworkAttribute = Attribute.of("com.example.testFramework", String::class.java)
//    jvm("junit") {
//        attributes.attribute(testFrameworkAttribute, "junit")
//    }


    //配置目标
//    targets["jvm"].compilations.all{
//        kotlinOptions {
////            sourceMap = true
////            metaInfo = true
//        }
//    }


    //配置默认源码集
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }


    //配置依赖
//    dependencies {
//        "jvmSisImplementation"("org.apache.maven:maven-artifact:3.8.1")
//    }


    //自定义源码集
//    sourceSets {
//        val jvmSis by getting {
//            dependencies {
//                implementation("org.apache.maven:maven-artifact:3.8.1")
//            }
//        }
//        val mim by creating {
//            dependencies {
//                implementation("org.apache.maven:maven-artifact:3.8.1")
//            }
//        }
//
//        val jvmMain by getting {
//            dependencies {
//                implementation("org.apache.maven:maven-artifact:3.8.1")
//                dependsOn(mim)
//            }
//        }
//    }

}
