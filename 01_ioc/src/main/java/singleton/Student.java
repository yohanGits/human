package singleton;

public class Student {
	private static Student student = new Student(); // 여기서는 가능
	
	private Student() {} // 이 생성자는 이제 이 클래스 안에서만 쓸 수 있음.
	
	public static Student getinstance(){
		return new Student();
	}	// 매번 다른 주소 (prototype)
	
	public static Student getInstance2(){
		return student;
	} // 계속 같은 주소 (singleton) 인스턴스 취득 방법중 하나
}
