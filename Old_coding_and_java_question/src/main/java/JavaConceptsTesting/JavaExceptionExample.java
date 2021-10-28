package JavaConceptsTesting;

public class JavaExceptionExample {
	public static void main(String args[]) {
		try {
			// code that may raise exception
			String sna = getx();
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		// rest code of the program
		System.out.println("rest of the code...");
	}

	public static String getx() {
		try {
			// code that may raise exception
			String sna = "2";
			return null;
		} catch (ArithmeticException e) {
			return "2";}
			
		finally {
			return "2";
		}
	}

}