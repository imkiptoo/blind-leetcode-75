public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        int[][] mat = {
            {0,1,1},
            {1,1,0},
            {0,0,1},
        };

        int[][] target = {
            {1,0,1},
            {1,1,0},
            {1,1,0},
        };

        System.out.println("Matrix");
        printArray(mat);
        boolean found = findRotation(mat, target);
        System.out.println("Matrix");
        printArray(mat);
        System.out.println(found);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int rotations = 0;
        while (rotations < 4){
            boolean equal = true;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if(mat[i][j] != target[i][j]){
                        equal = false;
                    }
                }
            }
            if(!equal){
                rotateMethod2(mat);
            } else {
                return true;
            }
            rotations++;
        }
        return false;
    }

    static void rotate(int[][] mat){
        int left = 0, right = mat.length - 1;
        while (left < right){
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;
                int topLeft = mat[top][left + i];

                mat[top][left + i] = mat[bottom - i][left];
                mat[bottom - i][left] = mat[bottom][right - i];
                mat[bottom][right - i] = mat[top + i][right];
                mat[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }

    static int[][] rotateMethod2(int[][] mat){
        int[][] arr = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int tempLen = arr.length - (i + 1);
                arr[i][tempLen] = mat[i][j];
            }
        }

        return arr;
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
