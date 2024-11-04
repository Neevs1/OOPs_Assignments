
public class BitcoinStrategy implements PaymentStrategy {
	private String address;

	public BitcoinStrategy(String address){
		this.address=address;
	}
	
	public void pay(int amount) {
		System.out.println(amount + " Paid using bitcoin.");
		
	}

}
