package practice.dsa.sheet.part8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Max_Profit_In_Job_Scheduling {
	
	public static void main(String[] args) {
		
		int[] profit = {20, 20, 100, 70, 60};
		int[] startTime = {1, 2, 3, 4, 6};
		int[] endTime = {3, 5, 10, 6, 9};
		
		int maxProfit = jobScheduling(startTime, endTime, profit);
		
		System.out.println(maxProfit);
	}
	
	/*
	 * T = O(n*log n) + O(n) + O(n*maxDeadline) = O(n*maxDeadline)
	 * S = O(n) + O(maxDeadline)
	 */
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		
		int n = profit.length;
		PriorityQueue<Triplet> maxHeap = new PriorityQueue<>(Comparator.comparing((Triplet t) -> t.profit).reversed());
		
		int maxEndTime = 0;
		for(int i = 0; i <= n-1; i++) { // T = O(n*log n)
			maxHeap.add(new Triplet(profit[i], startTime[i], endTime[i]));
			
			if(endTime[i] > maxEndTime) {
				maxEndTime = endTime[i];
			}
		}
		
		int[] timeLine = new int[maxEndTime];
		Arrays.fill(timeLine, -1); // T = O(n)
		
		int maxProfit = 0;
		
		for(int i = 0; i <= n-1; i++) { // T = O(n*maxDeadline)
			Triplet popped = maxHeap.poll();
			boolean filledCompletely = false;
			for(int j = popped.end-1; j >= popped.start; j--) {
				if(timeLine[j] == -1) {
					timeLine[j] = popped.profit;
					if(j == popped.start) {
						filledCompletely = true;
					}
				} else {
					break;
				}
			}
			
			if(filledCompletely) {
				maxProfit += popped.profit;
			}
		}
		
		return maxProfit;
	}
}

class Triplet {
	
	public int profit;
	public int start;
	public int end;
	
	public Triplet(int profit, int start, int end) {
		this.profit = profit;
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Triplet[profit=" + profit + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
