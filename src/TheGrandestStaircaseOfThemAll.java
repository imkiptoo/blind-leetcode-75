public class TheGrandestStaircaseOfThemAll {
    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static int solution(int n) {
        // Your code here
        int[] table = new int[n+1];
        table[0] = 1;
        for (int brick = 1; brick < n + 1; brick++) {
            for (int height =  n; height > brick - 1; height--) {
                table[height] += table[height - brick];
            }
        }

        return table[table.length - 1] - 1;
    }
}
