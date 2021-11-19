package cu.service;

import static cu.util.Common.*;
import static cu.util.Common2.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cu.exception.RangeException;
import cu.vo.Customer;
import cu.vo.Inventory;
import cu.vo.Product;

public class ServiceImpl implements Service {
	// 회원번호 1부터 시작
	int no = 1;
	/**
	 * @author 오석호 (재고 리스트에서 품목별 구분을 위한 상수배열)
	 */
	final String[] P_TYPES = { "Drink", "Tobacco", "Fastfood", "Snack" };
	/**
	 * @author 오석호 (재고 리스트)
	 */
	List<Product> inventories = new Inventory().getInventories();
	/*
	 * 손요한 21.08.06 팔린풀품통계 리스트
	 */
	List<Product> statistics = new ArrayList<Product>();
	// 곽승협 회원 가입용 어레이 리스트 추가 08.01
	List<Customer> customers = new ArrayList<Customer>();
	/**
	 * @author 오석호
	 * (현재 접속자)
	 * */
	List<Customer> currentAccessor = new ArrayList<Customer>();
	
	{ // customer에서 custoners로 수정 21.08.06 이유림
		try {
			loadCustomerInformation();
			loadProductInformation();
		} catch (Exception e) {
			customers.add(new Customer(no++, "admin", "1234", 25, "관리자", 1000000, true));
			customers.add(new Customer(no++, "user", "1234", 30, "test1", 1000000));
			customers.add(new Customer(no++, "1111", "1111", 30, "관리자", 1000000, true));
			customers.add(new Customer(no++, "2222", "2222", 18, "홍길동", 10000, false));
		}

	}
	/**
	 * @author 오석호
	 * (어드민)
	 * 0번 고정
	 * */
	Customer admin = customers.get(0);

	/*
	 * 손요한 21.07.30 관리자 물품 조회 메소드
	 */
	public void list() {
		int a = kind() - 1;
		for (Product p : inventories) {
			if (p.getClass().getSimpleName().equals(P_TYPES[a])) {
				System.out.println(p);
			}
		}
		saveProductInformation();
	}

	/**
	 * @author 오석호 (관리자 돈 조회)
	 */
	public void money() {
		System.out.println(customers.get(0).getMoney());
	}

	/**
	 * @author 오석호 (구매자 메소드),
	 */
	public void executeCustomer() throws RangeException {
		while (true) {
			int input = nextInt(createTextBox(new String[] {"물품조회", "구매", "로그아웃"}),1,3);
			switch (input) {
			case 1:
				// 손님 물품 조회 (물건 번호, 이름, 가격, 개수)
				inventory();
				break;
			case 2:
				inventory();
				// 손님 물품 구매
				purchaseByCustomer(nextInt("구매할 상품번호를 입력하세요.", 1,38)
								,nextInt("구매할 상품의 개수를 입력하세요.",1,100));
				break;
			case 3:
				System.out.println(
						"┌───────────────────┐\n"
					   +"├──┿──log out──┿────┥\n"
					   +"└───────────────────┘");
				currentAccessor.remove(0);
				return;
			}
		}
	}

	/**
	 * @author 오석호 (관리자 메소드),
	 */
	public void executeAdmin() {
		while (true) {
			int input = nextInt(createTextBox(new String[] {"물품조회", "구매", "돈 조회", "재고"
					, "팔린 물품 통계","회원 관리", "로그아웃"}),1,7);
			switch (input) {
			case 1:
				// 관리자 물품 조회 (모든 물품리스트 (번호, 이름, 가격)
				list();
				break;
			case 2:
				list();
				// 관리자 물품 구매
				purchaseByAdmin(nextInt("물건 번호를 입력하세요: ",1,38)
							,nextInt("개수를 입력하세요>",1,100));
				break;
			case 3:
				// 관리자 돈 조회
				money();
				break;
			case 4:
				// 관리자 재고
				inventory();
				break;
			case 5:
				// 팔린 물품 통계
				statistics();
				break;
			case 6:
				customerManagement();
				break;
			case 7:
				System.out.println(
						"┌───────────────────┐\n"
					   +"├──┿──log out──┿────┥\n"
					   +"└───────────────────┘");
				currentAccessor.remove(0);
				return;
			}
		}
	}


