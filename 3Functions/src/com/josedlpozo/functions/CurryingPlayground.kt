package com.josedlpozo.functions

class Connector {
    fun connect(host: String = "localhost", port: Int = 80) { println("Connecting to $host:$port")}
}

fun connect(host: String): (Int) -> (() -> Unit) = { port -> { Connector().connect(host, port) } }

fun connect(host: String, port: Int): (() -> Unit) = { Connector().connect(host, port) }

fun main(args: Array<String>) {
    val hostConnection = connect("https://josedlpozo.com")
    hostConnection(8080)()
    hostConnection(8888)()

    connect("https://github.com", 9000)()
}