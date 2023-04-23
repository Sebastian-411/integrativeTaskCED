package model.airplane;

import model.airplane.abstractClasses.Passenger;

public class StandardPassenger extends Passenger {
    private StandardPriority priority;

    public StandardPassenger(String name, String passengerID, String ticket, StandardPriority priority) {
        super(name, passengerID, ticket);
        this.priority = priority;
    }
    @Override
    public void calculatePriority() {
        this.priority.calculatePriority();
    }
    @Override
    public void establishPunctuality(int totalPassengers, int arrivalOrder) {
        this.priority.establishPunctuality(totalPassengers,arrivalOrder);
    }
    @Override
    public void establishDistanceToCenter(int center, char column) {
        this.priority.establishDistanceToCenter(center,column);
    }

    public StandardPriority getPriority() {
        return priority;
    }

    public void setPriority(StandardPriority priority) {
        this.priority = priority;
    }


}
