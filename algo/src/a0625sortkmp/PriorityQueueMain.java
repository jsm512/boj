package a0625sortkmp;

import java.util.*;

public class PriorityQueueMain {
	static class Car implements Comparable<Car>{
		String name;
		int year;
		Car(String name, int year){
			this.name = name;
			this.year = year;
		}
		@Override
		public String toString() {
			return name+year;
		}
		@Override
		public int compareTo(Car o) {
			return name.compareTo(o.name);
//			return Integer.compare(year, o.year);
		}
	}
	public static void main(String[] args) {
//		PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.reverseOrder());
//		PriorityQueue<Car> pq = new PriorityQueue<>(new Comparator<Car>() {
//			@Override
//			public int compare(Car o1, Car o2) {
//				return Integer.compare(o1.year, o2.year);
//			}
//		});
		PriorityQueue<Car> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.year, o2.year));
		pq.offer(new Car("아반떼", 2015));
		pq.offer(new Car("그랜저", 2007));
		pq.offer(new Car("소나타", 2024));
		pq.offer(new Car("아반떼", 2015));
		pq.offer(new Car("그랜저", 2008));
		pq.offer(new Car("소나터", 2024));
		System.out.println(pq);
		System.out.println();
		while(!pq.isEmpty()) System.out.print(pq.poll() + " "); 
		System.out.println();
		/*
//		 우선 순위 큐의 디폴트는 최소 힙 
//		 Comparator.reversOrder() -> 최대 힙
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();//최대 힙 Comparator.reverseOrder()
//		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> -Integer.compare(o1, o2)); //최대 힙
		
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		
		System.out.println(pq);
		while(!pq.isEmpty()) System.out.print(pq.poll()+ " ");
		System.out.println();
		*/
	}

}
