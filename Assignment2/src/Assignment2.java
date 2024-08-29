import java.util.*;
import java.time.Month;

class publication{
	Scanner sc = new Scanner(System.in);
	String title;
	int copies,price,purchaseCost;
	void saleCopy(){
		System.out.println("Number of copies of "+title+" are "+copies);
	}
	
}

class book extends publication{
	String author;
	int order;
	void getdata() {
		System.out.println("Enter title of book(Use underscore instead of spaces)");
		title = sc.next();
		System.out.println("Enter author of book(Use underscores in stead of spaces)");
		author=sc.next();
		
		do {
			System.out.println("Enter number of copies available");
			copies=sc.nextInt();
			if(copies<1) {
				System.out.println("Invalid amount of copies \nPlease enter price again");
			}
		}while(copies<1);
		do {
			System.out.println("Enter price of book");
			price=sc.nextInt();
			if(price<1) {
				System.out.println("Invalid price \nPlease enter price again");
			}
		}while(price<1);
		System.out.println("Thank you, data has been entered");
	}
	void orderCopies() {
		if (this.copies==0){
			System.out.println("Sorry, this book is not in stock");
		}else {
			System.out.println("Great choice! Please enter number of copies you would like to purchase");
			order=sc.nextInt();
			if(order>this.copies) {
				System.out.println("Sorry, only "+this.copies+" copies are available");
				System.out.println("Do you wish to buy "+this.copies+" books?(Respond with Yes if yes)");
				String cont = sc.next().toLowerCase();
				
				if(cont.equals("yes")) {
					order = this.copies;
					System.out.println("Thank you for the purchase");
					this.purchaseCost=this.copies*this.price;
					System.out.println("Your total cost for "+this.copies+" of "+this.title+" is "+this.purchaseCost);
					this.copies = 0;
				}else {
					System.out.println("We are sorry for the inconvenience");
				}
			}else {
				System.out.println("Thank you for the purchase");
				this.purchaseCost=this.copies*this.price;
				System.out.println("Your total cost for "+this.copies+" of "+this.title+" is "+this.purchaseCost);
				this.copies = this.copies-order;
				
			}
		}
	}
	
	
}

class magazine extends publication{
	int issue;
	int issues[];
	
	void getdata() {
		System.out.println("Enter title of Magazine(Use underscore instead of spaces)");
		title = sc.next();
		System.out.println("Enter number of month of current issue");
		issue = sc.nextInt();
		for(int i=0;i<issue;i=i++) {
			Month month = Month.of(i+1);
			System.out.println("Enter amount of issues of month: "+month);
			issues[i]=sc.nextInt();
			copies=copies+issues[i];
		}
		System.out.println("Enter price of latest issue");
		price=sc.nextInt();
		
		
		
	}
	void orderQty(){
		
		
	}
	
	void currentIssue() {
		Month month = Month.of(issue);
		System.out.println("Current issue of "+title+" is "+month+",2024");
		
	}
	
	void receiveIssue() {
		System.out.println("We have issues for the following months");
		for(int i=1;i<issue;i++) {
			if(issues[i-1]!=0) {
				Month month = Month.of(i);
				System.out.println(month+",2024");
			}
		}
	}
	
}

public class Assignment2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCost=0,totalCopies = 0;
		System.out.println("Vendor side");
		book[] b= new book[5];
		magazine[] m = new magazine[5];
		for(int i=0;i<5;i++) {
			b[i]=new book();
			System.out.println("Enter data of book number "+(i+1));
			b[i].getdata();
		}
		for(int i=0;i<5;i++) {
			m[i]=new magazine();
			System.out.println("Enter data of magazine number "+(i+1));
			m[i].getdata();
		}
		System.out.println("\nEnd of Vendor side \n\nClient side starts here ");
		System.out.println("\n\nWelcome to publications\nWhat would you like to purchase today?");
		System.out.println("1.Books\n2.Magazines");
		int choice = sc.nextInt();
		do {
			switch(choice) {
			case 1:
				System.out.println("Enter which book you want");
				for(int i=0;i<5;i++) {
					System.out.print((i+1)+". "+b[i].title);
					b[i].saleCopy();
				}
			    choice = sc.nextInt();
			    if(choice>0&&choice<6) {
			    	b[choice-1].orderCopies();
			    	totalCopies = totalCopies + b[choice-1].order;
			    	totalCost = totalCost + b[choice-1].purchaseCost;			    	
			    }else {
			    	System.out.println("Invalid input");
			    }
			case 2:
				System.out.println("Enter which magazine you want");
				for(int i=0;i<5;i++) {
					System.out.print((i+1)+". "+m[i].title);
					m[i].saleCopy();
				}
			case 3:
				System.out.println("Invalid input");
				
			}
			System.out.println("Do you wish to continue?");
			System.out.println("1.Books\n2.Magazines\nPress any other number to exit");
			choice = sc.nextInt();
			
		}while(choice==1||choice==2);
		
		System.out.println("You have purchased a total of "+totalCopies+" copies/quantity worth "+totalCost);
		System.out.println("Thank you for shopping with us");
		
		
	}

}
