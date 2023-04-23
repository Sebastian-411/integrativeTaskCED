

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
        return 0;
    }
}
