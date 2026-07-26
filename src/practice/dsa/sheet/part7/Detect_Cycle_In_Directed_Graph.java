package practice.dsa.sheet.part7;

import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_In_Directed_Graph {
	
	public static void main(String[] args) {
		
		//int[][] graph = {{1}, {2}, {3, 6}, {4}, {5}, {}, {4}, {1, 8}, {9}, {7}};
		
		//int[][] graph = {{2}, {2}, {3}, {4}, {5, 7}, {6}, {3}, {8, 9}, {}, {}};
		
		int[][] graph = {{2}, {2}, {3}, {4, 6}, {5, 7}, {6}, {}, {8, 9}, {}, {}};
		
		boolean check = detectCycle_Using_Topological_Sorting(graph);
		
		System.out.println(check);
	}
	
	/*
	 * If a node is found which is already visited and is in the same 
	 * path then there is a cycle.
	 * 
	 * T = O(V) + O(V+E)
	 * S = O(2V)
	 */
	public static boolean detectCycle_Using_DFS(int[][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		int[] nodeVisited = new int[n];
		int[] pathVisited = new int[n];
		
		for(int i = 0; i <= n-1; i++) {
			if(nodeVisited[i] == 0) {
				boolean check = DFS(adjacencyList, nodeVisited, pathVisited, i);
				if(check) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean DFS(int[][] adjacencyList, int[] nodeVisited, int[] pathVisited, int start) {
		
		nodeVisited[start] = 1;
		pathVisited[start] = 1;
		
		int[] adjacentVertices = adjacencyList[start];
		
		for(int i = 0; i <= adjacentVertices.length-1; i++) {
			if(nodeVisited[adjacentVertices[i]] == 0) {
				boolean check = DFS(adjacencyList, nodeVisited, pathVisited, adjacentVertices[i]);
				if(check) {
					return true;
				}
			} else {
				if(nodeVisited[adjacentVertices[i]] == 1 && pathVisited[adjacentVertices[i]] == 1) {
					return true;
				}
			}
		}
		
		pathVisited[start] = 0;
		return false;
	}
	
	/*
	 * We can find cycle in a directed graph using Topological sorting / BFS
	 * 
	 * T = O(V) + O(V+E)
	 * S = O(V)
	 */
	public static boolean detectCycle_Using_Topological_Sorting(int[][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		int[] indegree = new int[n];
		
		for(int[] adjecentVertices : adjacencyList) {
			for(int i = 0; i <= adjecentVertices.length-1; i++) {
				indegree[adjecentVertices[i]]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int count = 0;
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			count++;
			
			int[] adjacentVertices = adjacencyList[popped];
			
			for(int i = 0; i <= adjacentVertices.length-1; i++) {
				indegree[adjacentVertices[i]]--;
				if(indegree[adjacentVertices[i]] == 0) {
					queue.add(adjacentVertices[i]);
				}
			}
		}
		
		return count == n ? false: true;
	}
}
