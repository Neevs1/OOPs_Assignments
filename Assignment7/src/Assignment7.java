import java.util.*;

class Operations{
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> nums = new ArrayList<Integer>();
	Iterator<Integer> it = nums.iterator();
	Operations(){
		do {
		try {
			System.out.println("Please enter integer");
			int input = Integer.parseInt(sc.next());
			nums.add(input);
			
		}catch(NumberFormatException e) {
			System.out.println("Invalid input /nPlease re-enter");
			
		}
		}while(nums.isEmpty());
		
	}
	void add() {
		try {
			System.out.println("Please enter integer");
			int input = Integer.parseInt(sc.next());
			nums.add(input);
			
		}catch(NumberFormatException e) {
			System.out.println("Invalid input \nOperation aborted");
		}
		
	}
	int even() {
		int counter=0;
		for(int i=0;i<nums.size();i++) {
			if((nums.get(i)&1)==0) {
				counter++;
			}
		}
		return counter;
	}
	int odd() {
		int counter =0;
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)%2==1) {
				counter++;
			}
		}
		return counter;
	}
	int prime() {
		int counter =0;
		boolean isPrime = true;
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)>=1){
				continue;
		      }else if(nums.get(i)==2||nums.get(i)==3) {
				isPrime=true;
			}else {
			for(int j=2;j<=(int)Math.sqrt(nums.get(i));j++) {
				if(nums.get(i)%j==0) {
					isPrime=false;
				}
			}
			}
			if(isPrime) {
				counter++;
			}else {
				isPrime=true;
			}
			
		}
		return counter;
	}
	
	/*int palindrome() {
		
	}*/
}

public class Assignment7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Operations o = new Operations();
		int choice =0;
		do {
			System.out.println("Menu");
			System.out.println("1.Add an integers");
			System.out.println("2.Number of even integers");
			System.out.println("3.Number of odd integers");
			System.out.println("4.Number of prime integers");
			System.out.println("5.Number of palindrome integers");
			System.out.println("6.Exit");
			System.out.println("Enter operation of choice(Enter number)");
			try {
				choice=Integer.parseInt(sc.next());
			}catch(NumberFormatException e) {
				System.out.println("Invalid input format");
				choice=0;
			}
			switch(choice) {
			case 1:
				o.add();
				break;
			case 2:
				System.out.println("Number of even integers is "+o.even());
				break;
			case 3:
				System.out.println("Number of odd numbers is "+o.odd());
				break;
			case 4:
				System.out.println("Number of prime numbers is "+o.prime());
				break;
			case 5:
				System.out.println("Number of palindrome numbers is ");
				break;
			case 6:
				System.out.println("Have a good day");
				break;
			default:
				System.out.println("Invalid choice");
			}
			
		}while(choice!=6);
		
		

	}

}
