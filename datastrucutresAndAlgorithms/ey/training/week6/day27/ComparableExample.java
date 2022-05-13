package datastrucutresAndAlgorithms.ey.training.week6.day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableExample {

	public static void main(String[] args) {
//		List<Integer> lst = new ArrayList<>();
//		lst.add(1);
//		lst.add(9);
//		lst.add(2);
//		lst.add(7);
//		lst.add(3);
//		Collections.sort(lst);
////		System.out.println(lst);
//		
//		List<String> names = new ArrayList<>();
//		names.add("Sanjay");
//		names.add("Bharathi");
//		names.add("Natraaj");
//		Collections.sort(names);
//		System.out.println(names);
		
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.add(new Laptop("Dell", 16, 800));
		laptops.add(new Laptop("Apple", 8, 1200));
		laptops.add(new Laptop("Acer", 12, 700));
//		
		Collections.sort(laptops);
		
		
//		Collections.sort(laptops, new PriceComparator());
		
//		Collections.sort(laptops, new Comparator<Laptop>() {
//
//			@Override
//			public int compare(Laptop o1, Laptop o2) {
//				if(o1.getPrice()>o2.getPrice()) {
//					return 1;
//				}else if(o1.getPrice()<o2.getPrice()) {
//					return -1;
//				}
//				return 0;
//			}
//		});
		
//		Collections.sort(laptops, (o1, o2) -> {
//				if(o1.getPrice()>o2.getPrice()) {
//					return 1;
//				}else if(o1.getPrice()<o2.getPrice()) {
//					return -1;
//				}
//				return 0;	
//		});
		
//		Collections.sort(laptops, (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
		Collections.sort(laptops, (o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));
		
		for(Laptop lap : laptops) {
			System.out.println(lap);
		}
		
		
		
		
//		System.out.println("a".compareTo("x"));
//		System.out.println("d".compareTo("a"));
//		System.out.println("d".compareTo("d"));
//		
//		Integer i = 10;
//		System.out.println(i.compareTo(100));
		
//		List<Employee> emplst = new ArrayList<Employee>();
//		emplst.add(new Employee("Sanjay", 4));
//		emplst.add(new Employee("Natraaj", 1));
//		emplst.add(new Employee("Bharathi", 3));
//		emplst.add(new Employee("Sanjay", 2));
//		
//		Collections.sort(emplst);
//		
//		for(Employee emp : emplst) {
//			System.out.println(emp);
//		}
		
	}
	
	
}
