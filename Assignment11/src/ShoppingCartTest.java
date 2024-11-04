import java.util.*;
public class ShoppingCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to shopping cart!");
		
		Item item1 = new Item("1234",60);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		
		
		//add switch-case for choice
		System.out.println("Please enter choice of Payment");
		System.out.println("1.PayPal");
		System.out.println("2.Credit card/Debit Card");
		System.out.println("3.Bitcoin");
		System.out.println("Enter number associated with option");
		int choice=0;
		do {
			try {
				choice=Integer.parseInt(sc.next());
			}catch(NumberFormatException e) {
				System.out.println("Please enter integer next to option");
			}
			
		}while(choice==0);
		
		switch(choice) {
		case 1:
			System.out.println("Enter email id");
			String email = sc.next();
			System.out.println("Enter password");
			String pwd = sc.next();
			cart.pay(new PaypalStrategy(email,pwd));
			break;
		case 2:
			System.out.println("Enter name(Seperate with underscores");
			String name = sc.next();
			name=name.replace('_', ' ');
			System.out.println("Enter credit/debit card number");
			String cardNo=sc.next();
			System.out.println("Enter cvv");
			String cvv=sc.next();
			System.out.println("Enter credit/debit card expiry date");
			String expiry=sc.next();
			cart.pay(new CreditCardStrategy(name,cardNo,cvv,expiry));
			break;
		case 3:
			System.out.println("Enter bitcoin wallet address(and approve request)");
			String address=sc.next();
			cart.pay(new BitcoinStrategy(address));
			break;
		default:
			System.out.println("Invalid mode.Payment failed");
			break;
		}
	
		
	}

}
