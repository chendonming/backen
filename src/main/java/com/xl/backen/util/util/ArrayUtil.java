package com.xl.backen.util.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数组操作
 */
public class ArrayUtil {
	/**
	 * 对比两个集合 a1 和  a2
	 *
	 * @return a2中没有元素并包装成集合
	 */
	public static<T> List<T> compareArr(List<T> a1, List<T> a2) {
		List<T> c = new ArrayList<T>();

		Iterator<T> iterator =  a1.iterator();
		while (iterator.hasNext()) {
			c.add(iterator.next());
		}

		c.removeAll(a2);

		//c 为已经 过滤的集合

		return c;
	}

	/**
	 * 对比两个集合 a1 和  a2
	 *
	 * @return a2和a1中相同的集合
	 */
	public static<T> List<T> compareArrSame(List<T> a1, List<T> a2) {
		List<T> c = new ArrayList<T>();

		Iterator<T> iterator =  a1.iterator();
		while (iterator.hasNext()) {
			c.add(iterator.next());
		}

		c.retainAll(a2);

		//c 为已经 过滤的集合

		return c;
	}
}
