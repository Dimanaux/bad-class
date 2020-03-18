package com.github.scfj.badclass;

import static spark.Spark.get;

public class BadClassApplication {
    public static void main(String[] args) {
        get("/", new RandomClassHandler());
    }
}
