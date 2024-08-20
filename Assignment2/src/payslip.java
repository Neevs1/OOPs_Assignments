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
	
	int dA = 97*basicPay/100;
	int hRA = 10*basicPay/100;
	int pF = 12*basicPay/100;
	int clubFund = basicPay/1000;
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
	int dA = 97*basicPay/100;
	int hRA = 10*basicPay/100;
	int pF = 12*basicPay/100;
	int clubFund = basicPay/1000;
	
	void display() {
		System.out.println("===================================================");
		System.out.println("|	Post: Programmer			 |");
		System.out.println("|	Employee id: "+emp_id+"		 |");
		System.out.println("|	Name: "+emp_name[0]+" "+emp_name[1]+"|");
		System.out.println("|	Address: "+address+"|");
		System.out.println("|	Basic Pay: "+basicPay+"		 |");
		System.out.println("|	DA: "+this.dA+"		   			 |");
		System.out.println("|	HRA: "+this.hRA+"		 |");
		int grossSalary = basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary: "+grossSalary+"	 |");
		System.out.println("|	Provident Fund: "+this.pF+"		 |");
		System.out.println("|	Staff club fund: "+this.clubFund+"		 |");
		int netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary: "+netSalary+"	 |");
		System.out.println("==================================================");
		System.out.println();
		
		
	}
	
		
	
}

class teamLead extends employee{
    int basicPay = 150000;
    int dA = 97*basicPay/100;
	int hRA = 10*basicPay/100;
	int pF = 12*basicPay/100;
	int clubFund = basicPay/1000;
	
	void display() {
		System.out.println("===================================================");
		System.out.println("|	Post: Team Lead	 |");
		System.out.println("|	Employee id: "+emp_id+"		 |");
		System.out.println("|	Name: "+emp_name[0]+" "+emp_name[1]+"|");
		System.out.println("|	Address: "+address+"|");
		System.out.println("|	Basic Pay: "+basicPay+"		 |");
		System.out.println("|	DA: "+this.dA+"		   			 |");
		System.out.println("|	HRA: "+this.hRA+"		 |");
		int grossSalary = this.basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary: "+grossSalary+"	 |");
		System.out.println("|	Provident Fund: "+this.pF+"		 |");
		System.out.println("|	Staff club fund: "+this.clubFund+"		 |");
		int netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary: "+netSalary+"	 |");
		System.out.println("==================================================");
		System.out.println();
		
		
		
	}
	
}

class ASP extends employee{
    int basicPay = 250000;
    int dA = 97*basicPay/100;
	int hRA = 10*basicPay/100;
	int pF = 12*basicPay/100;
	int clubFund = basicPay/1000;
	
	void display() {
		System.out.println("===================================================");
		System.out.println("|	Post: Assistant Project Manager |");
		System.out.println("|	Employee id: "+emp_id+"		 |");
		System.out.println("|	Name: "+emp_name[0]+" "+emp_name[1]+"|");
		System.out.println("|	Address: "+address+"|");
		System.out.println("|	Basic Pay: "+basicPay+"		 |");
		System.out.println("|	DA: "+this.dA+"		   			 |");
		System.out.println("|	HRA: "+this.hRA+"		 |");
		int grossSalary = this.basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary: "+grossSalary+"	 |");
		System.out.println("|	Provident Fund: "+this.pF+"		 |");
		System.out.println("|	Staff club fund: "+this.clubFund+"		 |");
		int netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary: "+netSalary+"	 |");
		System.out.println("==================================================");
		System.out.println();
				
		
	}
	
}

class PM extends employee{
  int basicPay = 450000;
  int dA = 97*basicPay/100;
	int hRA = 10*basicPay/100;
	int pF = 12*basicPay/100;
	int clubFund = basicPay/1000;	
	
	void display() {
		System.out.println("===================================================");
		System.out.println("|	Post: Prject Manager		 |");
		System.out.println("|	Employee id: "+emp_id+"		 |");
		System.out.println("|	Name: "+emp_name[0]+" "+emp_name[1]+"|");
		System.out.println("|	Address: "+address+"|");
		System.out.println("|	Basic Pay: "+basicPay+"		 |");
		System.out.println("|	DA: "+this.dA+"		   			 |");
		System.out.println("|	HRA: "+this.hRA+"		 |");
		int grossSalary = this.basicPay+this.dA+this.hRA;
		System.out.println("|	Gross payable salary: "+grossSalary+"	 |");
		System.out.println("|	Provident Fund: "+this.pF+"		 |");
		System.out.println("|	Staff club fund: "+this.clubFund+"		 |");
		int netSalary = grossSalary - this.pF - this.clubFund;
		System.out.println("|	Net payable salary: "+netSalary+"	 |");
		System.out.println("==================================================");
		System.out.println();		
		
	}
	
}

public class payslip {

	public static void main(String[] args) {
		programmer p = new programmer();
		teamLead t = new teamLead();
		ASP assistant = new ASP();
		PM manager = new PM();
		System.out.println("Enter details of programmer");
		p.getdata();
		System.out.println("Enter details of Team lead");
		t.getdata();
		System.out.println("Enter details of Assistant Project Manager");
		assistant.getdata();
		System.out.println("Enter details of Project Manager");
		manager.getdata();
		System.out.println("Displaying salary slips of all employees");
		p.display();
		t.display();
		assistant.display();
		manager.display();
	}

}