	/**
	 * @author 오석호 (회원 관리)
	 */
	public void customerManagement() {
		while (true) {
			int choose = nextInt(createTextBox(new String[] {"회원 조회", "회원 수정", "회원 삭제"
					, "종료"}),1,4);
			switch (choose) {
			case 1:
				// 회원 조회
				printTitle();
				customerList();
				break;
			case 2:
				// 회원 수정
				printTitle();
				customerList();
				customerModify();
				break;
			case 3:
				// 회원 삭제
				printTitle();
				customerList();
				customerRemove();
				break;
			case 4:
				return;
			default:
				break;
			}
		}
	}

	/**
	 * @author 오석호 (관리자 물품 구매),
	 */
	public void purchaseByAdmin(int no, int ea) {
		Product inventories = findByInventories(no);
		inventories.setEa(inventories.getEa() + ea);
		admin.setMoney((int) (admin.getMoney() - inventories.getPrice() * 0.8 * ea));
		saveCustomerInformation();
		saveProductInformation();
	}

	/**
	 * @author 오석호  (관리자,손님 재고 조회)
	 */
	public void inventory() {
		list();
	}

	/**
	 * @author 오석호 (재고 조회시 메뉴창 생성)
	 */

	public void printProduct() {
		System.out.println("===상품번호====상품명========가격========재고====");
	}

	/**
	 * @author 오석호, 손요한(1 음료 2 술ㆍ담배 3 신선식품 4 과자 5 종료 의 숫자반환)
	 */
	public int kind() {
		int kind = nextInt(createTextBox(new String[] {"음료", "술,담배", "신선식품", "과자"}),1,4);
		if(kind==2 && currentAccessor.get(0).getAge()<20) {
			System.out.println("!미성년자는 해당 품목을 구입하실 수 없습니다.");
			return kind();
		}
		return kind;
	}



	/**
	 * @author 손요한 손님 물품 구매
	 */
	public void purchaseByCustomer(int no, int ea) {
		Product inventory = findByInventories(no) ;
		Customer accessor = currentAccessor.get(0);
		Customer cs = findByCustomer(accessor.getId());
		if (no == 0) {
			System.out.println("해당 상품은 존재하지 않습니다.");
		}
		
		// 재고부분
		if (inventory.getEa() >= ea) {
			if(accessor.getMoney() < inventory.getPrice()*ea) {
				System.out.println("돈이 부족합니다.");
				return;
			} else {
				inventory.setEa(inventory.getEa() - ea);
				accessor.setMoney(accessor.getMoney()-inventory.getPrice()*ea);
				cs.setMoney(accessor.getMoney());
				admin.setMoney(admin.getMoney()+inventory.getPrice()*ea);
				System.out.println("구매가 완료되었습니다.");
			}
		} else {
			System.out.println("재고가 부족합니다.");
		}
		
		// 통계부분
		Product statistic = findByStatistics(no);
		if (statistic != null) {
			statistic.setEa(statistic.getEa() + ea);
			statistic.setPrice((int) (statistic.getPrice() + inventory.getPrice() * 0.2 * ea));
			return;
		}
		if (inventory.getEa() != 0) {
			statistics.add(
					new Product(inventory.getNo(), inventory.getName(), (int) (inventory.getPrice() * ea * 0.2), ea));
		}
		saveCustomerInformation();
		saveProductInformation();
	}

	/**
	 * @author 손요한
	 * 통계 출력
	 * */
	
