package cu.util;
import java.util.Scanner;
import cu.exception.*;
public class Common {
	static Scanner scanner = new Scanner(System.in);
	
	// int 타입 입력반환
	public static int nextInt(String text) {
		return Integer.parseInt(nextLine(text));
	}
	// 숫자 범위 지정
	public static int nextInt(String text, int from, int to) throws RangeException {
		int val = Integer.parseInt(nextLine(text));
		if(val < from || val > to) throw new RangeException(from, to);
		return val;
	}
	// String 타입 입력 반환
	public static String nextLine(String text) {
		System.out.print(text);
		return scanner.nextLine();
	}
	
}
