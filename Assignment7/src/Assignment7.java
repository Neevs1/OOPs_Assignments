import java.util.*; 
/*
 * Imported util.* for
 * Scanner, ArrayList and Iterator
 */

class logic{ //contains logical functions for prime and palindrome
	boolean isPrime(int num) { 
		if(num<=1) { //if number is <=1, automatically not prime
			return false;
		}else if(num==2||num==3) { //as sqrt of 2&3 are less than 2, special case
			return true; //2&3 are prime numbers
		}else { //for all other numbers
			for(int j=2;j<=(int)Math.sqrt(num);j++) {
				//if non prime, at least 1 multiple will be below/equal to square root of number
				if(num%j==0) {
					return false; //if divisor found, returns false
				}
			}
			}
		return true; //end of function, if reached here number is prime
			
		}
	
	boolean isPalindrome(int num) { //to check if given num is palindrome
		int temp = num; //extra value 
		int pal=0; //initialized palindrome to 0
		while(temp!=0) { //while loop to reverse number
			pal=pal*10+(temp%10);
			temp=temp/10;
		}
		return(pal==num); //returns true if they are equal, false if not
	}
}


class Operations{ //operations class where all operations are done on arraylist
	Scanner sc = new Scanner(System.in); //scanner for input
	logic l = new logic(); //object of logic class for prime and palindrome methods
	ArrayList<Integer> nums = new ArrayList<Integer>(); //declared new arraylist
	Iterator<Integer> it = nums.iterator(); //declared new iterator
	Operations(){ //constructor so that arraylist will not be empty
		do { //do while till we get valid input
		try { //for input
			System.out.println("Please enter integer");
			int input = Integer.parseInt(sc.next());
			nums.add(input); //adds input to arraylist
			
		}catch(NumberFormatException e) { //if input s not in integer format
			System.out.println("Invalid input /nPlease re-enter");
			
		}
		}while(nums.isEmpty()); //loops till value is successfully added to list
		
	}
	void add() { //for explanation, please refer to constructor
		try {
			System.out.println("Please enter integer");
			int input = Integer.parseInt(sc.next());
			nums.add(input);
			
		}catch(NumberFormatException e) {
			System.out.println("Invalid input \nOperation aborted");
		}//difference is that if invalid input is given, operation is called off
		//no additions made
		
	}
	int even() { //to check whether element is odd
		int counter=0; //local counter element
		for(int i=0;i<nums.size();i++) { //for loop for iteration
			if((nums.get(i)&1)==0) { //using binary operator to check for even odd
				counter++; //increment if even
			}
		}
		return counter; //returns final value of counter
	}
	int odd() { //to check if odd
		int counter =0; //local counter int
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)%2==1) { //check if odd using modulus operator
				counter++;
			}
		}
		return counter; //returns value
	}
	int prime() {
		int counter =0; //local counter
		for(int i=0;i<nums.size();i++) {
			if(l.isPrime(nums.get(i))) { //uses isPrime defined by us to see if prime
				counter++; //increment counter if prime
			}
		}
		return counter; //return value
	}
	
	int palindrome() { //function to check if the number if a palindrome number
	   int counter =0;
		for(int i=0;i<nums.size();i++) {
			if(!l.isPalindrome(nums.get(i))) { //calls palindrome method in logic class
				counter++; //increment counter if palindrome
			}
		}
		return counter; //returns counter
		
	}
	
	void print() { //prints entire list
		System.out.println(nums);
	}
}

public class Assignment7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Operations o = new Operations();
		int choice =0;
		do { //do while for multiple iterations
			System.out.println("Menu"); //menu of all operations
			System.out.println("1.Add an integers");
			System.out.println("2.Number of even integers");
			System.out.println("3.Number of odd integers");
			System.out.println("4.Number of prime integers");
			System.out.println("5.Number of palindrome integers");
			System.out.println("6.Print");
			System.out.println("7.Exit");
			System.out.println("Enter operation of choice(Enter number)");
			try { //takes input of choice
				choice=Integer.parseInt(sc.next());
			}catch(NumberFormatException e) { //if invalid, choice resets to zero
				System.out.println("Invalid input format");
				choice=0;
			}
			switch(choice) { //switch case for operations
			case 1:
				o.add(); //added an element
				break;
			case 2: //all even number count
				System.out.println("Number of even integers is "+o.even());
				break;
			case 3: //odd numbers count
				System.out.println("Number of odd numbers is "+o.odd());
				break;
			case 4: //prime number count
				System.out.println("Number of prime numbers is "+o.prime());
				break;
			case 5: //count of palindrome numbers
				System.out.println("Number of palindrome numbers is "+o.palindrome());
				break;
			case 6: //prints entire list
				System.out.println("The whole list is ");
				o.print();
				break;
			case 7: //exit
				System.out.println("Have a good day");
				break;
			default://invalid input handler
				System.out.println("Invalid choice");
			}
			
		}while(choice!=7);
		
		

	}

}
