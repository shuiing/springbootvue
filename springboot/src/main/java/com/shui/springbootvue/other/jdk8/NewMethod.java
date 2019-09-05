package com.shui.springbootvue.other.jdk8;

import java.util.function.Supplier;

/**
 * 方法引用
 */
public class NewMethod {

        public static NewMethod create(final Supplier<NewMethod> supplier) {
            return supplier.get();
        }

        public static void collide(final NewMethod car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final NewMethod another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
}