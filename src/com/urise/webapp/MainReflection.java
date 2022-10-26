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
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        Method toString = r.getClass().getMethod("toString", null);
        System.out.println(toString.invoke(r, null));
        System.out.println(r);
    }
}
