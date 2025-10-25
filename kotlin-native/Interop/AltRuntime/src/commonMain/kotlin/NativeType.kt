/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlinx.cinterop

@Suppress("NOTHING_TO_INLINE")
@ExperimentalForeignApi
internal inline fun NativePtr.toNonNull() = this.reinterpret<NativePtr, NonNullNativePtr>()

@PublishedApi
@ExperimentalForeignApi
internal fun <T : CVariable> typeOf(): CVariable.Type = throw Error("typeOf() is called with erased argument")
