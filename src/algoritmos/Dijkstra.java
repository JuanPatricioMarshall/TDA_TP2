package algoritmos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Dijkstra implements ShortestPathAlgorithm{

    
    private Digrafo digrafo;
    
    public Dijkstra(Digrafo d){

        this.digrafo = d;
    }

    @Override
    public List<Integer> getShortestPath(int src, int dest) {

        List<Integer> result = new ArrayList<Integer>();

        Map<Integer, Integer> caminos = dijkstra(src);


        result.add(dest);
        Integer actual = dest;
        while(actual != src){
            actual = caminos.get(actual);
            result.add(actual);
        }


        return result;
    }

    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < sptSet.length ; v++)
            if (!sptSet[v] && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    Map<Integer, Integer> dijkstra(Integer src)
    {
        int dist[] = new int[digrafo.getCantidadDeVertices()];

        Boolean sptSet[] = new Boolean[digrafo.getCantidadDeVertices()];

        for (int i = 0; i < digrafo.getCantidadDeVertices(); i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        Map<Integer, Integer> caminos = new HashMap<Integer, Integer>();

        for (int count = 0; count < digrafo.getCantidadDeVertices()-1; count++)
        {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;


            for (int v = 0; v < digrafo.getCantidadDeVertices(); v++)


                if (!sptSet[v] && digrafo.getAristasVertice(u).contains(v)&& dist[u] != Integer.MAX_VALUE && dist[u] + digrafo.getPesoArista(u,v) < dist[v]){
                    dist[v] = dist[u] + digrafo.getPesoArista(u,v);
                    if(caminos.get(v) != null){
                        caminos.replace(v, u);
                    }
                    else{
                        caminos.put(v,u);
                    }
            }

        }

        printArr(dist, dist.length);

        return caminos;
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertice   Distancia a la raiz");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }
}
