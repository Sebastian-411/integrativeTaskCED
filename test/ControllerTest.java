import model.Controller;
import model.airplane.abstractClasses.Passenger;
import model.dataStructure.HashNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    static Controller controller;


    public void setUpStage1()  {
        controller =new Controller(23,4,5);
        try {
            controller.load("test/dataTest/data.txt");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL CARGAR");
        }


    }
    @Test
    public void loadTest(){
        setUpStage1();
        Controller controller = new Controller(12,12,2);
        HashNode<String, Passenger>[] passengers = controller.getPassengerHashTable().getListOfNodes();
        assertEquals(5, passengers.length);
        for (int i = 0; i < passengers.length; i++) {
            System.out.println(passengers[i].getKey());
        }
    }
}
