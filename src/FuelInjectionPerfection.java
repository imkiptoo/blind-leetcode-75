import java.math.BigInteger;

public class FuelInjectionPerfection {
    public static void main(String[] args) {
        System.out.println(solution("4"));
    }

    private static final BigInteger ZERO = new BigInteger("0");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger FOUR = new BigInteger("4");

    public static int solution(String x) {
        // Your code here
        BigInteger n = new BigInteger(x);
        int count = 0;
        while (n.compareTo(ONE) == 1){
            if (n.mod(TWO).equals(ONE)) {
                if (n.mod(FOUR).equals(ONE) || n.equals(THREE)) {
                    n = n.subtract(ONE);
                } else {
                    n = n.add(ONE);
                }
            } else {
                n = n.divide(TWO);
            }
            count += 1;
        }
        return count;
    }
}
