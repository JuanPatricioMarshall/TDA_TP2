package algoritmos;

import java.util.*;
// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {


        static final int V=9;
        static int minDistance(int dist[], Boolean sptSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index=-1;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && dist[v] <= min)
                {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance array
        static void printSolution(int dist[], int n)
        {
            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i+" \t\t "+dist[i]);
        }

        // Funtion that implements Dijkstra's single source shortest path
        // algorithm for a graph represented using adjacency matrix
        // representation
        static void dijkstra(int graph[][], int src)
        {
            int dist[] = new int[V]; // The output array. dist[i] will hold
            // the shortest distance from src to i

            // sptSet[i] will true if vertex i is included in shortest
            // path tree or shortest distance from src to i is finalized
            Boolean sptSet[] = new Boolean[V];

            // Initialize all distances as INFINITE and stpSet[] as false
            for (int i = 0; i < V; i++)
            {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 0;

            // Find shortest path for all vertices
            for (int count = 0; count < V-1; count++)
            {
                // Pick the minimum distance vertex from the set of vertices
                // not yet processed. u is always equal to src in first
                // iteration.
                int u = minDistance(dist, sptSet);

                // Mark the picked vertex as processed
                sptSet[u] = true;

                // Update dist value of the adjacent vertices of the
                // picked vertex.
                for (int v = 0; v < V; v++)

                    // Update dist[v] only if is not in sptSet, there is an
                    // edge from u to v, and total weight of path from src to
                    // v through u is smaller than current value of dist[v]
                    if (!sptSet[v] && graph[u][v]!=0 &&
                            dist[u] != Integer.MAX_VALUE &&
                            dist[u]+graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
            }

            // print the constructed distance array
            printSolution(dist, V);
        }

        // Driver method
        public static void main (String[] args)
        {

            GrafoHelper helper = new GrafoHelper();

            Digrafo digrafo4 = helper.buildGrafo(15);



            Digrafo digrafo = new Digrafo(10);
            digrafo.agregarArista(0,1, 4);
            digrafo.agregarArista(0,7, 8);
            digrafo.agregarArista(1,7, 11);
            digrafo.agregarArista(7,8, 7);
            digrafo.agregarArista(7,6, 1);
            digrafo.agregarArista(8,6, 6);
            digrafo.agregarArista(6,5, 2);
            digrafo.agregarArista(1,2, 8);
            digrafo.agregarArista(2,8, 2);
            digrafo.agregarArista(2,5, 4);
            digrafo.agregarArista(3,5, 14);
            digrafo.agregarArista(2,3, 7);
            digrafo.agregarArista(3,4, 9);
            digrafo.agregarArista(5,4, 10);


            Dijkstra dijkstra = new Dijkstra(digrafo4);

            System.out.println("Dijkstra");

            List<Integer>  result = dijkstra.getShortestPath(0,10);
            for(Integer i : result){
                System.out.println(i);
            }


            Digrafo digrafo2 = new Digrafo(5);

            digrafo2.agregarArista(0,1,-1);
            digrafo2.agregarArista(0,2,4);
            digrafo2.agregarArista(1,2,3);
            digrafo2.agregarArista(1,3,2);
            digrafo2.agregarArista(1,4,2);
            digrafo2.agregarArista(3,2,5);
            digrafo2.agregarArista(3,1,1);
            digrafo2.agregarArista(4,3,-3);

            BellmanFord bellmanFord = new BellmanFord(digrafo4);

            System.out.println("Bellman-Ford");

            List<Integer> result2 = bellmanFord.getShortestPath(0,10);
            for(Integer i : result2){
                System.out.println(i);
            }


            System.out.println("FloydWarshall");


            FloydWarshall floydWarshall = new FloydWarshall(digrafo4);


            List<Integer> result3 = floydWarshall.getShortestPath(0,10);

            for(Integer i : result2){
                System.out.println(i);
            }
        }

}
