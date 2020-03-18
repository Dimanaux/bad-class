package com.github.scfj.badclass;

import java.util.List;
import java.util.Random;

public class RandomThing<T> {
    private final List<T> list;

    public RandomThing(List<T> list) {
        this.list = list;
    }

    public T get() {
        return list.get(
                new Random().nextInt(list.size())
        );
    }
}
