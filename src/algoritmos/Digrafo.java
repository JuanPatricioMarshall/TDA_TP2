package algoritmos;

import java.util.*;


public class Digrafo {

    Integer cantidadDeVertices;
    Integer cantidadDeAristas;

    List<Map<Integer,Arista>> vertices;

    public Digrafo(Integer cantidadDeVertices){

        this.cantidadDeVertices = cantidadDeVertices;
        vertices = new ArrayList<Map<Integer,Arista>>();

        for(int i = 0; i < cantidadDeVertices; i ++){
            Map<Integer,Arista> aristas = new HashMap<Integer, Arista>();
            vertices.add(aristas);
        }
        cantidadDeAristas = 0;
    }

    public Integer getCantidadDeVertices(){
        return cantidadDeVertices;
    }
//
    public Integer getCantidadDeAristas(){
        return cantidadDeAristas;
    }
//
    public void agregarArista(Integer u, Integer v, Integer peso){
        if(vertices.get(u).containsKey(v)){
            return;
        }
        Arista arista = new Arista(u, v, peso);
        vertices.get(u).put(v, arista);
        cantidadDeAristas ++;

    }

    public Set<Integer> getAristasVertice(Integer verticeE){
        return  vertices.get(verticeE).keySet();
    }

    public Integer getPesoArista(Integer src, Integer dest){
        return vertices.get(src).get(dest).getWeight();
    }

    public List<Arista> getAristas(){
        List<Arista> result = new ArrayList<Arista>();

        for(Map<Integer,Arista> vertice : vertices){
            Set<Integer> keys = vertice.keySet();
            for(Integer key : keys){
                result.add(vertice.get(key));
            }
        }

        return result;
    }

}
