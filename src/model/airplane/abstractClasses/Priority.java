package model.airplane.abstractClasses;

public abstract class Priority implements Comparable{
    private double punctuality;
    private int distanceToCenter;
    private int row;
    private double overallPriority;
    private int section;

    public Priority(double punctuality, int distanceToCenter, int row, double overallPriority) {
        this.punctuality = punctuality;
        this.distanceToCenter = distanceToCenter;
        this.row = row;
        this.overallPriority = overallPriority;
    }
    abstract public void calculatePriority();

    public void establishPunctuality(int totalPassengers, int arrivalOrder){
        this.punctuality = (1 - (arrivalOrder/ totalPassengers)) * 0.5;
    };

    public void establishDistanceToCenter(int center,char column){
        int ascii = column - 64;
        center = ascii > center? center+1: center;
        int distance = Math.abs(center - ascii);
        this.distanceToCenter = distance;
    }

    public double getOverallPriority() {
        return overallPriority;
    }

    public void setOverallPriority(double overallPriority) {
        this.overallPriority = overallPriority;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public double getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(double punctuality) {
        this.punctuality = punctuality;
    }

    public int getDistanceToCenter() {
        return distanceToCenter;
    }

    public void setDistanceToCenter(int distanceToCenter) {
        this.distanceToCenter = distanceToCenter;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
