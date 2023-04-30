package model.airplane;

import com.google.gson.*;
import model.airplane.abstractClasses.Passenger;

import java.lang.reflect.Type;

public class FirstClassPassenger extends Passenger {
    private FirstClassPriority priority;

    public FirstClassPassenger(String name, String passengerID, String ticket, FirstClassPriority priority) {
        super(name, passengerID, ticket);
        this.priority = priority;
    }

    @Override
    public void setSection(int sectionFirstClass) {
        this.getPriority().setSection(sectionFirstClass);
    }

    @Override
    public double calculatePriority(int numSections) {
        return this.priority.calculatePriority(numSections);
    }
    @Override
    public void establishPunctuality(int totalPassengers, int arrivalOrder) {
        this.priority.establishPunctuality(totalPassengers,arrivalOrder);
    }
    @Override
    public void establishDistanceToCenter(int center, char column) {
        this.priority.establishDistanceToCenter(center,column);
    }

    public FirstClassPriority getPriority() {
        return priority;
    }

    public void setPriority(FirstClassPriority priority) {
        this.priority = priority;
    }
}
