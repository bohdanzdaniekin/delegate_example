package com.bohdanzdaniekin.delegate.ui.util.extensions

inline fun <T> Array<out T>.firstOrDefault(default: T, predicate: (T) -> Boolean): T {
    for (element in this) if (predicate(element)) return element
    return default
}