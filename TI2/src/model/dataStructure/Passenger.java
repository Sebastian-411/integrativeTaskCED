package model.dataStructure;

public abstract class Passenger {
    private String name;
    private String passengerID;
    private String ticket; //assigned place in the plane

    public Passenger(String name, String passengerID, String ticket) {
        this.name = name;
        this.passengerID = passengerID;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
