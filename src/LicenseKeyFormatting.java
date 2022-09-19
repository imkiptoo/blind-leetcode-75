public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("AB-DEFG-HIJK", 6));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder alphaNumericOnly = new StringBuilder();
        char[] licenseChars = s.toCharArray();

        for(char c : licenseChars){
            if(c != '-'){
                alphaNumericOnly.append(String.valueOf(c));
            }
        }

        //AB-DEFG-HIJK

        int start = 0;

        alphaNumericOnly.reverse();

        for(int i = k; i < alphaNumericOnly.toString().length(); i+=(k + 1)){
            alphaNumericOnly.insert(i, "-");
        }

        return alphaNumericOnly.reverse().toString();
    }
}
