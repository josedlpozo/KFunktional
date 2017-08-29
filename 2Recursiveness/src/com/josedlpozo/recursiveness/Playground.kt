package com.josedlpozo.recursiveness

sealed class List<out A> {
    object Empty : List<Nothing>()
    class NonEmpty<out A>(val head: A, val tail: List<A>) : List<A>()
}

val cart: List<Int> = List.NonEmpty(40,
        List.NonEmpty(30,
                List.NonEmpty(20,
                        List.NonEmpty(10,
                                List.Empty))))

fun totalCost(cart: List<Int>) : Int = when(cart) {
    is List.Empty -> 0
    is List.NonEmpty<Int> ->  with(cart) { head + totalCost(tail) }
}

fun main(args: Array<String>) {
    print(totalCost(cart))
}