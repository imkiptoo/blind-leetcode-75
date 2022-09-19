import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
        System.out.println(isHappy(3));
    }

    public static boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> productSumsSet = new HashSet<>();
        int productSum = n;

        while(productSum != 1){
            productSum = productSumFinder(productSum);
            if(!productSumsSet.contains(productSum)){
                productSumsSet.add(productSum);
            } else {
                return false;
            }
        }

        return true;
    }

    static int productSumFinder(int productSum){
        int sum = 0;
        for(int i = 0; i < String.valueOf(productSum).length(); i++){
            int current = String.valueOf(productSum).charAt(i) - '0';
            sum += (int)Math.pow(current, 2);
        }
        return sum;
    }
}
