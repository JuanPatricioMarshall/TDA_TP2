package algoritmos;


import java.util.List;
// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
import java.util.*;
import java.lang.*;


public class FloydWarshall implements ShortestPathAlgorithm {

    private Digrafo grafo;


    public FloydWarshall(Digrafo d){
        this.grafo = d;
    }

    @Override
    public List<Integer> getShortestPath(int src, int dest) {
        List<Integer> result = new ArrayList<Integer>();

        Map<Integer, Integer> caminos = floydWarshall();


        result.add(dest);
        Integer actual = dest;
        while(actual != src){
            actual = caminos.get(actual);
            result.add(actual);
        }


        return result;
    }

        void printSolution(int dist[][])
        {
            System.out.println("Following matrix shows the shortest "+
                    "distances between every pair of vertices");
            for (int i=0; i<dist.length; ++i)
            {
                for (int j=0; j<dist.length; ++j)
                {
                    if (dist[i][j]== 99999)
                        System.out.print("INF ");
                    else
                        System.out.print(dist[i][j]+"   ");
                }
                System.out.println();
            }
        }



    private boolean negativeCycle;



    public boolean hasNegativeCycle() {
        return this.negativeCycle;
    }



    public Map<Integer, Integer> floydWarshall() {
        int distance[][] = new int[grafo.getCantidadDeVertices()][grafo.getCantidadDeVertices()];


        Map<Integer, Integer> caminos = new HashMap<Integer, Integer>();


        for (int i = 0; i < grafo.getCantidadDeVertices(); i++) {
            for (int j = 0; j < grafo.getCantidadDeVertices(); j++) {
                distance[i][j] = 99999;
            }
        }

        List<Arista> aristas = grafo.getAristas();

        for(Arista arista : aristas){
            distance[arista.getSrc()][arista.getDest()] = arista.getWeight();
        }



        for (int k = 0; k < grafo.getCantidadDeVertices(); k++) {
            for (int i = 0; i < grafo.getCantidadDeVertices(); i++) {
                for (int j = 0; j < grafo.getCantidadDeVertices(); j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        if(caminos.get(i) != null){
                            caminos.replace(i, k);
                        }
                        else{
                            caminos.put(i,k);
                        }
                    }
                }
            }

            if (distance[k][k] < 0.0) {
                this.negativeCycle = true;
            }
        }

        printSolution(distance);



        return caminos;
        }

}
