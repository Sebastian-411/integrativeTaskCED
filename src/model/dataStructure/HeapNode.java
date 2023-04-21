package model.dataStructure;

public class HeapNode <K extends Comparable,V> {

    private K key;

    private V vlaue;


    //Constructor
    public HeapNode(K key, V vlaue) {
        this.key = key;
        this.vlaue = vlaue;
    }

    //Getter and Setter

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVlaue() {
        return vlaue;
    }

    public void setVlaue(V vlaue) {
        this.vlaue = vlaue;
    }
}
