/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package kotlinx.cinterop

actual class NativePtr {
    actual companion object {
        actual val NULL: NativePtr
            get() = TODO("Not yet implemented")
    }

    public operator fun plus(offset: Long): NativePtr = TODO("Not yet implemented")
}

actual class NonNullNativePtr {
    @Suppress(names = ["NOTHING_TO_INLINE"])
    actual inline fun toNativePtr(): NativePtr {
        TODO("Not yet implemented")
    }
}

// Reinterprets this value from T to R having the same binary representation (e.g. to unwrap inline class).
@PublishedApi actual internal fun <T, R> T.reinterpret(): R = this as R

/**
 * Performs type cast of the native pointer to given interop type, including null values.
 *
 * @param T must not be abstract
 */
@ExperimentalForeignApi
actual fun <T : NativePointed> interpretNullablePointed(ptr: NativePtr): T? {
    if (ptr == nativeNullPtr) {
        return null
    } else {
        TODO("Not yet implemented")
    }
}