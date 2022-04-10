package graph;
import java.util.*;
/*
5
6
0 1
0 2
1 3
2 3
2 4
4 3

 */

public class Deapth_First_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Nodes: ");
		int N = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i =0;i<N;i++) {
			adj.add(new ArrayList<Integer>());
		}
		System.out.println("Enter the Number of Edges: ");
		int E = sc.nextInt();
		System.out.println("Enter the edges in the form of node1 to node2");
		for(int i =0;i<E;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		for(int i =0;i<N;i++) {
			System.out.println(i+" : "+adj.get(i));
		}
		System.out.println("Enter the Source Node for Breadth First Traversal :");
		int S = sc.nextInt();
		boolean visited [] = new boolean[N];
		int timer [] = new int [N];
		int time =0;
		dfs(adj,S,visited,timer,time);
		for(int i =0;i<N;i++) {
			System.out.println(i+" "+timer[i]);
		}
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited,int[]timer,int time) {
		// TODO Auto-generated method stub
		timer[s] = time++;
		visited[s]= true;
		for(int u :adj.get(s)) {
			if(!visited[u])dfs(adj,u,visited,timer,time);
		}
	}

}
