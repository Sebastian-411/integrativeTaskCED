package model.dataStructure;
import model.dataStructure.dataStructureInterface.IPriorityQueue;
import java.util.ArrayList;

public class Heap<K extends Comparable,V> implements IPriorityQueue<K,V> {

    private ArrayList<HeapNode<K,V>> list;

    private int heapsize;


    // Heap methods

    public void maxHeapify(){

    }

    public void buildHeap(){

    }

    public void heapSort(){

    }

    public int getFather(int position) {
        position+=1;
        if (position == 0) return 0;
        else return  position/2 -1;
    }

    public int getLeft(int position) {
        position+=1;
        return position*2 - 1 ;
    }

    public int getRigth(int position) {
        position+=1;
        return position*2;
    }

    //Priority Queue methods


    @Override
    public K heapExtractMax() {
        return null;
    }

    @Override
    public K getmaX() {
        return null;
    }

    @Override
    public void increaseKey(int position, K key) {

    }

    @Override
    public void insert(K key, V value) {

    }

    // Initial methods
    //Constructor
    public Heap() {
        heapsize = 0;
    }
    //Getters and Setters

    public ArrayList<HeapNode<K, V>> getList() {
        return list;
    }

    public void setList(ArrayList<HeapNode<K, V>> list) {
        this.list = list;
    }

    public int getHeapsize() {
        return heapsize;
    }

    public void setHeapsize(int heapsize) {
        this.heapsize = heapsize;
    }
}
