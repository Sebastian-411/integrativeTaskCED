package model;

import com.google.gson.Gson;
import model.airplane.*;
import model.airplane.abstractClasses.*;
import model.dataStructure.*;
import java.io.*;
import java.util.*;

public class Controller {

    private int rows;
    private int columns;
    private int rowsFirstClass;
    private HashTable<String, Passenger> passengerHashTable;
    public Controller(int rows, int columns, int rowsFirstClass) {
        this.rows = rows;
        this.columns = columns;
        this.rowsFirstClass = rowsFirstClass;
    }

    public String outPutOrdering() {

        ArrayList<HeapNode<Priority, String>> priorities = new ArrayList<>();
        ArrayList<HashNode<String,Passenger>> passengers = elementList();

        for (int i = 0; i < passengers.size(); i++) {
            HeapNode<Priority, String> node = null;
            if (passengers.get(i).getValue() instanceof FirstClassPassenger){

                FirstClassPassenger firstClassPassenger = (FirstClassPassenger) passengers.get(i).getValue();
                node = new HeapNode<>(((FirstClassPassenger) passengers.get(i).getValue()).getPriority(),
                                (passengers.get(i).getValue()).getPassengerID());


            } else if (passengers.get(i).getValue() instanceof StandardPassenger) {

                StandardPassenger standardPassenger = (StandardPassenger) passengers.get(i).getValue();
                 node = new HeapNode<>(((StandardPassenger) passengers.get(i).getValue()).getPriority(),
                                (passengers.get(i).getValue()).getPassengerID());
            }

            priorities.add(node);

        }
        String chain = "";
        Heap<Priority, String> heap = new Heap<>();

        heap.assignPassengers(priorities);
        priorities = heap.heapSort();

        for (int i = priorities.size() - 1, j = 0; i >= 0; i--) {
            chain += (priorities.size() - i) + ". " + priorities.get(i).getValue() + "\n";
        }

        return chain;
    }

    private ArrayList<HashNode<String,Passenger>> elementList(){
        ArrayList<HashNode<String,Passenger>> elements = new ArrayList<>();
        for (int i = 0; i < getPassengerHashTable().getListOfNodes().length; i++) {
            if (getPassengerHashTable().getListOfNodes()[i] != null){
                collisionsElements(elements, getPassengerHashTable().getListOfNodes()[i]);
            }
        }
        return elements;
    }
    private void collisionsElements(ArrayList<HashNode<String, Passenger>> elementList, HashNode<String,Passenger> current){
        if (current == null) return;
        elementList.add(current);
        collisionsElements(elementList, current.getNext());


    }

    public String entrySort(){

        ArrayList<HashNode<String,Passenger>> passengers =elementList();
        Heap<Double, String> entryOrderPassenger = new Heap<Double, String>();
        ArrayList<HeapNode<Double,String>> heapNodes = new ArrayList<>();

        // Section Calculation.
        double sectionFirstClass = Math.ceil(getRowsFirstClass() / 10);
        double sectionStandardClass = Math.ceil((getRows()-getRowsFirstClass())/10);


        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getValue() instanceof FirstClassPassenger){

                passengers.get(i).getValue().setSection((int) sectionFirstClass);

            } else if (passengers.get(i).getValue() instanceof StandardPassenger) {
                passengers.get(i).getValue().setSection((int) sectionStandardClass);
            }

            HeapNode<Double, String > heapNode =
                    new HeapNode<>(passengers.get(i).getValue().calculatePriority(),passengers.get(i).getKey());

            heapNodes.add(heapNode);
        }

        entryOrderPassenger.assignPassengers(heapNodes);
        entryOrderPassenger.heapSort();

        String chain = "";

        for (int i = entryOrderPassenger.getList().size() - 1, j = 0; i >= 0; i--) {
            chain += (entryOrderPassenger.getList().size() - i) + ". " + entryOrderPassenger.getList().get(i).getValue() + "\n";
        }
        return chain;
    }

    public void load(String path) throws IOException {

        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String content = "";
        String line = "";
        while((line = reader.readLine()) != null){
            content += line + "\n";
        }
        Gson gson = new Gson();
        Passenger passengers [] = gson.fromJson(content, Passenger[].class);

        ArrayList<Passenger> passengersList = new ArrayList<>();
        passengersList.addAll(List.of(passengers));

        establishPriorities(passengersList);
        generatePassengersHasTable(passengersList);

    }

    public void generatePassengersHasTable(ArrayList<Passenger> passengers){
        this.passengerHashTable = new HashTable<>(passengers.size());
        for (int i = 0; i < passengers.size(); i++) {
            this.passengerHashTable.insert(passengers.get(i).getPassengerID(),passengers.get(i));
        }
    }

    public void establishPriorities(ArrayList<Passenger> passengers){
        int center =  getColumns()/2;
        int numPassengers = passengers.size();

        for (int i = 0; i < passengers.size(); i++) {
            char column = passengers.get(i).getTicket().charAt(0);
            passengers.get(i).establishDistanceToCenter(center,column);
            passengers.get(i).establishPunctuality(numPassengers,i+1 );
        }
    }

    public HashTable<String, Passenger> getPassengerHashTable() {
        return passengerHashTable;
    }

    public void setPassengerHashTable(HashTable<String, Passenger> passengerHashTable) {
        this.passengerHashTable = passengerHashTable;
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

    public int getRowsFirstClass() {
        return rowsFirstClass;
    }

    public void setRowsFirstClass(int rowsFirstClass) {
        this.rowsFirstClass = rowsFirstClass;
    }

}
