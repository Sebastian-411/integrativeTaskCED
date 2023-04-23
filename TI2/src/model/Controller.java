package model;

import model.dataStructure.*;
import model.dataStructure.dataStructureInterface.IPriorityQueue;

import java.util.ArrayList;

public class Controller {

    private int rows;
    private int columns;
    private int filesFirstClass;
    private HashTable<String, Passenger> passengersTable;
    public Controller(int rows, int columns, int filesFirstClass) {
        this.rows = rows;
        this.columns = columns;
        this.filesFirstClass = filesFirstClass;
    }

    public String outPutOrdering(ArrayList<HeapNode<Priority, Integer>> priorities){
        priorities.add(new HeapNode<>(new StandardPriority(0,0,0,0),11));
        return "";
    }

    public ArrayList<Passenger> load(){








        return  null;
    }

    public void entrySort(){



        ArrayList<Passenger> listOfPassengers = load();

        Heap<Double, String> entryOrderPassenger = new Heap<Double, String>();

        ArrayList<HeapNode<Double, String>> chairsList = new ArrayList<HeapNode<Double, String>>();

        for (int i = 0; i < listOfPassengers.size(); i++) {

            if (listOfPassengers.get(i) instanceof FirstClassPassenger){
                chairsList.add( new HeapNode<>( (  (FirstClassPassenger) listOfPassengers.get(i)).getPriority().getOverallPriority() ,listOfPassengers.get(i).getPassengerID() ) );
            } else  {
                chairsList.add( new HeapNode<>( (  (StandardPassenger) listOfPassengers.get(i)).getPriority().getOverallPriority() , listOfPassengers.get(i).getPassengerID() ) );
            }

        }

        entryOrderPassenger.assignPassengers(chairsList);

            entryOrderPassenger.heapSort();




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

    public HashTable<String, Passenger> getPassengersTable() {
        return passengersTable;
    }

    public void setPassengersTable(HashTable<String, Passenger> passengersTable) {
        this.passengersTable = passengersTable;
    }

}
