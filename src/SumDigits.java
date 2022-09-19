public class SumDigits {
	public static void main(String[] args){
		System.out.println(sumDigits2(12345));
	}

	static int sumDigits(int input){
		char[] chars = String.valueOf(input).toCharArray();

		if(chars.length > 1){
			int sum = 0;
			for(char c : chars){
				sum += Integer.parseInt(String.valueOf(c));
			}
			input = sumDigits(sum);
		}

		return input;
	}
	static int sumDigits2(int num){
		int sum = 0;

		while(sum > 9 || num > 0){
			if(num == 0){
				num = sum;
				sum = 0;
			}

			sum += num % 10;
			num = num / 10;
		}

		return sum;
	}
}
