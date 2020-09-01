package com.study.reentrantLock;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author huang.lehao@hand-china.com
 * @Description:
 * @date 2020/5/7 19:58
 */
public class Test {
    private static BigDecimal aaa= new BigDecimal("1.1111");
    public static void main(String[] args) {

       /* Map<String, List<Object>> map = new HashMap<>();
        List<User> users = new ArrayList<>();
        User user = new User("name","");
        users.add(user);
        a(map);*/

        System.out.println(aaa.toString());


    }

    public static <T> void a(Map<String, List<T>> map){
        List<User> users = new ArrayList<>();
        User user = new User("name","");
        users.add(user);
        map.put(user.getClass().getSimpleName(), (List<T>) users);
        System.out.println(map.get(user.getClass().getSimpleName()));
        List<User> users1= (List<User>) map.get(user.getClass().getSimpleName());
        System.out.println(map.get(user.getClass().getSimpleName()));
        System.out.println(users1);

    }
    public static <T> List<?> assignValueByField(List<T> source, Class clazz, String property, Object value) {

        List<T> target = new ArrayList<>(source.size());
        try {
            for (T item : source) {
                if (property != null && property != null) {
                    Field f = null;
                    try {
                        f = item.getClass().getDeclaredField(property);
                        f.setAccessible(true);
                        f.set(item, value);
                    } catch (Exception e) {
                        throw new Exception("对象属性赋值失败：{}", e);
                    }
                }
                target.add(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return target;
    }

    public static <T> void assignValueByField(List<T> source, Class clazz, List<String> propertys, Map<String,Object> values) {

        try {
            for (T item : source) {
                for(String property:propertys) {
                    if (property != null && property != null) {
                        Field f = null;
                        try {
                            f = item.getClass().getDeclaredField(property);
                            f.setAccessible(true);
                            f.set(item, values.get(property));
                        } catch (Exception e) {
                            throw new Exception("对象属性赋值失败：{}", e);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
