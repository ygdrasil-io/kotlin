/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package kotlinx.cinterop

public expect class NativePtr {

    companion object {
        val NULL: NativePtr
    }

    public operator fun plus(offset: Long): NativePtr
}



public expect class NonNullNativePtr {
    @Suppress("NOTHING_TO_INLINE")
    inline fun toNativePtr(): NativePtr
}


// Reinterprets this value from T to R having the same binary representation (e.g. to unwrap inline class).
@PublishedApi expect internal fun <T, R> T.reinterpret(): R

/**
 * Performs type cast of the native pointer to given interop type, including null values.
 *
 * @param T must not be abstract
 */
@ExperimentalForeignApi
public expect fun <T : NativePointed> interpretNullablePointed(ptr: NativePtr): T?
