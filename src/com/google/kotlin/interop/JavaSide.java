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

package com.google.kotlin.interop;

import com.google.kotlin.interop.KotlinSideKt;
import com.google.kotlin.interop.KotlinSideMul;

import java.util.List;

public class JavaSide {

    public static void main(String[] args) {

        int add = KotlinSideKt.add(3, 4);

        System.out.println(add);

        KotlinSideMul mul = new KotlinSideMul();

        int mulInt = mul.multiply(3, 5);

        System.out.println(mulInt);

        mul.setX(3);

        mul.setY(4);

        int subInt = mul.subtractFields();

        System.out.println(subInt);

        System.out.println(mul.getX());


        KotlinSideMul constrTest = new KotlinSideMul(5, 5);

        subInt = constrTest.subtractFields();

        System.out.println(subInt);
    }
}
