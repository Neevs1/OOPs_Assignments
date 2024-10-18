import java.util.*;


class AadharNumberException extends Exception{
	AadharNumberException(){
		//custom variable for aadhar number
	};
}
class InvalidAgeException extends Exception{
	InvalidAgeException(){
		//custom exception for age
	};
}

class WithdrawalException extends Exception{
	WithdrawalException(){
		//custom exception for withdrawal
	};
}

class CreateAccount{
	Scanner sc=new Scanner(System.in);
	//declaration of all required variables
	boolean validity;	
	String[] name = new String[3];
	int Aadhar[]= {0,0,0};
	long phoneNum=0,bankBalance;
	int withdrawLimit,age=-1,accountID,lim;
	char gender='a';
	String email,PAN,pwd;
	static int currentID = 10000;  //static int to give each user a new id
	void createAccount(){
		
		System.out.println("Welcome to SBI bank");
		System.out.println("Please enter First name of account holder");
		name[0]=sc.next(); //takes first name
		System.out.println("Please enter second name/middle name of account holder");
		name[1]=sc.next(); //takes middle name
		System.out.println("Please enter Last name of account holder");
		name[2]=sc.next(); //takes last name
		do {
			System.out.println("Please enter first four digits of Aadhar number");
			try{ //takes input of aadhar number
				Aadhar[0]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[0], 1000)==0||Math.floorDiv(Aadhar[0], 1000)>9) {
					Aadhar[0]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input"); 
				//handles error related to aadhar number
			}
		}while(Math.floorDiv(Aadhar[0], 1000)==0||Math.floorDiv(Aadhar[0], 1000)>9);
		do {
			System.out.println("Please enter next four digits of Aadhar number");
			try{//takes input of aadhar number
				Aadhar[1]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[1], 1000)==0||Math.floorDiv(Aadhar[1], 1000)>9) {
					Aadhar[1]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input, enter again");
				//handles error related to aadhar number
			}
		}while(Math.floorDiv(Aadhar[1], 1000)==0||Math.floorDiv(Aadhar[1], 1000)>9);
		do {//takes input of aadhar number
			System.out.println("Please enter last four digits of Aadhar number");
			try{
				Aadhar[2]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[2], 1000)==0||Math.floorDiv(Aadhar[2], 1000)>9) {
					Aadhar[2]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input, enter again");
				//handles error related to aadhar number
			}
		}while(Math.floorDiv(Aadhar[2], 1000)==0||Math.floorDiv(Aadhar[2], 1000)>9);
		do {
			System.out.println("Please enter phone number");
			try{
				phoneNum=Long.parseLong(sc.next());
				if(Math.floorDiv(phoneNum, 1000000000)==0 || Math.floorDiv(phoneNum, 1000000000)>9) {
					phoneNum =0;
					//if phone number is not having 10 digits, or is invalid, gives option to re-enter
				}
			}catch(NumberFormatException e) {
				System.out.println("Invalid input, please re-enter");
			}
		}while(Math.floorDiv(phoneNum, 1000000000)==0 || Math.floorDiv(phoneNum, 1000000000)>9);
		do {
			System.out.println("Please enter gender");
			System.out.println("M for male,F for female,O for other");
			
				gender=(sc.next().toUpperCase()).charAt(0);
				if(gender!='M'&&gender!='F'&&gender!='O') {
					//if gender is not male,female or other
					System.out.println("Invalid Gender");
					
				}
			
		}while(gender!='M'&&gender!='F'&&gender!='O');
		do{ //only accepts valid email id in form <email>@<domainname>.<domain> or <email>@<name>.<subdomain>.<domain>
		    System.out.println("Enter email id");
		    email = sc.next();
		    int c1=0,c2=0;
		    for(int i=0;i<email.length();i++) {
			    if(email.charAt(i)=='@') {
				c1++;
			  }
		   }
		   if(c1==1) {
		   for(int i=email.indexOf("@");i<email.length();i++) {
			   if(email.charAt(i)=='.') {
					c2++;
				  }
		   }
		   if(c2==1||c2==2) {
			   validity = true;
		   }else{
			   validity = false;
			   System.out.println("Invalid email id");
			   
		   }
		 }else {
			 validity = false;
			 System.out.println("Invalid email id");
		 }
		
		}while(validity == false);
		
		do {
			try {
			   System.out.println("Enter age");
			   age=Integer.parseInt(sc.next()); //takes input of age
			   if(age>120||age<0) {
				   throw new InvalidAgeException();
				   //throws custom age exception is age is out of bounds
			   }
			}catch(NumberFormatException |InvalidAgeException e) {
				age=-1;
				System.out.println("Invalid age");
			}
			
			
		}while(age<=0);
		do {
			System.out.println("Please set withdrawal limit");
			try{ //gets the withdrawal limit
				withdrawLimit=Integer.parseInt(sc.next());
				
			}catch(NumberFormatException e) {
				System.out.println("Invalid input, please re-enter");
				withdrawLimit=-1; //if input is invalid, resets to -1
			}
		}while(withdrawLimit<0);
		lim = withdrawLimit;
		System.out.println("Please enter secure password");
		pwd = sc.next(); //takes input of password
		currentID++; //increment in static int currentID
		this.accountID = currentID; //assigns new account ID to each account
		System.out.println("Account successfully created! Your account ID is "+this.accountID);
		//gives account ID to user for login purposes
		
	}
}

