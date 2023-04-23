package model.dataStructure;

public abstract class Priority implements Comparable{
    double punctuality;
    int distanceToCenter;
    int row;
    double overallPriority;

    public Priority(double punctuality, int distanceToCenter, int row, double overallPriority) {
        this.punctuality = punctuality;
        this.distanceToCenter = distanceToCenter;
        this.row = row;
        this.overallPriority = overallPriority;
    }
    abstract public void overallPriority();

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
