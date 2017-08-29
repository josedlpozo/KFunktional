package com.josedlpozo.functions

fun logger(level: String, message: String) = print("[$level] $message")

fun logger(level: String) : (String) -> Unit = { print("[$level] $it") }

fun operation(a: Int, b: Int, logger: (String) -> (Unit)) {
    if (a < 0) {
        logger("a must be greater than zero")
        return
    }

    if (b < 0) {
        logger("b must be greater than zero")
        return
    }

    logger((a + b).toString())
}

fun main(args: Array<String>) {
    operation(3, 10, logger("ERROR"))
}
