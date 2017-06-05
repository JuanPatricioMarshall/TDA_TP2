package algoritmos;

import java.util.List;
import java.util.*;
import java.lang.*;


public class BellmanFord implements ShortestPathAlgorithm{

    private Digrafo grafo;

    public BellmanFord(Digrafo d){

        this.grafo = d;
    }

    @Override
    public List<Integer> getShortestPath(int src, int dest) {
        List<Integer> result = new ArrayList<Integer>();
        try{
            Map<Integer, Integer> caminos = bellmanFord(src);

            result.add(dest);
            Integer actual = dest;
            while(actual != src){
                actual = caminos.get(actual);
                result.add(actual);
            }
        }
        catch (Exception e){
            System.out.println("Contiene ciclos negativos, asi que no puedo ecnontrar un camino minimo");
        }
        finally {
            return result;
        }
    }

    public Map<Integer, Integer> bellmanFord(int src) throws Exception {
        int V = grafo.getCantidadDeVertices(), E = grafo.getCantidadDeAristas();
        int dist[] = new int[V];

        Map<Integer, Integer> caminos = new HashMap<Integer, Integer>();


        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;


        for (int i=1; i<V; ++i)
        {
            for (Arista arista : grafo.getAristas())
            {
                int u = arista.getSrc();
                int v = arista.getDest();
                int weight = arista.getWeight();
                if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
                    dist[v] = dist[u] + weight;
                    if(caminos.get(v) != null){
                        caminos.replace(v, u);
                    }
                    else{
                        caminos.put(v,u);
                    }
                }
            }
        }


        for (Arista arista : grafo.getAristas())
        {
            int u = arista.getSrc();
            int v = arista.getDest();
            int weight = arista.getWeight();
            if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
                System.out.println("El grafo contiene ciclos de peso negativo");
                throw new Exception("Presenta ciclos negativos");
            }
        }


        return caminos;
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }

}