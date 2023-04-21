public class HNode <K extends Comparable<K>,T> {
    private K key;
    private T value;
    private HNode<K,T> next;
    private HNode<K,T> prev;
    
    public HNode<K, T> getPrev() {
        return prev;
    }
    public void setPrev(HNode<K, T> prev) {
        this.prev = prev;
    }
    public HNode<K, T> getNext() {
        return next;
    }
    public void setNext(HNode<K, T> next) {
        this.next = next;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public HNode(K key, T value) {
        this.key = key;
        this.value = value;
    }
    

}
