package model.dataStructure;
import model.dataStructure.dataStructureInterface.IHashTable;
import ui.Main;

import java.util.ArrayList;

public class HashTable <K extends Comparable<K>,T> implements IHashTable<K ,T> {

    public HashNode<K,T>[] listOfNodes;
    public static int ARR_SIZE;

    
    public HashTable(int m) {
        ARR_SIZE = m;
        listOfNodes = new HashNode[m];
    }



    @Override
    public void insert(K key, T value) {
        int pos = Math.abs(key.hashCode()%ARR_SIZE);
        if (listOfNodes[pos] == null) {
            listOfNodes[pos] = new HashNode<K,T>(key, value);
        } else {
            HashNode<K,T> nodeToAdd = new HashNode<K,T>(key, value);
            nodeToAdd.setNext(listOfNodes[pos]);
            listOfNodes[pos].setPrev(nodeToAdd);
            listOfNodes[pos] = nodeToAdd;
        }
    }



    @Override
    public boolean delete(K key) {
        int pos = Math.abs(key.hashCode()%ARR_SIZE);
        if (listOfNodes[pos].getKey().compareTo(key) == 0) {
            deleteNode(listOfNodes[pos], key, pos);
            return true;
        } else {
            return delete(listOfNodes[pos], key, pos);
        }
    }

    private boolean delete(HashNode<K,T> current, K key, int pos){
        if (current == null) return false ;
        if (current.getKey().compareTo(key) == 0) {
            deleteNode(current, key, pos);
            return true;
        }
        return delete(current.getNext(), key, pos);
    }

    private void deleteNode(HashNode<K,T> current, K key, int pos){
        if(current.getPrev() == null){
            HashNode<K,T> next = current.getNext();
            if (next != null) {
                next.setPrev(null);
                listOfNodes[pos] = next;
            } else {
                listOfNodes[pos] = null;
            }
            
            return;
        }
        if(current.getNext() == null){
            HashNode<K,T> prev = current.getPrev();
            prev.setNext(null);
            return;
        }
        //Delete
        HashNode<K,T> prev = current.getPrev();
        HashNode<K,T> next = current.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        return;
    }



    @Override
    public T search(K key) {
        int pos = Math.abs(key.hashCode()%ARR_SIZE);
        if (listOfNodes[pos] != null) {
            if (listOfNodes[pos].getKey().compareTo(key) == 0) {
                return listOfNodes[pos].getValue();
            } else {
                return search(listOfNodes[pos], key);
            }
        }
        return null;
    }

    private T search(HashNode<K,T> current, K key){
        if (current == null) return null ;
        if (current.getKey().compareTo(key) == 0) {
            return current.getValue();
        }
        return search(current.getNext(), key);
    }

    public String print(){
        String message = "";
        for(int i = 0; i < listOfNodes.length; i++){
            String chain = "";
            if (listOfNodes[i]  == null) chain+= i +". " + "Vacio ";
            else {
                chain += i +". " + "Key: " + (String)listOfNodes[i].getKey() + " | C: ";
                if (listOfNodes[i].getNext() != null) chain += chainCollitions(listOfNodes[i].getNext());
            }
            chain += "\n";
            message += chain;
        }
        return message;
    }

    public String printValue(){
        String message = "";
        for(int i = 0; i < listOfNodes.length; i++){
            String chain = "";
            if (listOfNodes[i]  == null) chain+= i +". " + "Vacio ";
            else {
                chain += i +". " + "Key: " + (String)listOfNodes[i].getKey() + " Value: " + String.valueOf(listOfNodes[i].getValue()) +" | C: ";
                if (listOfNodes[i].getNext() != null) chain += chainCollitions(listOfNodes[i].getNext());
            }
            chain += "\n";
            message += chain;
        }
        return message;
    }

    private String chainCollitions(HashNode<K,T> current){
        if (current == null) return "";
        String chain = (String) current.getKey();
        return chain +" "+ chainCollitions(current.getNext());
    }

    public HashNode<K, T>[] getListOfNodes() {
        return listOfNodes;
    }

    public void setListOfNodes(HashNode<K, T>[] listOfNodes) {
        this.listOfNodes = listOfNodes;
    }

    public static int getArrSize() {
        return ARR_SIZE;
    }

    public static void setArrSize(int arrSize) {
        ARR_SIZE = arrSize;
    }
}