	public void statistics() {
		statistics.sort(new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return o2.getEa()-o1.getEa();
			}
		});
		printSoldProduct();
		for(Product p : statistics) {
			System.out.println(p);
		}
		saveProductInformation();
	}

	/*
	 * 손요한 21.07.31 통계 조회시 메뉴창 생성
	 */
	public void printSoldProduct() {
		System.out.println("===번호==상품명=========수익==총개수==");
	}

	/**
	 * @author 오석호, 곽승협, 이유림
	 * (로그인) */
	public void login(String id, String pw) {
		Customer cs = findByCustomer(id);
		if(cs == null) {
			System.out.println("가입되어 있지 않는 ID입니다.");
			System.out.println("ID를 다시 확인해주세요");
			return;
		} 
		else if(findByIdPw(id, pw) == null) {
			System.out.println("PW를 다시 확인해주세요.");
			return;
		}
		System.out.println(cs.getName()+"님 Cu에 오신것을 환영합니다.");
		currentAccessor.add(new Customer(cs.getNo(), cs.getId(), cs.getPw(), cs.getAge(), cs.getName(), cs.getMoney(), cs.isAdmin()));
		if (findByCustomer(id).isAdmin()) {
			adminChoose();
		} else {
			executeCustomer();
		}
		
	}
	/**
	 * @author 오석호
	 * (어드민 로그인시 선택)
	 * */
	public void adminChoose() {
		int kind = nextInt(
				"┌──────────────────────────┐\n"
			   +"│        선택하시오        │\n"
			   +"│  ① 구매자   ② 관리자   │\n"
			   +"└──────────────────────────┘",1,2);
		switch (kind) {
		case 1:
			executeCustomer();
			break;
			
		case 2:
			executeAdmin();
			break;

		default:
			break;
		}
	}

	// 21.8.5 곽승협, 오석호 회원가입 
	public void signUp() {
		String id = nextLine("아이디를 입력해주세요");
		if(findByCustomer(id) != null) {
			System.out.println(
					"──────────────────────※caution※──────────────────────\n"
					+"\n"
					+"         	  중복된 ID 입니다\n" 
					+"                  다른 ID를 입력해 주세요\n"
			 	 +"\n──────────────────────※caution※──────────────────────");
			return;
			
		}
		customers.add(new Customer(
				no++
				, id
				, nextLine("패스워드를 입력해주세요")
				, nextInt("나이를 입력해주세요")
				, nextLine("이름을 입력해주세요")
				, nextInt("가진 금액을 입력해주세요")));
		saveCustomerInformation();
	}

	private void printTitle() {
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("회원번호  ID 	P/W   나이   이름 	돈");
		System.out.println("└─────────────────────────────────────────────────┘");
	}

	/**
	 * @author 오석호 (회원 조회)
	 */
	public void customerList() {
		for (Customer a : customers) {
			System.out.println(a);
		}
	}

	/**
	 * @author 곽승협 회원 수정
	 */
	public void customerModify() {
		String ModifyId = nextLine("수정할 ID를 입력해주세요. >");
		Customer ModifyIdent = findByCustomer(ModifyId);
		if (ModifyIdent != null) {
			ModifyIdent.setPw(nextLine("수정할 PW를 입력해주세요"));
			ModifyIdent.setAge(nextInt("수정할 나이를 입력해주세요"));
			ModifyIdent.setName(nextLine("수정할 이름을 입력해주세요"));
			ModifyIdent.setMoney(nextInt("수정할 금액을 입력해주세요"));
			ModifyIdent.setId(nextLine("수정할 ID를 입력해주세요"));
		} else {
			System.out.println("회원ID가 존재하지 않습니다. 다시 입력해주세요");
		}
		saveCustomerInformation();
	}

	/**
	 * @author 곽승협 회원 삭제
	 */
	public void customerRemove() {
		Customer ModifyId = findByCustomer(nextLine("삭제할 ID를 입력해주세요. >"));
		if (ModifyId != null) {
			String pw = nextLine("패스워드를 입력해 주세요");
			if (ModifyId.getPw().equals(pw))
				;
			customers.remove(ModifyId);
			System.out.println("지금까지 이용해주셔서 감사합니다.");
		} else {
			System.out.println("회원ID가 존재하지 않습니다. 다시 입력해주세요");
			return;
		}
		saveCustomerInformation();
	}

	/**
	 * @author 손요한 통계 findBy
	 **/
	public Product findByStatistics(int no) {
		for (int i = 0; i < statistics.size(); i++) {
			if (no == statistics.get(i).getNo()) {
				return statistics.get(i);
			}
		}
		return null;
	}

	/**
	 * @author 오석호 (admin, customer findBy)
	 **/
	public Customer findByCustomer(String id) {
		for (int i = 0; i < customers.size(); i++) {
			if (id.equals(customers.get(i).getId())) {
				return customers.get(i);
			}
		}
		return null;
	}
	/**
	 * @author 이유림
	 * id pw 검사 
	 **/
	public Customer findByIdPw(String id, String pw) {
		Customer c = findByCustomer(id);
		return c == null || !c.getPw().equals(pw) ? null : c;
	}
	/**
	 * @author 오석호 (재고 findBy)
	 */
	public Product findByInventories(int no) {
		for (int i = 0; i < inventories.size(); i++) {
			if (no == inventories.get(i).getNo()) {
				return inventories.get(i);
			}
		}
		return null;
	}
	
	/**
	 * @author 오석호 
	 * 수정 필요함 (직렬화)
	 */
	private void saveCustomerInformation() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.ser"));
			oos.writeObject(customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadCustomerInformation() throws Exception{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.ser"));
			customers = (List<Customer>) ois.readObject();
		
	}
	private void saveProductInformation() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.ser"));
			oos.writeObject(inventories);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadProductInformation() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.ser"));
		inventories = (List<Product>) ois.readObject();
		
	}

}
