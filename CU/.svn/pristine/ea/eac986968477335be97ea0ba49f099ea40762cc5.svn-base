package cu.vo;

public class Product {
	private int no;
	// 물건 이름
	private String name;
	// 물건 가격
	private int price;
	// 물건 개수
	private int ea;
	
	
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product() {}
	
	
	public Product(int no, String name, int price, int ea) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.ea = ea;
	}
	public Product(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	
	public Product(String name, int ea, int income) {
		super();
		this.name = name;
		this.ea = ea;
	}


	public void printmenu() {
		System.out.println("******************************************");
		System.out.println("        상      품      목     록        ");
		System.out.println("******************************************");

	}
	
	@Override
	public String toString() {
		 String str =  String.format("%5d  %-10s %5d %3d",
				no, name, price, ea);
		 return str;
	}


}
