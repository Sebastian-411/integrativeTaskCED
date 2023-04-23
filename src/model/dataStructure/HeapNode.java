package model.dataStructure;

public class HeapNode <K extends Comparable,V> {

    private K key;

    private V value;


    //Constructor
    public HeapNode(K key, V vlaue) {
        this.key = key;
        this.value = vlaue;
    }

    //Getter and Setter

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
