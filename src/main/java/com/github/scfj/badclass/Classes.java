package com.github.scfj.badclass;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Classes {
    private final ClassPath classPath;

    public Classes(ClassPath classPath) {
        this.classPath = classPath;
    }

    public List<ClassInfo> asList() {
        return Stream.of("org.springframework", "com.google", "org.hibernate", "javax")
                .flatMap(pack -> classPath.getTopLevelClassesRecursive(pack).stream())
                .collect(toList());
    }
}
