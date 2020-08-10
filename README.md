# J2ObjC Kotlin Native Demo
A demo for J2ObjC - Kotlin/Native Interop where Java code imports and calls Kotlin code, and then the Java and Kotlin code is translated by J2ObjC and Kotlin/Native, respectively.

## Requirements
- Kotlin and Kotlin/Native
- Java 8
- [My J2ObjC Fork](https://github.com/dhwitz/j2objc/tree/kotlin-native)

## Instructions
Compile the Kotlin file with `kotlinc-native KotlinSide.kt -produce framework -o ComGoogleKotlinInterop`. The framework name currently needs to be the same as the package name.

Create the Kotlin Jar file with `kotlinc KotlinSide.kt -include-runtime -java-parameters -d KotlinSide.jar`

Build the J2ObjC fork and compile the Java file with `./j2objc [path-to-file]/JavaSide.java -classpath [path-to-file]/KotlinSide.jar`
Alternativley, open the translator directory from the fork in your IDE of choice and run the translator with the arguments `[path-to-file]/JavaSide.java -classpath [path-to-file]/KotlinSide.jar`

Create the binary with `./j2objcc [path-to-file]/JavaSide.m  [path-to-file]/JavaSide.h  -framework ComGoogleKotlinInterop -F [path-to-directory-containing-framework] -rpath [path-to-directory-containing-framework]`

Run the resulting file with `./a.out ComGoogleKotlinInteropJavaSide`

## Licence
    Copyright 2020 Google LLC

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
