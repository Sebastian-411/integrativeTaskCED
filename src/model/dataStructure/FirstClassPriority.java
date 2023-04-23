package model.dataStructure;

public class FirstClassPriority extends Priority implements Comparable{

    double pregnant;
    double miles;
    double thirdAge;
    double specialAttention;

    public FirstClassPriority(double punctuality, int distanceToCenter, int row, double overallPriority,
                              double pregnant, double miles, double thirdAge, double specialAttention) {
        super(punctuality, distanceToCenter, row, overallPriority);
        this.pregnant = pregnant;
        this.miles = miles;
        this.thirdAge = thirdAge;
        this.specialAttention = specialAttention;
    }
    @Override
    public void overallPriority() {
    }
    @Override
    public int compareTo(Object o) {
        Priority toCompare = (Priority) o;
        int criteria1 = this.getRow() - toCompare.getRow()  ;
        if (criteria1 ==0  ){
            int criteria2 = toCompare.distanceToCenter - this.getDistanceToCenter() ;
            if (criteria2 == 0){
                double tem =   this.getPunctuality() - toCompare.getPunctuality();
                int critereia3 = tem<0? -1:1;
                return critereia3;
            }return criteria2;
        }else return criteria1;
    }
}
