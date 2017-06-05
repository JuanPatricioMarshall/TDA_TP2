package algoritmos;


public class Arista {

    Integer src;
    Integer dest;
    Integer weight;


    public Arista(Integer src, Integer dest, Integer weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Integer getDest() {
        return dest;
    }

    void setDest(Integer dest) {
        this.dest = dest;
    }

    public Integer getSrc() {
        return src;
    }

    void setSrc(Integer src) {
        this.src = src;
    }
    public Integer getWeight() {
        return weight;
    }
}
