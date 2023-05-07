package xyz.mcxross.ksui.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(CIO)

actual suspend fun <T> runBlocking(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
): T = kotlinx.coroutines.runBlocking(context, block)
