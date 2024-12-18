package com.learning.selenium.JavaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamClassDemo {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Bharath");
		names.add("Chandra");
		names.add("Ajay");
		names.add("Akshay");
		names.add("Ram");
		names.add("Sita");

		// on stream concepts we use long only
		long count = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Words starts with A::" + count);

		List<String> sorting = names.stream().sorted().toList();
		System.out.println(sorting);

		Stream<String> filter = names.stream().filter(s -> s.length() > 6);
		System.out.println(filter.count());
		System.out.println("****************");
		names.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));

		System.out.println("Limit Concept***********");
		names.stream().filter(s -> s.length() > 6).limit(1).forEach(s -> System.out.println(s));
		System.out.println("****************");
		List<String> list = Stream.of("Abhijeet", "Bharath", "chandra", "lakmi", "menzfair", "Deo", "Ajay")
				.filter(s -> {
					s.startsWith("A");
					s.contains("e");

					return true;
				}).sorted().toList();

		System.out.println(list);
		System.out.println("Capital*********");
		Stream.of("Abhijeet", "Bharath", "chandra", "lakmi", "menzfair", "Deo", "Ajay").filter(s -> s.contains("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		System.out.println("*************Merge list<String>");
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Abhijeet");
		list1.add("Bharath");
		
		List<String> list2= Arrays.asList("Man","Oman","Main","Bharath");
		
		Stream<String> newStream = Stream.concat(list1.stream(), list2.stream()).sorted();
		newStream.sorted().forEach(s->System.out.println(s));
		System.out.println("************Collections in streams");
		Stream<String> newStream1 = Stream.concat(list1.stream(), list2.stream()).sorted();
		
		newStream1.sorted().distinct().collect(Collectors.toList()).forEach(s->System.out.println(s));
		
		//System.out.println(collect);
		
	}

}
