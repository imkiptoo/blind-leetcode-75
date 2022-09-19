import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 4};
        int target = 10;

        int[] sums = twoSumV3(nums, target);

        if(sums != null){
            for (int i = 0; i < sums.length; i++) {
                System.out.print(sums[i]+(i < sums.length-1 ? ", " : ""));
            }
        }
    }

    public static int[] twoSumV3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static int[] twoSumV2(int[] nums, int target) {
        int[] rVal = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i){
                rVal[0] = i;
                rVal[1] = map.get(complement);

                return rVal;
            }
        }

        return null;
    }

    public static int[] twoSumV1(int[] nums, int target) {
        int[] rVal = new int[2];

        //1, 2, 5, 3, 4



        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    rVal[0] = i;
                    rVal[1] = j;
                    return rVal;
                }
            }
        }

        return null;
    }


}
