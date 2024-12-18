package com.learning.selenium.JavaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapDemo {

	public static void main(String[] args) {

		Stream.of("Abc", "xyz", "pqr", "klm").filter(s -> s.contains("y")).forEach(s -> System.out.println(s));

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeeth");
		names.add("Bharath");
		names.add("Chandra");
		names.add("Ajay");
		names.add("Akshay");
		names.add("Ram");
		names.add("Sita");



		names.stream().filter(s -> s.endsWith("h")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("---------------");
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Kalyan");
		names1.add("Pawan");
		names1.add("Chiru");

		System.out.println("---------------");
		Stream.concat(names.stream(), names1.stream()).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		;

		System.out.println("---------------");
		Stream<String> map = Stream.concat(names.stream(), names1.stream()).sorted().map(s -> s.toUpperCase());
//		List<String> list = map.toList();
//		System.out.println(list);
		
		boolean anyMatch = map.anyMatch(s -> s.equalsIgnoreCase("ram"));

		System.out.println(anyMatch);
		System.out.println("---------------");		
		List<Integer> nums= Arrays.asList(3,1,35,3,1,2,4,53,3,4);
		nums.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("---------------");	
		nums.stream().distinct().sorted().forEach(s->System.out.println(s));
		System.out.println("---------------");
		List<Integer> collect = nums.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(collect.get(collect.size()-1));

		
		
		
		
		
		
	}

}
