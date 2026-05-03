package collectionFrameWork.priorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueue_MaxHeap {
	public static void main(String[] args) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		System.out.println("Heap size :" + maxHeap.size() + "\n");
		
		maxHeap.add(9); // add or insert
		maxHeap.add(15);
		maxHeap.add(6);
		maxHeap.add(18);
		maxHeap.add(16);
		maxHeap.add(20);
		maxHeap.add(13);
		maxHeap.add(11);
		
		Iterator<Integer> ite = maxHeap.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		
		System.out.println("\n----------------------------------");
		System.out.println(maxHeap.remove()); // delete max
		System.out.println("\n----------------------------------");
		
		ite = maxHeap.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		
		System.out.println("\n----------------------------------");
		System.out.println(maxHeap.poll()); // delete max
		System.out.println("\n----------------------------------");
		ite = maxHeap.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		
		System.out.println("\n----------------------------------");
		System.out.println("Heap size = "+maxHeap.size()); // heap_size
	}
}
