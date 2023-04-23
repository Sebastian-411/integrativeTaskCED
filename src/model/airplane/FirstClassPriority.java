package model.airplane;

import model.airplane.abstractClasses.Priority;

public class FirstClassPriority extends Priority implements Comparable{

    private double pregnant;
    private double miles;
    private double thirdAge;
    private double specialAttention;

    public FirstClassPriority(double punctuality, int distanceToCenter, int row, double overallPriority,
                              double pregnant, double miles, double thirdAge, double specialAttention) {
        super(punctuality, distanceToCenter, row, overallPriority);
        this.pregnant = pregnant;
        this.miles = miles;
        this.thirdAge = thirdAge;
        this.specialAttention = specialAttention;
    }
    @Override
    public void calculatePriority() {
        setOverallPriority( getSection() +  getMiles() + getSpecialAttention() + getPregnant() + getThirdAge());
    }
    @Override
    public int compareTo(Object o) {
        Priority toCompare = (Priority) o;
        int criteria1 = this.getRow() - toCompare.getRow()  ;
        if (criteria1 ==0  ){
            int criteria2 = toCompare.getDistanceToCenter() - this.getDistanceToCenter() ;
            if (criteria2 == 0){
                double tem =   this.getPunctuality() - toCompare.getPunctuality();
                int critereia3 = tem<0? -1:1;
                return critereia3;
            }return criteria2;
        }else return criteria1;
    }

    public double getPregnant() {
        return pregnant;
    }

    public void setPregnant(double pregnant) {
        this.pregnant = pregnant;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getThirdAge() {
        return thirdAge;
    }

    public void setThirdAge(double thirdAge) {
        this.thirdAge = thirdAge;
    }

    public double getSpecialAttention() {
        return specialAttention;
    }

    public void setSpecialAttention(double specialAttention) {
        this.specialAttention = specialAttention;
    }
}
