package io.github.grarak.fastoddeven

fun Int.isOdd(): Boolean =
    if (this == 1) true else if (this == 0) false else ((this - 1).toByte().toInt()).isEven()

fun Int.isEven(): Boolean =
    if (this == 0) true else if (this == 1) false else ((this - 1).toByte().toInt()).isOdd()
