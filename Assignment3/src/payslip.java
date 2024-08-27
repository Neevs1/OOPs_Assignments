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
	String mail_id;
	String[] emp_name = new String[2];
	String address;
	int emp_id,basicPay;
	long mob_no;
	
	int dA,hRA ,pF, clubFund,grossSalary,netSalary ;
	//defined required variables
	void getdata() {
		boolean validity,valid;
		System.out.println("Enter employee id");
		emp_id = sc.nextInt();
		System.out.println("Enter name(format:Firstname lastname)");
		emp_name[0] = sc.next();
		emp_name[1]= sc.next();
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
		System.out.println("Enter address(Seperate by underscore for multiple words)");
		address = sc.next();
		
	}
	
}

class programmer extends employee{
	int basicPay = 75000;
	 programmer(){
		 dA = 97*basicPay/100;
		 hRA = 10*basicPay/100;
		 pF = 12*basicPay/100;
		 clubFund = basicPay/1000;
		 System.out.println("Enter details of programmer\n");
	 }
	 
	
	void display() {
		System.out.println("|==================================================|");
		System.out.print("|	Name: "+emp_name[0]+" "+emp_name[1]);
		for(int i=0;i<37-(emp_name[0].length()+emp_name[1].length()+1);i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|	Employee id: "+emp_id+" 				   |");
		System.out.print("|	Email-id: "+mail_id);
		for(int i=0;i<33-(mail_id.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Mobile number: "+mob_no);
		for(int i=0;i<18;i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Address: "+address);
		for(int i=0;i<34-(address.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Post: Programmer			   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Earnings            | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Basic Pay           | "+basicPay+" 		   |");
		System.out.println("|	DA                  | "+this.dA+" 		   |");
		System.out.println("|	HRA                 | "+this.hRA+" 		   |");
		grossSalary = basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary| "+grossSalary+" 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Deductions          | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Provident Fund      | "+this.pF+" 		   |");
		System.out.println("|	Staff club fund     | "+this.clubFund+" 		   |");
		netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary  | "+netSalary+" 		   |");
		System.out.println("|==================================================|");
		System.out.println();
		
		
	}
	
		
	
}

class teamLead extends employee{
    int basicPay = 150000;
    teamLead(){
		 dA = 97*basicPay/100;
		 hRA = 10*basicPay/100;
		 pF = 12*basicPay/100;
		 clubFund = basicPay/1000;
		 System.out.println("Enter details of Team Lead\n");
	 }
	
	void display() {
		System.out.println("|==================================================|");
		System.out.print("|	Name: "+emp_name[0]+" "+emp_name[1]);
		for(int i=0;i<37-(emp_name[0].length()+emp_name[1].length()+1);i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|	Employee id: "+emp_id+" 				   |");
		System.out.print("|	Email-id: "+mail_id);
		for(int i=0;i<33-(mail_id.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Mobile number: "+mob_no);
		for(int i=0;i<18;i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Address: "+address);
		for(int i=0;i<34-(address.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Post: Team Lead  			   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Earnings            | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Basic Pay           | "+basicPay+" 		   |");
		System.out.println("|	DA                  | "+this.dA+" 		   |");
		System.out.println("|	HRA                 | "+this.hRA+" 		   |");
		grossSalary = basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary| "+grossSalary+" 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Deductions          | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Provident Fund      | "+this.pF+" 		   |");
		System.out.println("|	Staff club fund     | "+this.clubFund+" 		   |");
		netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary  | "+netSalary+" 		   |");
		System.out.println("|==================================================|");
		System.out.println();
		
		
	}
	
	
}

class ASP extends employee{
    int basicPay = 250000;
    ASP(){
		 dA = 97*basicPay/100;
		 hRA = 10*basicPay/100;
		 pF = 12*basicPay/100;
		 clubFund = basicPay/1000;
		 System.out.println("Enter details of Assistant Project Manager\n");
	 }
	
	void display() {
		System.out.println("|==================================================|");
		System.out.print("|	Name: "+emp_name[0]+" "+emp_name[1]);
		for(int i=0;i<37-(emp_name[0].length()+emp_name[1].length()+1);i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|	Employee id: "+emp_id+" 				   |");
		System.out.print("|	Email-id: "+mail_id);
		for(int i=0;i<33-(mail_id.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Mobile number: "+mob_no);
		for(int i=0;i<18;i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Address: "+address);
		for(int i=0;i<34-(address.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Post: Assisstant Project Manager           |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Earnings            | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Basic Pay           | "+basicPay+" 		   |");
		System.out.println("|	DA                  | "+this.dA+" 		   |");
		System.out.println("|	HRA                 | "+this.hRA+" 		   |");
		grossSalary = basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary| "+grossSalary+" 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Deductions          | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Provident Fund      | "+this.pF+" 		   |");
		System.out.println("|	Staff club fund     | "+this.clubFund+" 		   |");
		netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary  | "+netSalary+" 		   |");
		System.out.println("|==================================================|");
		System.out.println();
		
		
	}
	
	
}

class PM extends employee{
  int basicPay = 450000;
  PM(){
		 dA = 97*basicPay/100;
		 hRA = 10*basicPay/100;
		 pF = 12*basicPay/100;
		 clubFund = basicPay/1000;
		 System.out.println("Enter details of Project Manager");
	 }	
	
	void display() {
		System.out.println("|==================================================|");
		System.out.print("|	Name: "+emp_name[0]+" "+emp_name[1]);
		for(int i=0;i<37-(emp_name[0].length()+emp_name[1].length()+1);i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|	Employee id: "+emp_id+" 				   |");
		System.out.print("|	Email-id: "+mail_id);
		for(int i=0;i<33-(mail_id.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Mobile number: "+mob_no);
		for(int i=0;i<18;i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.print("|	Address: "+address);
		for(int i=0;i<34-(address.length());i++) {
			System.out.print(" ");
		}
		System.out.print("|\n");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Post: Project Manager         		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Earnings            | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Basic Pay           | "+basicPay+" 		   |");
		System.out.println("|	DA                  | "+this.dA+" 		   |");
		System.out.println("|	HRA                 | "+this.hRA+" 		   |");
		grossSalary = basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary| "+grossSalary+" 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("| 	Deductions          | Amount 		   |");
		System.out.println("|--------------------------------------------------|");
		System.out.println("|	Provident Fund      | "+this.pF+" 		   |");
		System.out.println("|	Staff club fund     | "+this.clubFund+" 		   |");
		netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary  | "+netSalary+" 		   |");
		System.out.println("|==================================================|");
		System.out.println();
		
		
	}
	
	
}

public class payslip {

	public static void main(String[] args) {
		programmer p = new programmer();
		p.getdata();
		teamLead t = new teamLead();
		t.getdata();
		ASP assistant = new ASP();
		assistant.getdata();
		PM manager = new PM();
		manager.getdata();
		System.out.println("\nDisplaying salary slips of all employees\n");
		p.display();
		t.display();
		assistant.display();
		manager.display();
	}

}
