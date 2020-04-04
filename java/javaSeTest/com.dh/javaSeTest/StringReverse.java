package javaSeTest;

public class StringReverse {

	public static void main(String[] args) {

		String a = "abcdefg";
		char[] a_char = a.toCharArray();
		String result = "";
		for (int i = a_char.length - 1; i >= 0; i--) {
			result = result + a_char[i];
		}
		System.out.print(result);
	}

}
