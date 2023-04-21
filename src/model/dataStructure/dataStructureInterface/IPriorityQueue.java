package model.dataStructure.dataStructureInterface;

public interface IPriorityQueue<K extends Comparable,V> {

    K heapExtractMax ();
    K getmaX ();
    void increaseKey(int position, K key);
    void insert (K key,V value);

}
