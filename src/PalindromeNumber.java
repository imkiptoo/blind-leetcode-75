import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(51315));
    }

    @Test
    public void testPalindrome(){
        assertEquals(checkPalindrome(51315), true);
        assertEquals(checkPalindrome(-121), false);
        assertEquals(checkPalindrome(-1), false);
    }

    public static boolean checkPalindrome(int num){
        int numCpy = num;
        int rev = 0;
        int len = (int)Math.log10(num) + 1;

        while(len > 0){
            int end = num % (10);
            rev = rev * 10;
            rev = rev + end;
            num = num / 10;
            len--;
        }

        return numCpy == rev;
    }
}
