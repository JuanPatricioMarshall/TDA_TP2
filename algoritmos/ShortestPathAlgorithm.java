package algoritmos;

import java.util.List;

public interface ShortestPathAlgorithm {

    /**
     * Devuelve el camino mínimo entre dos vértices del grafo.
     *
     * @param   srcId   el id del vértice de origen.
     * @param   destId  el id del vértice de destino.
     * @return  una lista con los vértices que conforman el camino, incluyendo
     *          el origen y el destino.
     * @throws IllegalArgumentException si algún id de vértice es inválido.
     */
    public List<Integer> getShortestPath(int src, int dest);

}

