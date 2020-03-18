package com.github.scfj.badclass;

import com.google.common.reflect.ClassPath.ClassInfo;

import java.util.ArrayList;
import java.util.List;

public class BadClasses {
    private final Classes classes;

    public BadClasses(Classes classes) {
        this.classes = classes;
    }

    public List<ClassInfo> asList() throws ClassNotFoundException {
        List<ClassInfo> classInfos = classes.asList();
        List<ClassInfo> badClasses = new ArrayList<>();
        for (ClassInfo classInfo : classInfos) {
            if (bad(classInfo)) {
                badClasses.add(classInfo);
            }
        }
        return badClasses;
    }

    private boolean bad(ClassInfo classInfo) {
        return has5Words(classInfo.getSimpleName());
    }

    private boolean has5Words(String name) {
        int wordsCount = 0;
        for (String word : name.split("[A-Z]")) {
            if (word.length() > 0) {
                wordsCount += 1;
            }
        }
        return wordsCount > 5;
    }
}
