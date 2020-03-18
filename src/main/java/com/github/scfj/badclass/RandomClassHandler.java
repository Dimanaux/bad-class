package com.github.scfj.badclass;

import com.google.common.reflect.ClassPath;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;

public class RandomClassHandler implements Route {
    @Override
    public Object handle(Request request, Response response) {
        response.header("Content-Type", "application/json");
        try {
            return new RandomThing<>(
                    new Classes(
                            ClassPath.from(
                                    getClass().getClassLoader()
                            )
                    ).asList()
            ).get();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
