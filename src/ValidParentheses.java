import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParentheses {
    public static void main(String[] args){
        String word = "()()()";
        System.out.println(validate(word));
    }

    private static boolean validate(String word) {
        char[] wordChars = word.toCharArray();
        int diff = 0;

        for(char c : wordChars){
            if(c == '('){
                diff++;
            } else {
                if(diff == 0){
                    return false;
                } else {
                    diff--;
                }
            }
        }

        return diff == 0;
    }

    @Test
    public void correctSyntaxTest(){
        assertEquals(validate("()()()"), true);
        //assertEquals(validate("()()()("), true);
        assertEquals(validate(""), true);

        Assertions.assertArrayEquals(new int[]{1,2,3,4}, new int[]{1,2,3,4});

        Assertions.assertEquals("Hello", "World");
    }
}
