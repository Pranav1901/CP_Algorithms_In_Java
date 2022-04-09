package graph;

import java.util.*;
/*
 * INPUT
5
6
0 1
0 2
1 3
2 3
2 4
4 3

 */

public class Breadth_First_Search {
// Main Function ----------------------->
	public static void main(String[] args) {
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
		System.out.println("Enter the Source Node for Breadth First Traversal :");
		int S = sc.nextInt();
		bfs(adj,S);
	}
//-------Bfs Function ------------------>
	private static void bfs(ArrayList<ArrayList<Integer>> adj, int S) {
		// TODO Auto-generated method stub
		int N = adj.size();
		boolean visited [] = new boolean [N];
		int dist [] = new int[N];
		int parent [] = new int [N];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visited[S]=true;
		parent[S]=-1;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int u : adj.get(v)) {
				if(!visited[u]) {
					visited[u]=true;
					q.add(u);
					dist[u]=dist[v]+1;
					parent[u]=v;
				}
			}
		}
    //------For Distance Representation-------->
		for(int i =0;i<N;i++) {
			System.out.println(i+" "+dist[i]);
		}
    
    //--------For Path Representation --------->
		for(int i =0;i<N;i++) {
			if(!visited[i]) {
				System.out.println(i+" : No Path");
			}
			else {
				ArrayList<Integer> path = new ArrayList<>();
				for(int j =i;j!=-1;j=parent[j]) {
					path.add(j);
				}
				System.out.print(i+" :Path = ");
				for(int j = path.size()-1;j>=0;j--) {
					System.out.print(path.get(j)+" ");
				}
				System.out.println();
			}
		}
		
	}

}
