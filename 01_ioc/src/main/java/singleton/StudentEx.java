package singleton;

public class StudentEx {
	public static void main(String[] args) {
		// public(다씀) protected () private(나만씀. 자기 클래스에서만)
		
//		Student student = new Student(); Student에서 기본생성자를 private로 했기때문에 새로 생성못함. 이제 Factory로밖에 못만듬
//		System.out.println(student);
		
		// Factory pattern > prototype
		Student student2 = Student.getinstance();
		Student student3 = Student.getinstance();
		
		System.out.println(student2);
		System.out.println(student3);
		
		// Factory > singleton
		Student student4 = Student.getInstance2();
		Student student5 = Student.getInstance2();
		
		System.out.println(student4);
		System.out.println(student5);
	}
}
