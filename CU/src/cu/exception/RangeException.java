package cu.exception;

public class RangeException extends RuntimeException{
	int from;
	int to;
	public RangeException(int from, int to) {
		super("──────────────────────※caution※──────────────────────\n"
				+"\n"
				+"           \""+from+"\"과\""+to+"\"사이의 숫자를 입력하세요\n"+
				"\n──────────────────────※caution※──────────────────────");
		this.from = from;
		this.to = to;
	}
}

