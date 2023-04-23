package model.dataStructure.dataStructureInterface;

public interface IPriorityQueue<K extends Comparable,V> {

    K heapExtractMax ();
    K getmaX ();
    String increaseKey(int position, K key);
    void insert (K key,V value);

}
