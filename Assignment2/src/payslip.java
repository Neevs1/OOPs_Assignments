/*
 * Author - Neevan Redkar
 * Branch - IT
 * Year - SE
 * Batch - S3
 * Roll No - 3069
 */
import java.util.*;

class employee{ //defined class employee
	Scanner sc = new Scanner(System.in);
	String emp_name,address,mail_id; 
	int emp_id;
	long mob_no;
	//defined required variables
	void getdata() {
		boolean validity,valid;
		System.out.println("Enter employee id");
		emp_id = sc.nextInt();
		System.out.println("Enter name");
		emp_name = sc.next();
		do{
		    System.out.println("Enter email id");
		    mail_id = sc.next();
		    int c1=0,c2=0;
		    for(int i=0;i<mail_id.length();i++) {
			    if(mail_id.charAt(i)=='@') {
				c1++;
			  }
		   }
		   if(c1==1) {
		   for(int i=mail_id.indexOf("@");i<mail_id.length();i++) {
			   if(mail_id.charAt(i)=='.') {
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
		do{
			
			System.out.println("Enter phone number");
			mob_no=sc.nextLong();			
			if((mob_no/1000000000)>0&&(mob_no/1000000000)<10) {
				valid=true;				
			}else {
				valid=false;
				System.out.println("Invalid phone number");
			}
		}while(valid==false);
		
		
		
	}
}

class programmer extends employee{
	
	
}

class teamLead extends employee{
	
}

class ASP extends employee{
	
}

class PM extends employee{
	
}

public class payslip {

	public static void main(String[] args) {
		employee e = new employee();
		e.getdata();
		
	}

}
