/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package kotlinx.cinterop

import kotlin.native.internal.IntrinsicType
import kotlin.native.internal.TypedIntrinsic
import kotlin.native.internal.reinterpret

/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

actual class NativePtr {
    actual companion object {
        actual val NULL: NativePtr
            get() = TODO("Not yet implemented")
    }

    @TypedIntrinsic(IntrinsicType.INTEROP_NATIVE_PTR_PLUS_LONG)
    public external operator fun plus(offset: Long): kotlin.native.internal.NativePtr
}

actual class NonNullNativePtr {
    @Suppress(names = ["NOTHING_TO_INLINE"])
    actual inline fun toNativePtr(): NativePtr {
        TODO("Not yet implemented")
    }
}

@PublishedApi actual internal fun <T, R> T.reinterpret(): R = kotlin.native.internal.reinterpret()

/**
 * Performs type cast of the native pointer to given interop type, including null values.
 *
 * @param T must not be abstract
 */
@ExperimentalForeignApi
@TypedIntrinsic(IntrinsicType.IDENTITY)
actual external fun <T : NativePointed> interpretNullablePointed(ptr: NativePtr): T?