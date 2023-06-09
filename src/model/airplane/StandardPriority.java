package model.airplane;

import model.airplane.abstractClasses.Priority;

public class StandardPriority extends Priority implements Comparable{

    public StandardPriority(double punctuality, int distanceToCenter, int row, double overallPriority) {
        super(punctuality, distanceToCenter, row, overallPriority);
    }

    @Override
    public double calculatePriority(int numSections) {
        setOverallPriority(getPunctuality() + getSection());
        return getOverallPriority();
    }

    @Override
    public int compareTo(Object o) {
        Priority toCompare = (Priority) o;
        int criteria1 = (this.getRow() - toCompare.getRow())*-1  ;
        if (criteria1 ==0  ){
            int criteria2 = (this.getDistanceToCenter() - toCompare.getDistanceToCenter())*-1 ;
            if (criteria2 == 0){
                double tem = this.getPunctuality() - toCompare.getPunctuality();
                int critereia3 = tem<0? -1:1;
                return critereia3;
            }return criteria2;
        }else return criteria1;
    }
}
