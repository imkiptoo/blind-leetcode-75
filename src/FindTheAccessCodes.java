public class FindTheAccessCodes {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int solution(int[] l) {
        // Your code here

        int combinations = 0;
        int[] doubles = new int[l.length];

        for( int i = 1; i < l.length-1; ++i) {
            for( int j = 0; j < i; ++j) {
                if( l[i] % l[j] == 0) {
                    ++doubles[i];
                }
            }
        }

        for( int i = 2; i < l.length; i++) {
            for( int j = 1; j < i; ++j) {
                if( l[i] % l[j] == 0) {
                    combinations += doubles[j];
                }
            }
        }

        return combinations;
    }
}
