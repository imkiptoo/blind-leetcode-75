public class FindMid {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = binarySearch(nums, target, true);

        if(firstPosition == -1){
            return new int[]{-1, -1};
        }

        int secondPosition = binarySearch(nums, target, false);

        return new int[]{firstPosition, secondPosition};
    }

    int binarySearch(int[] nums, int target, boolean findingFirst){
        int begin = 0;
        int end = nums.length -1;

        while(begin <= end){
            int mid = (begin + end) / 2;

            if(nums[mid] == target){
                if(findingFirst){
                    if(mid == begin || nums[mid - 1] != target){
                        return mid;
                    }

                    end = mid - 1;
                } else {
                    if(mid == end || nums[mid + 1] != target){
                        return mid;
                    }

                    begin = mid + 1;
                }
            } else if(nums[mid] < target){
                begin = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            }
        }

        return -1;
    }
}