public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 45, 54, 65, 76}, 11));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int mid = (first + last) / 2;

        while(first <= last){
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                last = mid - 1;
            } else if(nums[mid] < target){
                first = mid + 1;
            }

            mid = (first + last) / 2;
        }

        return mid + 1;
    }
}
