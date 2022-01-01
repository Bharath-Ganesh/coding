package com.practice.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Container<T extends Number> {
	T value;

	public void show() {
		System.out.println(value.getClass().getName());
	}
}

public class CollectionsExample {

	public static void main(String[] args) {
		// Here we can only pass those values which extends number like
		// Integer Double etc
		Container<Integer> container = new Container<>();
		container.value = 12;
		container.show();

		Collection val = new ArrayList();
		val.add("Telsuko");
		val.add("Brains");
		val.add(2);
		val.add(2);
		val.add(2);

		val.remove("hi");

		// Old method
//		Iterator iterator = val.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}

		val.forEach(x -> System.out.println(x));

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		Collections.sort(list);
		list.forEach(x -> System.out.printf("%d ", x));

	}

}
