import org.gradle.api.JavaVersion
import org.gradle.api.JavaVersion.VERSION_1_8

object Config {
    
    private const val rules = "rules-pro"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val applicationId = "com.satriaadhipradana.onlineshop"
    const val applicationPrefix = "com.satriaadhipradana"
    const val proguardFile = "proguard-android-optimize.txt"
    const val proguard = "proguard-$rules"
    const val consume = "consumer-$rules"
    val kotlinCompilerExVer = "1.3.2"
    val kotlinCompilerVer = "1.5.30"
    const val jvmTarget = "1.8"
    
    val sourceCompatibility = VERSION_1_8
    
    const val compileSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val minSdk = 24
    
    const val targetSdk = compileSdk
}