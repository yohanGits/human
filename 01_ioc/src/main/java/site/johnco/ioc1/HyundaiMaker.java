package site.johnco.ioc1;

public class HyundaiMaker implements CarMaker{
	public Car sell(Money money){
		System.out.println("금액 : " + money.getAmount());
		return new Car("Genesis g80");
	}
}
