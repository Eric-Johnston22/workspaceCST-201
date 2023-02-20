package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph
{
	static class Edge
	{
		int source;
		int destination;
		int distance;

		public Edge(int source, int destination, int distance)
		{
			this.source = source;
			this.destination = destination;
			this.distance = distance;
		}
	}

	// Array of Arizona counties
	private String[] azCounties = { "Mohave", "Coconino", "Navajo", "Apache", "Greenlee", "Cochise", "Santa Cruz",
			"Pima", "Pinal", "Graham", "Gila", "Yavapai", "La Paz", "Yuma", "Maricopa" };
	private ArrayList<Edge>[] edgeArr = new ArrayList[15];

	public Graph()
	{
		for (int i = 0; i < 15; i++)
		{
			edgeArr[i] = new ArrayList<>();
		}
	}

	private void addEdge(int source, int destination, int distance)
	{
		ArrayList<Edge> items = edgeArr[source];
		Edge edge = new Edge(source, destination, distance);
		items.add(edge);
	}

	public void makeGraph(int[][] edges)
	{
		for (int i = 0; i < edges.length; i++)
		{
			addEdge(edges[i][0], edges[i][1], edges[i][2]);
		}
	}

	public void printGraph(int[][] matrix)
	{
//		int[][] newMatrix = new int[15][15];
//		
//
//		for (int i = 0; i < edgeArr.length; i++)
//		{
//			for (int j = 0; j < edgeArr[i].size(); j++)
//			{
//				int tempDest = edgeArr[i].get(j).destination;
//				int numNeighbors = getNeighbors(0).size();
//				
//				System.out.println(i + j);
//			}
//		}
//		
//		for (int[] row : newMatrix)
//		{
//			System.out.println(Arrays.toString(row));
//		}


//		for(int row = 0; row < 15; row++)
//		{
//			for(int col = 0; col < 15; col++)
//			{
//				for (int i = 0; i < edgeArr.length; i++)
//				{
//					for (int j = 0; j < edgeArr[i].size(); j++)
//					{
//						int tempDest = edgeArr[i].get(j).destination;
//						System.out.println(tempDest);
//					}
//					System.out.println();
//				}
//			}
//		}
		

//		for (int row = 0; row < 15; row++)
//		{
//			for (int col = 0; col < 15; col++)
//			{
//				if (matrix[row][col] == Integer.MAX_VALUE)
//					System.out.printf("%5s", "X");
//				else
//					System.out.printf("%5d", matrix[row][col]);
//			}
//			System.out.println();
//		}

		System.out.println("The first number in each row represents a connecting county's vertex,"
							+ " while the second number represents the distance between "
							+ "the current vertex and that connecting vertex.\n");
		for (int i = 0; i < edgeArr.length; i++)
		{	
			System.out.println("Vertex " + edgeArr[i].get(0).source + " - " + azCounties[i] + " county" + ":");
			
			for (int j = 0; j < edgeArr[i].size(); j++)
			{
				// Holds temporary destination 
				int tempDest = edgeArr[i].get(j).destination;
				
				System.out.print("\s\s\s" + "(" + tempDest + ") " + azCounties[tempDest] + " ");
				System.out.print(edgeArr[i].get(j).distance + " \n");
				
				
			}
		}
	}

	public int getDistance(int source, int destination)
	{
		ArrayList<Integer> visited = new ArrayList<>();
		int distanceTraveled = 0;
		int MAX_INT_VAL = Integer.MAX_VALUE;
		visited.add(source);

		for (int i = source; i < edgeArr.length; i++)
		{
			for (Edge edge : edgeArr[i])
			{
				if (destination == edge.destination)
				{
					distanceTraveled = edge.distance;
				}
				// return distanceTraveled;
				else
				{
					i = edge.destination;
					for (Edge newEdge : edgeArr[i])
					{
						if (newEdge.destination == destination && !visited.contains(edge.destination))
						{
							visited.add(i);
							distanceTraveled += edge.distance + newEdge.distance;

						}
					}
				}
			}
		}

		return distanceTraveled;
	}

	public List<String> getNeighbors(int source)
	{
		List<String> neighbors = new ArrayList<>();
		for (Edge edge : edgeArr[source])
		{
			neighbors.add(azCounties[edge.destination]);
		}

		return neighbors;
	}
}
