package model.dataStructure.dataStructureInterface;
public interface IHashTable <K extends Comparable<K>,T> {
    public void insert(K key, T value);
    public T search(K key);
    public boolean delete(K key);
}
