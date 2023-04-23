package model;

import com.google.gson.Gson;
import model.airplane.abstractClasses.Passenger;
import model.airplane.abstractClasses.Priority;
import model.dataStructure.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Passenger> load(String path) throws IOException {

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

        return passengersList;
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
