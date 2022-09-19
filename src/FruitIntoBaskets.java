import java.util.*;
import java.lang.Math;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length == 0) return 0;
        if (fruits.length == 1) return 1;
        int maximum = 0;
        int tempMaximum = 0;

        int last = -1;
        int secondLast = -1;
        int lastCount = 0;

        //3,3,3,1,2,1,1,2,3,3,4

        for (int fruit : fruits) {
            boolean fruitIsLast = fruit == last;
            boolean fruitIsSecondLast = fruit == secondLast;
        }

        return maximum;
    }
}
