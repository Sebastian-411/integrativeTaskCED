package model.dataStructure;

public class StandardPassenger extends Passenger{
    private StandardPriority priority;

    public StandardPassenger(String name, String passengerID, String ticket, StandardPriority priority) {
        super(name, passengerID, ticket);
        this.priority = priority;
    }

    public StandardPriority getPriority() {
        return priority;
    }

    public void setPriority(StandardPriority priority) {
        this.priority = priority;
    }


}
