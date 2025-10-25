/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
@file:OptIn(ExperimentalForeignApi::class)
package kotlinx.cinterop

@PublishedApi
internal actual object nativeMemUtils {
    actual fun alloc(size: Long, align: Int): NativePointed {
        TODO("Not yet implemented")
    }

    actual fun free(mem: NativePtr) {
        TODO("Not yet implemented")
    }
}

@PublishedApi
internal actual fun getPointerSize(): Int = dataModel.pointerSize

private enum class DataModel(val pointerSize: Int) {
    _32BIT(4),
    _64BIT(8)
}

private val dataModel: DataModel = when (System.getProperty("sun.arch.data.model")) {
    null -> TODO()
    "32" -> DataModel._32BIT
    "64" -> DataModel._64BIT
    else -> throw IllegalStateException()
}
