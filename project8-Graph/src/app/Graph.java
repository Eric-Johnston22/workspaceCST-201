package app;

import java.util.ArrayList;
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
		// Loop through all edges, add them to edgeArr
		for (int i = 0; i < edges.length; i++)
		{
			addEdge(edges[i][0], edges[i][1], edges[i][2]);
		}
	}

	public void printGraph(int[][] matrix)
	{
		System.out.println("The first number in each row represents a connecting county's vertex,"
				+ " while the second number represents the distance between "
				+ "the current vertex and that connecting vertex.\n");
		for (int i = 0; i < edgeArr.length; i++)
		{
			System.out.println("Vertex " + edgeArr[i].get(0).source + " - " + azCounties[i] + " county" + ":");
			
			for (int j = 0; j < edgeArr[i].size(); j++)
			{
				// Holds temporary destination
				int neighbor = edgeArr[i].get(j).destination;
				
				System.out.print("\s\s\s" + "(" + neighbor + ") " + azCounties[neighbor] + " ");
				System.out.print(edgeArr[i].get(j).distance + " \n");
				
			}
		}
		
		
//		int[][] newMatrix = new int[16][16];
//		
//		for (int i = 0; i < 16; i++)
//		{
//			for (int j = 0; j < 16; j++)
//			{
//				if(!(i < 1))
//				{
//					newMatrix[i][0] = i;
//					newMatrix[0][j] = j;
//				}
//			}
//		}
//		
//		for(int row = 1; row < 16; row++)
//		{
//			for(int col = 1; col < 16; col++)
//			{
//				for (int i = 0; i < edgeArr.length; i++)
//				{
//					for (int j = 0; j < edgeArr[i].size(); j++)
//					{
//						int neighbor = edgeArr[i].get(j).destination;
//						int numNeighbors = getNeighbors(0).size();
//						
//						if (col == neighbor)
//						{
//							newMatrix[row][col] = edgeArr[i].get(j).distance;
//						}
//						else
//						{
//							newMatrix[row][col] = 9;
//						}
//					}
//				}
//			}
//		}

//		for (int[] row : newMatrix)
//		{
//			System.out.println(Arrays.toString(row));
//		}
	}

	public int getDistance(int source, int destination)
	{
		// Loop through each edge of the source vertex
		for (Edge edge : edgeArr[source])
		{
			// Look for destination within each edge of the source vertex
			if (edge.destination == destination)
			{
				return edge.distance;
			}
		}

		// Return if destination not found
		return Integer.MAX_VALUE;
	}

	public List<String> getNeighbors(int source)
	{
		List<String> neighbors = new ArrayList<>();
		// Loop through each edge of the source vertex
		for (Edge edge : edgeArr[source])
		{
			neighbors.add(azCounties[edge.destination]);
		}

		return neighbors;
	}
}
