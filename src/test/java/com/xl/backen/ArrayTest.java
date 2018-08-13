package com.xl.backen;

import com.xl.backen.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayTest {
	public static void main(String[] args) {
		List<String> s = new ArrayList<>();
		s.add("大神");
		s.add("小夏");

		List<String> d = new ArrayList<>();
		d.add("大神");
		d.add("哈哈哈");

		Collection<String> l = ArrayUtil.compareArr(s,d);

		s.retainAll(d);

		for (String k : l) {
			System.out.println(k);
		}
	}
}
