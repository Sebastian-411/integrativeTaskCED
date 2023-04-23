package model;

import model.dataStructure.Heap;
import model.dataStructure.HeapNode;
import model.dataStructure.Priority;

import java.util.ArrayList;

public class Controller {

    private int rows;
    private int columns;
    private int filesFirstClass;
    public Controller(int rows, int columns, int filesFirstClass) {
        this.rows = rows;
        this.columns = columns;
        this.filesFirstClass = filesFirstClass;
    }

    public String outPutOrdering(ArrayList<HeapNode<Priority, String>> priorities) {
        String chain = "";
        Heap<Priority, String> heap = new Heap<>();
        heap.assignPassengers(priorities);
        priorities = heap.heapSort();
        for (int i = priorities.size() - 1, j = 0; i >= 0; i--) {
            chain += (priorities.size() - i) + ". " + priorities.get(i).getValue() + "\n";
        }

        return chain;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getFilesFirstClass() {
        return filesFirstClass;
    }

    public void setFilesFirstClass(int filesFirstClass) {
        this.filesFirstClass = filesFirstClass;
    }

}
