public class Factorial {
	public static void main(String[] args){
		System.out.println("Factorial: "+ factorial(8));
	}

	static int factorial(int n) {
		int fact = 1;
		for (int v = 1; v <= n; v++) {
			fact = fact * v;
		}
		return fact;
	}
}
