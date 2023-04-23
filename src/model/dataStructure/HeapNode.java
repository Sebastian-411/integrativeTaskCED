package model.dataStructure;

public class HeapNode <K extends Comparable,V> {

    private K key;

    private V valaue;


    //Constructor
    public HeapNode(K key, V vlaue) {
        this.key = key;
        this.valaue = vlaue;
    }

    //Getter and Setter

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValaue() {
        return valaue;
    }

    public void setValaue(V valaue) {
        this.valaue = valaue;
    }
}
