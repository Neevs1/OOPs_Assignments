import java.util.*;


class AadharNumberException extends Exception{
	AadharNumberException(){
		
	};
}
class InvalidAgeException extends Exception{
	InvalidAgeException(){
		
	};
}

class CreateAccount{
	Scanner sc=new Scanner(System.in);
	boolean validity;	
	String[] name = new String[3];
	int Aadhar[]= {0,0,0};
	int phoneNum=0,initial_deposit,age=-1;
	char gender='a';
	String email,PAN;
	CreateAccount(){
		
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
				if(Math.floorDiv(Aadhar[0], 1000)==0) {
					Aadhar[0]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input");
			}
		}while(Math.floorDiv(Aadhar[0], 1000)==0);
		do {
			System.out.println("Please enter next four digits of Aadhar number");
			try{
				Aadhar[1]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[0], 1000)==0) {
					Aadhar[1]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input");
			}
		}while(Math.floorDiv(Aadhar[1], 1000)==0);
		do {
			System.out.println("Please enter last four digits of Aadhar number");
			try{
				Aadhar[0]=Integer.parseInt(sc.next());
				if(Math.floorDiv(Aadhar[2], 1000)==0) {
					Aadhar[2]=0;
					throw new AadharNumberException();
				}
			}catch(NumberFormatException | AadharNumberException e) {
				System.out.println("Invalid input");
			}
		}while(Math.floorDiv(Aadhar[2], 1000)==0);
		do {
			System.out.println("Please enter phone number");
			try{
				phoneNum=Integer.parseInt(sc.next());
				if(Math.floorDiv(phoneNum, 1000000000)==0) {
					phoneNum =0;
					
				}
			}catch(NumberFormatException e) {
				System.out.println("Invalid input");
			}
		}while(Math.floorDiv(phoneNum, 1000000000)==0);
		do {
			System.out.println("Please enter gender");
			System.out.println("M for male,F for female,O for other");
			
				gender=(sc.next().charAt(0));
				if(gender!='M'||gender!='F'||gender!='O') {
					System.out.println("Invalid Gender");
					
				}
			
		}while(gender!='M'||gender!='F'||gender!='O');
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
			
			
		}while(age>=0);
		
	}
}

public class bank {

	public static void main(String[] args) {
		
		
		

	}

}
