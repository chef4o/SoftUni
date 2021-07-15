package reflectionsAndAnnotations.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        System.out.println("class " + clazz.getName());

        Class<? super Reflection> baseClazz = clazz.getSuperclass();
        System.out.println("class " + baseClazz.getName());

        Arrays.stream(clazz.getInterfaces())
                .forEach(i -> System.out.println("interface " + i.getName()));

        try {
            System.out.println(clazz.getConstructor().newInstance().toString());
        } catch (NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
