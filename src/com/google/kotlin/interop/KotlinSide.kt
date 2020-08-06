//Copyright 2020 Google LLC
//
//        Licensed under the Apache License, Version 2.0 (the "License");
//        you may not use this file except in compliance with the License.
//        You may obtain a copy of the License at
//
//        https://www.apache.org/licenses/LICENSE-2.0
//
//        Unless required by applicable law or agreed to in writing, software
//        distributed under the License is distributed on an "AS IS" BASIS,
//        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//        See the License for the specific language governing permissions and
//        limitations under the License.

package com.google.kotlin.interop


fun add(arg0 : Int, arg1: Int) : Int {
    return arg0 + arg1
}


class KotlinSideMul constructor() {

    var x = 0;
    var y = 0;

    constructor(arg0: Int, arg1: Int) : this() {
        x = arg0
        y = arg1
    }

    fun multiply(arg0 : Int, arg1: Int) : Int {
        return arg0 * arg1
    }

    fun subtractFields() : Int {
        return x - y;
    }
}