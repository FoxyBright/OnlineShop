import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.feature() = implementation(
    "io.coil-kt:coil-compose:2.2.2"
) and dependence() and compose() and pager()

fun DependencyHandlerScope.app() = base() and koin() and compose()

fun DependencyHandlerScope.data() = implementation(
    "androidx.preference:preference-ktx:1.2.0"
) and dependence() and ktor()

private fun DependencyHandlerScope.dependence() = base() and koin()

fun DependencyHandlerScope.base() = implementation(
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4",
    "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1",
    "androidx.appcompat:appcompat:1.6.1",
    "androidx.core:core-ktx:1.9.0",
    "androidx.browser:browser:1.5.0"
)

private const val composeUiVer = "1.4.0-alpha02"
fun DependencyHandlerScope.compose() = implementation(
    "androidx.compose.material3:material3:1.0.0-rc01",
    "androidx.navigation:navigation-compose:2.5.2",
    "androidx.activity:activity-compose:1.6.0",
    "io.coil-kt:coil-compose:2.2.2"
) and implementation(
    "androidx.compose.ui:ui-test-manifest:$composeUiVer",
    "androidx.compose.ui:ui-tooling-preview:$composeUiVer",
    "androidx.compose.ui:ui-tooling:$composeUiVer",
    "androidx.compose.ui:ui-util:$composeUiVer",
    "androidx.compose.ui:ui-graphics",
    "androidx.compose.ui:ui:1.0.5"
) and swipeRefresher()

private fun DependencyHandlerScope.swipeRefresher() = implementation(
    "com.google.accompanist:accompanist-swiperefresh:0.24.13-rc"
)

private const val ktorVer = "2.2.3"
private fun DependencyHandlerScope.ktor() = implementation(
    "io.ktor:ktor-client-content-negotiation:$ktorVer",
    "io.ktor:ktor-client-content-negotiation:$ktorVer",
    "io.ktor:ktor-serialization-jackson:$ktorVer",
    "io.insert-koin:koin-android:$koinVer",
    "io.ktor:ktor-client-logging:$ktorVer",
    "io.ktor:ktor-client-okhttp:$ktorVer",
    "io.insert-koin:koin-core:$koinVer",
    "io.ktor:ktor-client-core:$ktorVer",
    "io.ktor:ktor-client-core:$ktorVer",
    "io.ktor:ktor-client-cio:$ktorVer"
)

private const val koinVer = "3.3.3"
private fun DependencyHandlerScope.koin() = implementation(
    "io.insert-koin:koin-android:$koinVer",
    "io.insert-koin:koin-core:$koinVer"
)

private val pagerVer = "0.19.0"
private fun DependencyHandlerScope.pager() = implementation(
    "com.google.accompanist:accompanist-pager:$pagerVer",
    "com.google.accompanist:accompanist-pager-indicators:$pagerVer"
)

@Suppress("unused_parameter")
private infix fun Unit.and(o: Unit) {
}

private const val impl = "implementation"
private fun DependencyHandler.implementation(vararg dependencyNotations: Any) =
    dependencyNotations.forEach { add(impl, it) }