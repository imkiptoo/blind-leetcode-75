import java.util.HashMap;
import java.util.Scanner;

public class Braille {
    public static void main(String[] args) {
        System.out.println(solution("The quick brown fox jumps over the lazy dog"));
    }

    public static String solution(String s) {
        StringBuilder binaryResult = new StringBuilder();
        HashMap<Character, String> alphabet = new HashMap<>();

        alphabet.put('A', "100000");
        alphabet.put('B', "110000");
        alphabet.put('C', "100100");
        alphabet.put('D', "100110");
        alphabet.put('E', "100010");
        alphabet.put('F', "110100");
        alphabet.put('G', "110110");
        alphabet.put('H', "110010");
        alphabet.put('I', "010100");
        alphabet.put('J', "010110");
        alphabet.put('K', "101000");
        alphabet.put('L', "111000");
        alphabet.put('M', "101100");
        alphabet.put('N', "101110");
        alphabet.put('O', "101010");
        alphabet.put('P', "111100");
        alphabet.put('Q', "111110");
        alphabet.put('R', "111010");
        alphabet.put('S', "011100");
        alphabet.put('T', "011110");
        alphabet.put('U', "101001");
        alphabet.put('V', "111001");
        alphabet.put('W', "010111");
        alphabet.put('X', "101101");
        alphabet.put('Y', "101111");
        alphabet.put('Z', "101011");

        char[] clearTextChars = s.toCharArray();
        for(char c : clearTextChars){
            if (c == ' ') {
                binaryResult.append("000000");
            } else {
                if (Character.isUpperCase(c)) {
                    binaryResult.append("000001");
                }
                binaryResult.append(alphabet.get(Character.toUpperCase(c)));
            }
        }

        return binaryResult.toString();
    }
}
