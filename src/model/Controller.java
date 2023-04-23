package model;

import model.dataStructure.HeapNode;
import model.dataStructure.Priority;
import model.dataStructure.StandardPriority;

import java.util.ArrayList;
import java.util.Stack;

public class Controller {

    private int rows;
    private int columns;
    private int filesFirstClass;
    public Controller(int rows, int columns, int filesFirstClass) {
        this.rows = rows;
        this.columns = columns;
        this.filesFirstClass = filesFirstClass;
    }

    public String outPutOrdering(ArrayList<HeapNode<Priority, Integer>> priorities){
        priorities.add(new HeapNode<>(new StandardPriority(0,0,0,0),11));
        return "";
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