class login extends CreateAccount{
	String password;
	int AccID;
	boolean loginSuccess() { //boolean for login operation
		System.out.println("Please login to continue");
		try { 
		System.out.println("Please enter account ID");
		AccID = Integer.parseInt(sc.next()); //gets id
		System.out.println("Please enter password");
		password = sc.next(); //takes input password
		}catch(NumberFormatException e){
			System.out.println("Invalid account ID, retry");
			//id should be in digits
		}
		return(pwd.equals(password)&&AccID==this.accountID);
		/*
		 * Returns true if
		 * 1) Account id exists
		 * 2) Account id correctly entered
		 * 3) Entered password matches set password
		 */
	
	}
}

class operations extends login{
	void displayDetails() { //displays all details of user
		System.out.println("Name is "+name[0]+" "+name[1]+" "+name[2]);
		System.out.println("Aadhar Number is "+Aadhar[0]+"-"+Aadhar[1]+"-"+Aadhar[2]);
		System.out.println("Registered mobile number is "+phoneNum);
		System.out.println("Registered email is "+email);
		System.out.println("Age is "+age);
		System.out.println("Bank balance is "+bankBalance);
		
	}
	
	void deposit() {
		System.out.println("Enter amount you want to deposit");
		try { //try block for input format
			int money=Integer.parseInt(sc.next()); //takes input for deposit amount
			bankBalance=bankBalance+money; //adds money to account
			System.out.println("Deposited amount is "+money+"\nBalance is now"+bankBalance);
			//success message
		}catch(NumberFormatException e) {
			System.out.println("Invalid balance,please enter integer value");
			//for input exception
		}
		
	}
	void withdraw() {
		System.out.println("Enter amount you want to withdraw");
		try {
			int money=Integer.parseInt(sc.next());
			if(lim-money<0) { //checks if withdrawal limit exceeded
				System.out.println("You cannot withdraw this amount as it exceeds daily limit");
			}else {
			if(bankBalance-money<0) { //more money than available
				throw new WithdrawalException();
			}else if(bankBalance-money==0) { //withdrawing all money
				System.out.println("ALERT! Your bank account is empty");
				bankBalance=0;
				lim=lim-money;
			}else {
				bankBalance=bankBalance-money; //normal withdrawal operation
				System.out.println("Withdrawn amount is "+money+"\nBalance is now"+bankBalance);
				//success message
				lim=lim-money; //withdrawal limit data changed
			}
			}
		 }catch(NumberFormatException e) {
			System.out.println("Invalid balance,please enter integer value");
			//number format exception
		 }catch(WithdrawalException e) {
			System.out.println("Withdrawal amount less than balance. Your account does not permit overdraft");
			//for overdraft
		}
		
		
	}
	
}

public class bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		operations[] o = new operations[5]; //array of objects
		int userCount =0,thisUser = 0; //for counting and matching user
		boolean found=false;
		String go = null;
		do {
		System.out.println("Welcome to SBI");
		System.out.println("Please select option");
		System.out.println("1.New User");
		System.out.println("2.Existing user");
		int user = sc.nextInt();
		switch(user) {
		case 1: //new user
			o[userCount]=new operations(); //initialize object
			o[userCount].createAccount(); //create account
			userCount++; //moves to next element in array
			break;
		case 2:
			System.out.println("Enter account ID");
			int ID = sc.nextInt(); //checks if account id present
			for(int i=0;i<userCount;i++) { //searches for account id
				if(ID==o[i].accountID) {
					thisUser=i;
					found=true; //sets found to true
				}
			}
			if(found) { //if user exists
			   if(o[thisUser].loginSuccess()) { //and login is successful
				   int choice;
				   do {
					   System.out.println("Please enter operation");
					   System.out.println("1.Withdraw");
					   System.out.println("2.Deposit");
					   System.out.println("3.View details");
					   System.out.println("4.Logout");
					   choice = sc.nextInt();
					   switch(choice) {
					   case 1:
						   o[thisUser].withdraw(); //withdraw operation
						   break;
					   case 2:
						   o[thisUser].deposit(); //deposit operations
						   break;
					   case 3:
						   o[thisUser].displayDetails(); //get data
						   break;
					   case 4:
						   System.out.println("Thank you for choosing our bank");
						   //logs out of current user. New account can be created/other existing user can be accessed now
						   break;
					   default:
						   System.out.println("Invalid operation");
					   }
					   
					   
					   
				   }while(choice!=4);
			   }
			  
			}
			break;
			default:
				System.out.println("Invalid input");
		}
		 System.out.println("Do you wish to continue? Type Yes");
		 go=sc.next().toLowerCase();
		}while(go.equals("yes"));
		
		

	}

}
