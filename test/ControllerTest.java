import model.Controller;
import model.airplane.FirstClassPassenger;
import model.airplane.FirstClassPriority;
import model.airplane.StandardPassenger;
import model.airplane.StandardPriority;
import model.airplane.abstractClasses.Passenger;
import model.dataStructure.HashNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    static Controller controller;

    static ArrayList<Passenger> passengers;


    public void setUpStage1()  {
        controller =new Controller(23,4,5);
        try {
            controller.load("test/dataTest/data.txt");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL CARGAR");
        }
    }

    public void setUpStage2(){
        controller = new Controller(10,5,3);
        passengers = new ArrayList<>();
        passengers.add(new StandardPassenger("Kevin","1", "A5",
                new StandardPriority(0,0,5,0)));
        passengers.add(new StandardPassenger("Ricardo","2", "E7",
                new StandardPriority(0,0,7,0)));
        passengers.add(new FirstClassPassenger("Juan","3","C1",
                new FirstClassPriority(0.0,0,1, 0,0.2,0.2,0,0)));
        passengers.add(new FirstClassPassenger("Alejo","4","D3",
                new FirstClassPriority(0.0,0,3, 0,0,0,0.2,0.15)));
    }

    public void setUpStage3(){
        controller = new Controller(24,5,5);
        passengers = new ArrayList<>();
        passengers.add(new StandardPassenger("Kevin","10", "A10",
                new StandardPriority(0,0,10,0)));
        passengers.add(new StandardPassenger("Ricardo","2", "E22",
                new StandardPriority(0,0,22,0)));
        passengers.add(new FirstClassPassenger("Juan","","C4",
                new FirstClassPriority(0.0,0,4, 0,0.2,0.2,0,0)));
        passengers.add(new FirstClassPassenger("Alejo","4","D1",
                new FirstClassPriority(0.0,0,1, 0,0,0,0.2,0.15)));
    }

    public void setUpStage4(){
        controller =new Controller(23,4,5);
        try {
            controller.load("test/dataTest/sectionEntryConflict.txt");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL CARGAR");
        }
    }
    @Test
    public void sectionAssigmentTest(){
        setUpStage3();
        controller.sectionCalculationAndAssignment(passengers);

        assertEquals(5,((StandardPassenger) passengers.get(0)).getPriority().getSection());
        assertEquals(11,((StandardPassenger) passengers.get(1)).getPriority().getSection());
        assertEquals(4,((FirstClassPassenger) passengers.get(2)).getPriority().getSection());
        assertEquals(1,((FirstClassPassenger) passengers.get(3)).getPriority().getSection());
    }

    @Test
    public void establishPrioritiesTest(){

        setUpStage2();
        controller.establishPriorities(passengers);

        //Punctuality:

        assertEquals(((1- (double) 1/4)*0.5), ((StandardPassenger)passengers.get(0)).getPriority().getPunctuality() );
        assertEquals(((1-(double) 2/4)*0.5), ((StandardPassenger)passengers.get(1)).getPriority().getPunctuality() );
        assertEquals(((1-(double)3/4)*0.5), ((FirstClassPassenger)passengers.get(2)).getPriority().getPunctuality() );
        assertEquals(((1-(double)4/4)*0.5), ((FirstClassPassenger)passengers.get(3)).getPriority().getPunctuality() );

        //Distance to Center:

        assertEquals(2,((StandardPassenger) passengers.get(1)).getPriority().getDistanceToCenter());
        assertEquals(0,((FirstClassPassenger) passengers.get(2)).getPriority().getDistanceToCenter());
        assertEquals(1,((FirstClassPassenger) passengers.get(3)).getPriority().getDistanceToCenter());

    }
    @Test
    public void entrySortDifferentRows(){
        setUpStage1();
        System.out.println(controller.entrySort());
    }
    @Test
    public void entrySortSectionsConflicts(){
        setUpStage4();
        assertEquals("1. 1\n2. 2\n3. 5\n4. 3\n5. 4",
                controller.entrySort().trim());
    }
    @Test
    public void compareStandardPriorities(){

        StandardPriority standardPriority = new StandardPriority(0.5,2,10,20);
        StandardPriority standardPriority2 = new StandardPriority(0.3,0,10,20);
        int compare = standardPriority2.compareTo(standardPriority);

        assertEquals(true, compare >0);

        StandardPriority standardPriority3 = new StandardPriority(0.5,2,15,20);
        StandardPriority standardPriority4 = new StandardPriority(0.3,0,10,20);
        compare = standardPriority3.compareTo(standardPriority4);

        assertEquals(false, compare >0);

        StandardPriority standardPriority5 = new StandardPriority(0.5,2,10,20);
        StandardPriority standardPriority6 = new StandardPriority(0.2,2,10,20);
        compare = standardPriority5.compareTo(standardPriority6);

        assertEquals(true, compare >0);

        compare = standardPriority6.compareTo(standardPriority5);

        assertEquals(true, compare <0);

    }
    @Test public void outPutOrderingSectionConflicts(){
        setUpStage4();
        assertEquals("1. 2\n2. 1\n3. 3\n4. 4\n5. 5",
                controller.outPutOrdering().trim());
    }

    @Test public void outPutOrdering(){
        setUpStage1();
        assertEquals("1. 1\n2. 2\n3. 3\n4. 4\n5. 5",
                controller.outPutOrdering().trim());
    }

    @Test
    public void loadTest(){
        setUpStage1();
        ArrayList<HashNode<String, Passenger>> passengerArrayList = controller.elementList();
        assertEquals(5, passengerArrayList.size());
    }
}
