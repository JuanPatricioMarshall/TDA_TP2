package algoritmos;


import java.util.Random;

public class GrafoHelper {

    public Digrafo buildGrafo(Integer n){

        Digrafo digrafo = new Digrafo(n);
        Random random = new Random();

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                digrafo.agregarArista(i,j,random.nextInt(1000));
            }
        }

        return digrafo;
    }
}
