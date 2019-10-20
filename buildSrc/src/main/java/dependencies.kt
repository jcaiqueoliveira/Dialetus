object Versions {

    const val kotlin = "1.3.50"
    const val androidGradleSupport = "3.5.1"
    const val gmsSupport = "4.3.2"

    const val okhttp4 = "4.2.1"
    const val retrofit2 = "2.6.2"
    const val ktxConverter = "0.4.0"
    const val ktxSerialization = "0.13.0"

    const val materialDesign = "1.1.0-alpha10"
    const val androidxAppCompat = "1.1.0"
    const val androidxActivity = "1.1.0-alpha03"
    const val androidxCardView = "1.0.0"
    const val androidxRecyclerView = "1.1.0-beta04"
    const val androidxGridLayout = "1.0.0"
    const val androidxConstraintLayout = "2.0.0-beta2"

    const val androidxLifecycle = "2.1.0"

    const val firebaseCrashlytics = "2.10.1"

    const val groupie = "2.3.0"

    const val jUnit4 = "4.12"

    const val assertJ29 = "2.9.1"
    const val espresso = "3.1.0"
    const val androidJUnit = "1.1.0"
    const val mockitoKT = "2.0.0-RC1"
    const val mockito = "2.19.0"

    const val kodeinDI = "6.0.1"
    const val slf4j = "1.7.25"
    const val fabric = "1.26.1"
    const val coroutine = "1.3.2"
}

object Dependencies {

    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.ktxSerialization}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp4}"
    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp4}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    val KtxConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.ktxConverter}"

    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    val androidxActivity = "androidx.activity:activity-ktx:${Versions.androidxActivity}"
    val androidxCardView = "androidx.cardview:cardview:${Versions.androidxCardView}"
    val androidxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidxRecyclerView}"
    val androidxGridLayout = "androidx.gridlayout:gridlayout:${Versions.androidxGridLayout}"
    val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
    val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    val androidxLifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.androidxLifecycle}"
    val androidxLifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
    val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"

    val androidTestCore = "androidx.test:core:${Versions.androidJUnit}"
    val androidTestCoreKtx = "androidx.test:core-ktx:${Versions.androidJUnit}"
    val androidTestExtJunit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    val androidTestExtJunitKtx = "androidx.test.ext:junit-ktx:${Versions.androidJUnit}"
    val androidTestRules = "androidx.test:rules:${Versions.androidJUnit}"
    val androidTestRunner = "androidx.test:runner:${Versions.androidJUnit}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"

    val jUnit = "junit:junit:${Versions.jUnit4}"
    val assertJ = "org.assertj:assertj-core:${Versions.assertJ29}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKT}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp4}"
    val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodeinDI}"
    val kodeinConf = "org.kodein.di:kodein-di-conf-jvm:${Versions.kodeinDI}"
    val kodeinAndroid = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodeinDI}"
    val slf4jNoOp = "org.slf4j:slf4j-nop:${Versions.slf4j}"
    val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"

    val groupie = "com.xwray:groupie:${Versions.groupie}"
    val groupieKTX = "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
}

object BuildPlugins {

    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradleSupport}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinxSerializiationPlugin =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    val gmsPlugin = "com.google.gms:google-services:${Versions.gmsSupport}"
    val firebaseCrashlytics = "io.fabric.tools:gradle:${Versions.fabric}"
}

object NetworkingDependencies {

    val main = listOf(
        Dependencies.okhttp,
        Dependencies.okhttpInterceptor,
        Dependencies.retrofit,
        Dependencies.KtxConverter,
        Dependencies.kodein
    )

    val testing = listOf(
        Dependencies.slf4jNoOp,
        Dependencies.mockWebServer
    )
}

object AndroidModule {

    val main = listOf(
        Dependencies.kotlinStdlib,
        Dependencies.kotlinReflect,
        Dependencies.androidxActivity,
        Dependencies.androidxAppCompat,
        Dependencies.androidxCardView,
        Dependencies.androidxGridLayout,
        Dependencies.androidxRecyclerView,
        Dependencies.androidxLifecycleCommon,
        Dependencies.androidxLifecycleCommonJava8,
        Dependencies.androidxLifecycleExtensions,
        Dependencies.groupie,
        Dependencies.groupieKTX,
        Dependencies.materialDesign,
        Dependencies.kodein,
        Dependencies.kodeinConf,
        Dependencies.kodeinAndroid,
        Dependencies.androidxLifecycleViewModel,
        Dependencies.androidxConstraintLayout
    )

    val unitTesting = listOf(
        Dependencies.slf4jNoOp,
        Dependencies.jUnit,
        Dependencies.assertJ,
        Dependencies.kotlinReflect,
        Dependencies.mockitoKotlin,
        Dependencies.slf4j,
        Dependencies.coroutinesTest
    )

    val androidTesting = listOf(
        Dependencies.slf4jNoOp,
        Dependencies.assertJ,
        Dependencies.kotlinReflect,
        Dependencies.mockitoKotlin,
        Dependencies.espressoCore,
        Dependencies.espressoIntents,
        Dependencies.androidTestCore,
        Dependencies.androidTestRules,
        Dependencies.androidTestRunner,
        Dependencies.androidTestCoreKtx,
        Dependencies.androidTestExtJunit,
        Dependencies.androidTestExtJunitKtx
    )
}

object StandaloneModule {

    val main = listOf(
        Dependencies.kotlinStdlib,
        Dependencies.kotlinReflect,
        Dependencies.kodein,
        Dependencies.kodeinConf
    )

    val unitTesting = listOf(
        Dependencies.jUnit,
        Dependencies.assertJ,
        Dependencies.slf4jNoOp,
        Dependencies.mockitoKotlin,
        Dependencies.kotlinReflect,
        Dependencies.mockitoInline,
        Dependencies.coroutinesTest
    )
}
