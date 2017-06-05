import algoritmos.*;

import java.util.*;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

        public static void main (String[] args)
        {

            GrafoHelper helper = new GrafoHelper();


            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese cuantos nodos");
            Integer cantidadNodos = scanner.nextInt();

            System.out.println("Ingrese nodo de origen");
            Integer nodoDeOrigen = scanner.nextInt();

            System.out.println("Ingrese nodo de destino");
            Integer nodoDeDestino = scanner.nextInt();

            Digrafo digrafo = helper.buildGrafo(cantidadNodos);


            Dijkstra dijkstra = new Dijkstra(digrafo);

            System.out.println("Dijkstra");

            long startTimeDijkstra = System.nanoTime();
            List<Integer>  result = dijkstra.getShortestPath(nodoDeOrigen,nodoDeDestino);
            long endTimeDijkstra = System.nanoTime();
            double durationDijkstra = (endTimeDijkstra - startTimeDijkstra);  //divide by 1000000 to get milliseconds.
            System.out.println("Duracion de Dijstra: " + durationDijkstra/1000000000 + " segundos");
            System.out.println(" ");
            System.out.println("Camino minimo");
            System.out.println(" ");

            for(Integer i : result){
                System.out.println(i);
            }
            System.out.println(" ");

//
//            Digrafo digrafo2 = new Digrafo(5);
//
//            digrafo2.agregarArista(0,1,-1);
//            digrafo2.agregarArista(0,2,4);
//            digrafo2.agregarArista(1,2,3);
//            digrafo2.agregarArista(1,3,2);
//            digrafo2.agregarArista(1,4,2);
//            digrafo2.agregarArista(3,2,5);
//            digrafo2.agregarArista(3,1,1);
//            digrafo2.agregarArista(4,3,-3);

            BellmanFord bellmanFord = new BellmanFord(digrafo);

            System.out.println("Bellman-Ford");


            long startTimeBellman = System.nanoTime();
            List<Integer> result2 = bellmanFord.getShortestPath(nodoDeOrigen,nodoDeDestino);
            long endTimeBellman = System.nanoTime();
            double durationBellman = (endTimeBellman - startTimeBellman);  //divide by 1000000 to get milliseconds.
            System.out.println("Duracion de Bellman-Ford: " + durationBellman/1000000000 + " segundos");
            System.out.println(" ");


            System.out.println("Camino minimo");
            System.out.println(" ");


            for(Integer i : result2){
                System.out.println(i);
            }
            System.out.println(" ");


            System.out.println("FloydWarshall");


            FloydWarshall floydWarshall = new FloydWarshall(digrafo);


            long startTimeFloyd = System.nanoTime();
            floydWarshall.getShortestPath(nodoDeOrigen,nodoDeDestino);
            long endTimeFloyd = System.nanoTime();
            double durationFloyd = (endTimeFloyd - startTimeFloyd);  //divide by 1000000 to get milliseconds.
            System.out.println("Duracion de Floyd-Warshall: " + durationFloyd/1000000000 + " segundos");
            System.out.println(" ");

        }

}
