import java.util.*;


class AadharNumberException extends Exception{
	AadharNumberException(){
		
	};
}
class InvalidAgeException extends Exception{
	InvalidAgeException(){
		
	};
}

class WithdrawalException extends Exception{
	WithdrawalException(){
		
	};
}

class CreateAccount{
	Scanner sc=new Scanner(System.in);
	boolean validity;	
	String[] name = new String[3];
	int Aadhar[]= {0,0,0};
	long phoneNum=0,bankBalance;
	int initial_deposit,age=-1,accountID;
	char gender='a';
	String email,PAN,pwd;
	static int currentID = 10000;
	void createAccount(){
		
		System.out.println("Weclome to SBI bank");
		System.out.println("Please enter First name of account holder");
		name[0]=sc.next();
		System.out.println("Please enter second name/middle name of account holder");
		name[1]=sc.next();
		System.out.println("Please enter Last name of account holder");
		name[2]=sc.next();
		do {
			System.out.println("Please enter first four digits of Aadhar number");
			try{
				Aadhar[0]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[0], 1000)==0||Math.floorDiv(Aadhar[0], 1000)>9) {
					Aadhar[0]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input");
			}
		}while(Math.floorDiv(Aadhar[0], 1000)==0||Math.floorDiv(Aadhar[0], 1000)>9);
		do {
			System.out.println("Please enter next four digits of Aadhar number");
			try{
				Aadhar[1]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[1], 1000)==0||Math.floorDiv(Aadhar[1], 1000)>9) {
					Aadhar[1]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input, enter again");
			}
		}while(Math.floorDiv(Aadhar[1], 1000)==0||Math.floorDiv(Aadhar[1], 1000)>9);
		do {
			System.out.println("Please enter last four digits of Aadhar number");
			try{
				Aadhar[2]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[2], 1000)==0||Math.floorDiv(Aadhar[2], 1000)>9) {
					Aadhar[2]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input, enter again");
			}
		}while(Math.floorDiv(Aadhar[2], 1000)==0||Math.floorDiv(Aadhar[2], 1000)>9);
		do {
			System.out.println("Please enter phone number");
			try{
				phoneNum=Long.parseLong(sc.next());
				if(Math.floorDiv(phoneNum, 1000000000)==0 || Math.floorDiv(phoneNum, 1000000000)>9) {
					phoneNum =0;
					
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
			   age=Integer.parseInt(sc.next());
			   if(age>100||age<0) {
				   throw new InvalidAgeException();
			   }
			}catch(NumberFormatException |InvalidAgeException e) {
				age=-1;
				System.out.println("Invalid age");
			}
			
			
		}while(age<=0);
		System.out.println("Please enter secure password");
		pwd = sc.next();
		currentID++;
		this.accountID = currentID;
		System.out.println("Account sucessfully created! Your account ID is "+this.accountID);
		
	}
}

class login extends CreateAccount{
	String password;
	int AccID;
	boolean loginSuccess() {
		System.out.println("Please login to continue");
		try {
		System.out.println("Please enter account ID");
		AccID = Integer.parseInt(sc.next());
		System.out.println("Please enter password");
		password = sc.next();
		}catch(NumberFormatException e){
			System.out.println("Invalid account ID, retry");
		}
		return(pwd.equals(password)&&AccID==this.accountID);
	
	}
}

class operations extends login{
	void displayDetails() {
		System.out.println("Name is "+name[0]+" "+name[1]+" "+name[2]);
		System.out.println("Aadhar Number is "+Aadhar[0]+"-"+Aadhar[1]+"-"+Aadhar[2]);
		System.out.println("Registered mobile number is "+phoneNum);
		System.out.println("Registered email is "+email);
		System.out.println("Age is "+age);
		System.out.println("Bank balance is "+bankBalance);
		
	}
	
	void deposit() {
		System.out.println("Enter amount you want to deposit");
		try {
			int money=Integer.parseInt(sc.next());
			bankBalance=bankBalance+money;
			System.out.println("Deposited amount is "+money+"\nBalance is now"+bankBalance);
		}catch(NumberFormatException e) {
			System.out.println("Invalid balance,please enter integer value");
		}
		
	}
	void withdraw() {
		System.out.println("Enter amount you want to else");
		try {
			int money=Integer.parseInt(sc.next());
			if(bankBalance-money<0) {
				throw new WithdrawalException();
			}else if(bankBalance-money==0) {
				System.out.println("ALERT! Your bank account is empty");
				bankBalance=0;				
			}else {
				bankBalance=bankBalance+money;
				System.out.println("Withdrawn amount is "+money+"\nBalance is now"+bankBalance);
			}
		}catch(NumberFormatException e) {
			System.out.println("Invalid balance,please enter integer value");
		}catch(WithdrawalException e) {
			System.out.println("Withdrawal amount less than balance. Your account does not permit overdraft");
		}
		
	}
	
}

public class bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		operations[] o = new operations[5];
		int userCount =0,thisUser = 0;
		boolean found=false;
		System.out.println("Welcome to SBI");
		System.out.println("Please select option");
		System.out.println("1.New User");
		System.out.println("2.Existing user");
		int user = sc.nextInt();
		switch(user) {
		case 1:
			o[userCount]=new operations();
			o[userCount].createAccount();
			userCount++;
		case 2:
			System.out.println("Enter account ID");
			int ID = sc.nextInt();
			for(int i=0;i<userCount;i++) {
				if(ID==o[i].accountID) {
					thisUser=i;
					found=true;
				}
			}
			if(found) {
			   if(o[thisUser].loginSuccess()) {
				   do {
					   System.out.println("Please enter operation");
					   System.out.println("1.Withdraw");
					   System.out.println("2.Deposit");
					   System.out.println("3.View details");
					   int choice = sc.nextInt();
					   switch(choice) {
					   case 1:
						   o[thisUser].withdraw();
						   break;
					   case 2:
						   o[thisUser].deposit();
						   break;
					   case 3:
						   o[thisUser].displayDetails();
						   break;
					   default:
						   System.out.println("Invalid operation");
					   }
					   
				   }while(false);
			   }
			  
			}
		}
		
			
		
		

	}

}
