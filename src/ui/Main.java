package ui;

import model.Controller;
import testGenerator.TestGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static TestGenerator testgenerator;
    static Scanner scanner;
    static Controller controller;
    public static void main(String[] args) {
        init();
        setScenario();
    }
    public static void init(){
        testgenerator = new TestGenerator();
        scanner = new Scanner(System.in);
    }

    public static void setScenario(){
        System.out.println("Generador \n");
        System.out.println("Digite la cantidad de filas que tendrá el avión");
        int rows = Integer.valueOf(scanner.nextLine());
        System.out.println("Digite la cantidad de sillas que tendrá cada fila");
        int columns = Integer.valueOf(scanner.nextLine());
        System.out.println("Digite la cantidad de filas designadas para primera clase");
        int firstClassRows = Integer.valueOf(scanner.nextLine());
        System.out.println("Digite la cantidad total de pasajeros del avion. Recuerde que la cantidad no debe superar " + (rows*columns));
        int totalAmountPassengers = Integer.valueOf(scanner.nextLine());
        System.out.println("Digite la cantidad de pasajeros de primera clase. Recuerde que la cantidad no debe superar " + (firstClassRows*columns));
        int firstClassPassengersAmount = Integer.valueOf(scanner.nextLine());
        int passengersAmount = totalAmountPassengers - firstClassPassengersAmount;

        testgenerator.createScenario(rows, columns, firstClassRows, passengersAmount, totalAmountPassengers, firstClassPassengersAmount);
        controller = new Controller(rows,columns,firstClassRows);
    }
}
