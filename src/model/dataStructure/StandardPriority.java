package model.dataStructure;

public class StandardPriority extends Priority implements Comparable{

    public StandardPriority(double punctuality, int distanceToCenter, int row, double overallPriority) {
        super(punctuality, distanceToCenter, row, overallPriority);
    }

    @Override
    public void overallPriority() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
