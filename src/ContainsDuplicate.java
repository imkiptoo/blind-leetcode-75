import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] values = {1,2,3,5,4};

        System.out.println(containsDuplicate(values));
    }

    public static boolean containsDuplicate(int[] values){
        boolean duplicateExists = false;
        Set<Integer> valuesSet = new HashSet<>();

        for(int i = 0; i < values.length; i++){
            if(valuesSet.contains(values[i])) {
                duplicateExists = true;
                break;
            }
            valuesSet.add(values[i]);
        }

        return duplicateExists;
    }
}