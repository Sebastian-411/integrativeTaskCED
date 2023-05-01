import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import model.airplane.*;
import model.airplane.abstractClasses.*;
import model.serializers.Serializer;

import java.util.*;
import java.io.*;

public class TestGenerator {

    static ArrayList<Passenger> listOfPassengers = new ArrayList<Passenger>();
    static String[] listOfNames = "Alan Jacinto Martinez Alicia Jesús Mirta Andrea Josefina Mónica Andrés Juan Nicolás Antonia Juana Noé Antonio Juárez Noelia Azul Julia Paula Bartolomé Julián Patricio Belén Juliana Renzo Celeste Julio Rodrigo Edgardo Leandro Rodríguez Felicia Luis Romina Florencia Luisa Rosario Gaspar Marcelo Tato Gerardo Marcos Tomás Giménez María Victor Gonzalo Mariano Yayo Gustavo Martín Zulema".split(" ");
    static String[] listOfLastNames = "Rodriguez Martinez Garcia Gomez Lopez Gonzalez Hernandez Sanchez Perez Ramirez Diaz Torres Muñoz Rojas Moreno Vargas Ortiz Jimenez Castro Gutierrez Alvarez Valencia Ruiz Suarez Herrera Romero Quintero Morales Giraldo Rivera Arias Florez Marin Castillo Mejia Mosquera Osorio Cardenas Cardona Peña Zapata Restrepo Guerrero Parra Mendoza Medina Ramos Salazar Correa Ortega Vasquez Montoya Cortes Acosta Guzman Londoño Molina Velasquez Rincon Rios Sierra Cruz Ospina Garzon Jaramillo Reyes Orozco Agudelo Mora Beltran Contreras Leon Escobar Caicedo Castañeda Fernandez Hurtado Delgado Silva Lozano Henao Bedoya Calderon Murillo Castaño".split(" ");
    static Scanner reader = new Scanner(System.in);
    static Random ran = new Random();
    static String folder = "data";
    static String path = "data/data.txt";

    static ArrayList<String> listOfTickets = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Generador\n");
        System.out.println("Digite la cantidad de filas que tendrá el avión");
        int rows = Integer.valueOf(reader.nextLine());
        System.out.println("Digite la cantidad de sillas que tendrá cada fila");
        int columns = Integer.valueOf(reader.nextLine());
        System.out.println("Digite la cantidad de filas designadas para primera clase");
        int firstClassRows = Integer.valueOf(reader.nextLine());


        System.out.println("Digite la cantidad total de pasajeros del avion. Recuerde que la cantidad no debe superar " + (rows*columns));
        int totalAmountPassengers = Integer.valueOf(reader.nextLine());
        System.out.println("Digite la cantidad de pasajeros de primera clase. Recuerde que la cantidad no debe superar " + (firstClassRows*columns)); 
        int firstClassPassengersAmount = Integer.valueOf(reader.nextLine());
        int passengersAmount = totalAmountPassengers - firstClassPassengersAmount;

        double proportion = passengersAmount/totalAmountPassengers;

        while (passengersAmount > 0 || firstClassPassengersAmount > 0){

            Passenger passengerToAdd = null;
            String ticket;
            int row;
            if (ran.nextDouble() > proportion && passengersAmount > 0){
                //Standard
                ticket = genStandardTicket(firstClassRows, rows, columns);
                row  = Integer.valueOf(ticket.substring(1,ticket.length()));
                StandardPriority prior = new StandardPriority(0, 0, row, 0);
                passengerToAdd = new StandardPassenger(genName(),genId(), ticket, prior);

                passengersAmount--;


            } else if (firstClassPassengersAmount > 0) {
                //Premium
                ticket = genPremiumTicket(firstClassRows, columns);
                row  = Integer.valueOf(ticket.substring(1,ticket.length()));
                FirstClassPriority prior = new FirstClassPriority(0, 0, row, 0, (((ran.nextInt(10) == 9)?0.14:0)) , (((ran.nextInt(100) == 51)?0.04:0)) ,(((ran.nextInt(100) == 9)?0.14:0)) ,(((ran.nextInt(200) == 9)?0.14:0)));
                passengerToAdd = new FirstClassPassenger(genName(),genId(), ticket, prior);
                firstClassPassengersAmount--;
            }


            listOfPassengers.add(passengerToAdd);
        }

        System.out.println(listOfPassengers.size());
        listOfPassengers.forEach(passenger -> System.out.print(passenger.getPassengerID() + " "));
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static  String genId(){
        String id = String.valueOf(ran.nextInt(1,10));
        for (int i = 0; i < 9; i++) {
            id += ran.nextInt(10);
        }
        return id;
    }

    public static  String genName(){
        String name = "";

        name =  listOfNames[ran.nextInt(listOfNames.length)] + " " + listOfLastNames[ran.nextInt(listOfLastNames.length)] ;

        return name;
    }

    public static  String genStandardTicket(int firstClassRows, int rows, int columns){
        String ticket = "";
        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        ticket += (abecedario.charAt(ran.nextInt(columns)));
        ticket += (ran.nextInt(firstClassRows ,rows)+1);

        while (listOfTickets.contains(ticket)){
            ticket = "";
            ticket += (abecedario.charAt(ran.nextInt(columns)));
            ticket += (ran.nextInt(firstClassRows ,rows)+1);
        }
        listOfTickets.add(ticket);


        return ticket;
    }

    public static  String genPremiumTicket(int rows, int columns){
        String ticket = "";
        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        ticket += (abecedario.charAt(ran.nextInt(columns)));
        ticket += (ran.nextInt(rows)+1);

        while (listOfTickets.contains(ticket)){
            ticket = "";
            ticket += (abecedario.charAt(ran.nextInt(columns)));
            ticket += (ran.nextInt(rows)+1);
        }
        listOfTickets.add(ticket);


        return ticket;
    }

    public static void save( ) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(FirstClassPassenger.class, new Serializer<FirstClassPassenger>())
                .registerTypeAdapter(FirstClassPriority.class, new Serializer<FirstClassPriority>())
                .registerTypeAdapter(StandardPassenger.class, new Serializer<StandardPassenger>())
                .registerTypeAdapter(StandardPriority.class, new Serializer<StandardPriority>()).create();
        String data = gson.toJson(listOfPassengers);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }
}