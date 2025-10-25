/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
@file:OptIn(ExperimentalForeignApi::class)
package kotlinx.cinterop

@PublishedApi
internal inline val pointerSize: Int
    get() = getPointerSize()

@PublishedApi
expect internal fun getPointerSize(): Int

@PublishedApi
internal expect object nativeMemUtils {

    fun getByte(mem: NativePointed): Byte
    fun putByte(mem: NativePointed, value: Byte)

    fun getShort(mem: NativePointed): Short
    fun putShort(mem: NativePointed, value: Short)

    fun getInt(mem: NativePointed): Int
    fun putInt(mem: NativePointed, value: Int)

    fun getLong(mem: NativePointed): Long
    fun putLong(mem: NativePointed, value: Long)

    fun getFloat(mem: NativePointed): Float
    fun putFloat(mem: NativePointed, value: Float)

    fun getDouble(mem: NativePointed): Double
    fun putDouble(mem: NativePointed, value: Double)

    fun getNativePtr(mem: NativePointed): NativePtr
    fun putNativePtr(mem: NativePointed, value: NativePtr)

    //fun getVector(mem: NativePointed): Vector128
    //@TypedIntrinsic(IntrinsicType.INTEROP_READ_PRIMITIVE) external fun putVector(mem: NativePointed, value: Vector128)

    fun alloc(size: Long, align: Int): NativePointed
    fun free(mem: NativePtr)
}