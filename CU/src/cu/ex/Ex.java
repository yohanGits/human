package cu.ex;

import static cu.util.Common.*;
import static cu.util.Common2.*;

import cu.exception.RangeException;
import cu.service.Service;
import cu.service.ServiceImpl;
//import cu.vo.Customer;

public class Ex {
	public static void main(String[] args) {
		Service cu = new ServiceImpl();
		while (true) {
			try {
				int kind = nextInt(createTextBox(new String[] {"로그인", "회원가입", "종료"}),1,3);
				switch (kind) {
				case 1:
					cu.login(nextLine("ID 입력: "), nextLine("PW 입력: "));
					break;
				case 2:
					cu.signUp();
					break;
				case 3:
					System.out.println("종료합니다");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("──────────────────────※caution※──────────────────────\n"
						+"\n"
						+"           특수문자는 지원하지 않습니다\n" 
						+"\n──────────────────────※caution※──────────────────────");
			} catch (RangeException e) {
				System.out.println(e.getMessage());
			}

		}
		
		
	}

}

