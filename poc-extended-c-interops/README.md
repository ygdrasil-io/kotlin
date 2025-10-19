# Extended C Interops for Kotlin Native

## Project Goal

This subproject aims to extend Kotlin Native C interop functionalities to Java and Android platforms using Panama Foreign Function & Memory API and JNI technologies.

## Implementation Plan

### 1. Standard Library Modifications

Modify the Kotlin standard library to make interop APIs functional across three platforms:
- **Kotlin/Native** (existing)
- **Kotlin/JVM** (new)
- **Kotlin/Android** (new)

#### JVM Platform Strategy

Since the Panama API is only available from Java 22 onwards, the implementation must support both:
- **Panama FFM API** for Java 22+
- **JNI** for earlier Java versions and Android

This approach mirrors the existing stdlib strategy where separate versions exist for JDK 7/8 and more recent versions.

### 2. CInterop Plugin Fork

After stdlib modifications, fork the existing cinterop plugin to support the new platforms.

#### Code Generation Strategies

Two approaches are being studied for generating interop glue code:

1. **Kotlin Code Generation**
   - Generates Kotlin source code
   - Slower execution
   - More stable and robust
   - Easier to maintain across compiler versions

2. **Direct Compiler Symbol Generation (FIR?)**
   - Generates compiler symbols directly
   - Faster execution
   - Less robust to compiler modifications
   - May require updates with each compiler version

