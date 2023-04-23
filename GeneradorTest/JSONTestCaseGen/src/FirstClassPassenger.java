public class FirstClassPassenger extends Passenger{
    private FirstClassPriority priority;

    public FirstClassPassenger(String name, String passengerID, String ticket, FirstClassPriority priority) {
        super(name, passengerID, ticket);
        this.priority = priority;
    }

    public FirstClassPriority getPriority() {
        return priority;
    }

    public void setPriority(FirstClassPriority priority) {
        this.priority = priority;
    }
}
