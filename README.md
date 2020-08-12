# J2ObjC Kotlin Native Demo
A demo for J2ObjC - Kotlin/Native Interop where Java code imports and calls Kotlin code, and then the Java and Kotlin code is translated by J2ObjC and Kotlin/Native, respectively.

## Requirements

- Kotlin and Kotlin/Native
- Java 8
- [My J2ObjC Fork](https://github.com/dhwitz/j2objc/tree/kotlin-native)


If you use Homebrew on macOS, you can install Kotlin with `brew install kotlin`.

To install Kotlin/Native, you can download a copy of the release tar [such as this one](https://github.com/JetBrains/kotlin/releases/tag/v1.3.72), untar the file, then add the untared `kotlin-native-macos-$VERSION/bin` to your `PATH`.

Before you follow the instructions below, make sure that:

* `kotlinc` is from your Kotlin installation (*not* the Kotlin/Native installation)
* `kotlinc-native` is from your Kotlin/Native installation
* `j2objc` and `j2objcc` are from your J2ObjC installation (built from *my* fork [here](https://github.com/dhwitz/j2objc/tree/kotlin-native))

## Instructions

In the project root, compile the Kotlin file with:

```
kotlinc-native src/com/google/kotlin/interop/KotlinSide.kt -produce framework -o ComGoogleKotlinInterop
```

(The framework name currently needs to be the same as the package name.)

Then, produce the JAR file that is needed by the J2ObjC step:

```
kotlinc src/com/google/kotlin/interop/KotlinSide.kt -include-runtime -java-parameters -d KotlinSide.jar
```

Now, translate the Java side with J2ObjC:

```
j2objc src/com/google/kotlin/interop/JavaSide.java -classpath KotlinSide.jar
```

Alternativley, if you are running J2ObjC from its IntelliJ project file, run the translator with the arguments `[path-to-file]/JavaSide.java -classpath [path-to-file]/KotlinSide.jar`

Make a symbolic link to the framework produced by `kotlinc-native` (this is due to how we currently make header references in the translator fork):

```
ln -s $PWD/ComGoogleKotlinInterop.framework com/google/kotlin/interop/
```

Finally, compile the translated Objective-C code and build the executable with `j2objcc`:

```
j2objcc com/google/kotlin/interop/JavaSide.m -I ./ -F ./ -framework ComGoogleKotlinInterop -rpath ./
```

Run the result with:

```
./a.out ComGoogleKotlinInteropJavaSide
```

The output should look like

```
7
15
-1
3
0
```

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
