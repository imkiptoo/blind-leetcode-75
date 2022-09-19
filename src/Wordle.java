import java.util.HashSet;

public class Wordle {
    static String secretWord = "ANVIL";

    public static void main(String[] args) {
        System.out.println(validateWordle("ANVIL"));
    }

    static String validateWordle(String userInput){
        StringBuilder output = new StringBuilder();


        char[] userInputChars = userInput.toCharArray();
        char[] secretWordChars = secretWord.toCharArray();
        HashSet<Character> set = new HashSet<>();

        for(char c : secretWordChars){
            set.add(c);
        }

        for(int i = 0; i < secretWordChars.length; i++){
            if(userInputChars[i] == secretWordChars[i]){
                output.append("G");
            } else if(set.contains(userInputChars[i])){
                output.append("Y");
            } else {
                output.append("R");
            }
        }

        return output.toString();
    }
}
