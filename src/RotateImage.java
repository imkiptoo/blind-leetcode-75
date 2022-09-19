import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };

        printArray(arr);
        System.out.println();
        rotate(arr);
        printArray(arr);
    }

    static void rotate(int[][] arr){
        int left = 0, right = arr.length - 1;

        while(left < right){
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;

                int topLeft = arr[top][left + i];

                arr[top][left + i] = arr[bottom - i][left];
                arr[bottom - i][left] = arr[bottom][right - i];
                arr[bottom][right - i] = arr[top + i][right];
                arr[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }

    static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
