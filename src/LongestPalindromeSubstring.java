public class LongestPalindromeSubstring {
	public static void main(String[] args){
		System.out.println(longestPalindrome("babad"));
	}

	static String longestPalindrome(String input){
		if(input == null || input.length() < 1) return input;

		int start = 0, end = 0;

		char[] word = input.toCharArray();

		for(int i = 0; i < word.length; i++){
			int len1 = expandAroundCenter(word, i, i);
			int len2 = expandAroundCenter(word, i, i+1);

			int len = Math.max(len1, len2);

			if(len > end - start){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return input.substring(start, end + 1);
	}

	static int expandAroundCenter(char[] word, int left, int right){
		int L = left, R = right;

		while((L >= 0 && R < word.length) && (word[L] == word[R])){
			L--;
			R++;
		}

		return R - L - 1;
	}
}
