package cu.vo;



public class Customer {
	//회원 ID,PW
	private String id;
	private String pw;
	// 회원 번호
	private int no;
	// 회원 나이
	private int age;
	// 회원 이름
	private String name;
	// 회원 보유금
	private int money;
	
	private String ban;
	private boolean admin;
	private Customer banlist;
	
	//기본 생성자
	public Customer() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Customer ModifiySetId(String id) {
		this.id = id;
		return null;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	

	public Customer getBanlist() {
		return banlist;
	}

	public void setBanlist(Customer banlist) {
		this.banlist = banlist;
	}

	//사용자용 회원가입
	public Customer(int no,String id, String pw,int age, String name, int money) {
		super();
		this.id = id;
		this.pw = pw;
		this.no = no;
		this.age = age;
		this.name = name;
		this.money = money;
		this.admin=false;
	}
	//관리자용 회원가입
	public Customer(int no,String id, String pw,int age, String name, int money, boolean admin) {
		super();
		this.id = id;
		this.pw = pw;
		this.no = no;
		this.age = age;
		this.name = name;
		this.money = money;
		this.admin = admin;
	}
	
	
	
	// 로그인시 관리자, 사용자 확인용  // 21.08.06 이유림
	public Customer(String id, String pw, boolean admin) {
		super();
		this.id = id;
		this.pw = pw;
		this.admin = admin;
	}

	@Override
	public String toString() {
		String str=String.format("%4d 	%4s	%4s	%4d	%4s	%4d %4b",no,id,pw,age,name,money,admin);
		return str;
	}




}

		
	

