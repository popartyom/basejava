package com.urise.webapp;

import com.urise.webapp.model.*;

import java.lang.reflect.*;

/**
 * @author Artyom Popov
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        Method toString = resumeClass.getMethod("toString");
        System.out.println(toString.invoke(r));
    }
}
