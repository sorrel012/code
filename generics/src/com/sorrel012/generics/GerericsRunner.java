package com.sorrel012.generics;

public class GerericsRunner {
	
	public static void main(String[] args) {

		MyCustomList<String> list = new MyCustomList<>();
		list.addElement("Element 1");
		list.addElement("Element 2");
		String value = list.get(0);
		
		System.out.println(list);
		System.out.println(value);
		
		System.out.println();
		
		MyCustomList<Integer> list2= new MyCustomList<>();
		list2.addElement(Integer.valueOf(5));
		list2.addElement(Integer.valueOf(7));
		Integer number= list2.get(0);
		
		System.out.println(list2);
		System.out.println(number);

	} //main

}