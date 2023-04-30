package model.dataStructure;
import model.dataStructure.dataStructureInterface.IPriorityQueue;
import java.util.ArrayList;

public class Heap<K extends Comparable,V> implements IPriorityQueue<K,V> {

    private ArrayList<HeapNode<K,V>> list;

    private int heapSize;

    // Heap methods

    public void maxHeapify(int from){
        int left  = getLeft(from);
        int right  = getRigth(from);
        int largest = from;

        if (left < heapSize){
            if (  list.get(left).getKey().compareTo(list.get(from).getKey()) > 0 )largest = left;
        }

        if (right < heapSize){
            if (  list.get(right).getKey().compareTo(list.get(largest).getKey()) > 0 ) largest = right;
        }

        if (largest != from){
            HeapNode temporal = list.get(from);
            list.set(from, list.get(largest));
            list.set(largest, temporal);
            maxHeapify(largest);
        }
    }

    public void buildHeap(){
        this.heapSize = list.size();
        for (int i = (list.size() /2) -1; i >=0 ; i--) {
            maxHeapify(i);
        }
    }
    /**
     * It´s worth to say when the heapsort is applied,  the list attribute is not a heap anymore, thus,
     * the heapSize is changed to 0.
     */
    public ArrayList<HeapNode<K, V>> heapSort(){
        buildHeap();
        for (int i = list.size()-1; i >= 1 ; i--) {
            HeapNode temporal = list.get(0);
            list.set(0,list.get(i));
            list.set(i, temporal);
            heapSize-=1;
            maxHeapify(0);
        }
        return list;
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
        if (heapSize < 0 ) return null;
        K max = list.get(0).getKey();
        list.set(0, list.get(heapSize-1));
        heapSize --;
        maxHeapify(0);
        return max;
    }

    /**
     * It returns the highest key as long as the buildHeap or heapSort methods have been applied.
     * @return
     */
    @Override
    public K getmaX() {
        return list.get(0).getKey();
    }

    @Override
    public String increaseKey(int position, K key) {
        if (key.compareTo(list.get(position).getKey()) < 0) {
            return "Not incrementing priority";
        }
        list.get(position).setKey(key);

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0 ){

            HeapNode temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
        return "Increment done";
    }

    /**
     * This method is partially illegal, due to, it inserts a Node at last with a key not necessary lower
     * than the rest of the "tree", however, it's done in this way to continue with the generic implementation.
     * @param key
     * @param value
     */
    @Override
    public void insert(K key, V value) {
        heapSize ++;
        list.add(new HeapNode<>(key, value));
        int position = heapSize;

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0 ){

            HeapNode temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
    }

    //Initial methods
    //Constructor
    public Heap() {
        heapSize = 0;
    }
    //Getters and Setters

    public ArrayList<HeapNode<K, V>> getList() {
        return list;
    }

    public void setList(ArrayList<HeapNode<K, V>> list) {
        this.list = list;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}
