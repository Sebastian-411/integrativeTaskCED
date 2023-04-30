package ui;

import model.Controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(4, 3, 1);
        try {
            controller.load("data/data.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
