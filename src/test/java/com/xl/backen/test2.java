package com.xl.backen;

import com.xl.backen.entity.Peoples;

import java.lang.reflect.Field;

public class test2 {
  public static void main(String[] args) throws IllegalAccessException {
    Peoples p = new Peoples();
    p.setUuid("123");


    Peoples p1 = new Peoples();
    p1.setUuid("1234");
    p1.setSex(2);


//    try {
//      Field field = p1.getClass().getDeclaredField("uuid");
//      System.out.println(field);
//      field.setAccessible(true);
//      field.set(p1,"123456");
//    } catch (NoSuchFieldException e) {
//      e.printStackTrace();
//    }

    Field[] fields = p.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      fields[i].setAccessible(true);
      if (fields[i].getType().toString().endsWith("String") || fields[i].getType().toString().endsWith("Integer") && fields[i].get(p) != null) {
        fields[i].set(p1, fields[i].get(p));
      }
    }

    System.out.println(p1);
  }
}
