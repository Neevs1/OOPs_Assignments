import java.util.*;
import java.time.Month;

class publication{ //base class for program
	Scanner sc = new Scanner(System.in);
	String title; //common variable declaration
	int copies,price;
	double purchaseCost;
	void saleCopy(){ //common method
		System.out.println("Number of copies of "+title+" are "+copies+" at "+price);
	}
	
}

class book extends publication{ //declared book class
	String author; //distinct variables
	int order;
	void getdata() { //get data from publication
		System.out.println("Enter title of book(Use underscore instead of spaces)");
		title = sc.next();
		System.out.println("Enter author of book(Use underscores in stead of spaces)");
		author=sc.next();
		
		do { //validation for copies
			System.out.println("Enter number of copies available");
			copies=sc.nextInt();
			if(copies<1) {
				System.out.println("Invalid amount of copies \nPlease enter copies again");
			}
		}while(copies<1);
		do {
			System.out.println("Enter price of book");
			price=sc.nextInt();
			if(price<1) {
				System.out.println("Invalid price \nPlease enter price again");
			}
		}while(price<1); //validation for price
		System.out.println("Thank you, data has been entered"); //completion of data entry
	}
	void orderCopies() { // method for ordering
		if (this.copies==0){ //validation for out of stock
			System.out.println("Sorry, this book is not in stock");
		}else {
			
			do { //validation for orders
				System.out.println("Great choice! Please enter number of copies you would like to purchase");
				order = sc.nextInt();
				if(order<0) {
					System.out.println("Inavlid input, please re-enter");
				}
				}while(order<0);
			if(order>this.copies) { //if copies are less than ordered
				System.out.println("Sorry, only "+this.copies+" copies are available");
				System.out.println("Do you wish to buy "+this.copies+" books?(Respond with Yes if yes)");
				String cont = sc.next().toLowerCase();
				
				if(cont.equals("yes")) {
					order = this.copies;
					System.out.println("Thank you for the purchase");
					this.purchaseCost=this.copies*this.price;
					System.out.println("Your total cost for "+this.copies+" of "+this.title+" is "+this.purchaseCost);
					this.copies = 0;
				}else { //purchase cancellation
					System.out.println("We are sorry for the inconvenience");
				}
			}else { //purchase completion
				System.out.println("Thank you for the purchase");
				this.purchaseCost=this.copies*this.price;
				System.out.println("Your total cost for "+this.copies+" of "+this.title+" is "+this.purchaseCost);
				this.copies = this.copies-order;
				
			}
		}
	}
	
	
}

class magazine extends publication{ //magazine class declared
	int issue;
	int issues[];
	int order; //unique variables
	
	
	void getdata() { //method to get data for publication
		System.out.println("Enter title of Magazine(Use underscore instead of spaces)");
		title = sc.next();
		System.out.println("Enter number of month of current issue");
		issue = sc.nextInt();
		issues= new int[issue];
		for(int i=0;i<issue;i++) {
			Month month = Month.of(i+1);
			System.out.println("Enter amount of issues of month: "+month);
			issues[i]=sc.nextInt();
			copies=copies+issues[i];
		}
		System.out.println("Enter price of latest issue");
		price=sc.nextInt();
		
		
		
	}
	void orderQty(){ //method to order magazines
		System.out.println("Please enter number of month of issue");
		int mth=sc.nextInt();
		if(issues[mth-1]==0) {
			System.out.println("Sorry, out of stock");
			
		}else {
			do {
			System.out.println("Enter number of magazines you wish to purchase");
			order = sc.nextInt();
			if(order<0) {
				System.out.println("Inavlid input, please re-enter");
			}
			}while(order<0);
			}
			if(issues[mth-1]<order) {
			System.out.println("Sorry, only "+issues[mth-1]+" copies are available");
			System.out.println("Do you wish to buy "+issues[mth-1]+" books?(Respond with Yes if yes)");
			String cont = sc.next().toLowerCase();
			
			if(cont.equals("yes")) {
				order = this.issues[mth-1];
				System.out.println("Thank you for the purchase");
				this.purchaseCost=this.order*(this.price-((issues.length-mth)*0.025));
				System.out.println("Your total cost for "+this.order+" of "+this.title+" is "+this.purchaseCost);
				this.copies = this.copies-order;
			}else {
				System.out.println("We are sorry for the inconvenience");
			}
		}else {
			System.out.println("Thank you for the purchase");
			this.purchaseCost=this.order*(this.price-((issues.length-mth)*0.025));
			System.out.println("Your total cost for "+this.order+" of "+this.title+" is "+this.purchaseCost);
			issues[mth-1]=issues[mth-1]-order;
			
		}
		
		
	}
	
	void currentIssue() { //method to display current issue
		Month month = Month.of(issue); //using month enum
		System.out.println("Current issue of "+title+" is "+month+",2024");
		
	}
	
	void receiveIssue() { //to display all available issues
		System.out.println("We have issues for the following months");
		for(int i=1;i<issue;i++) {
			if(issues[i-1]!=0) {
				Month month = Month.of(i);
				System.out.println(month+",2024 : "+issues[i]);
			}
		}
		System.out.println("There is a discount on older issues of magazines");
	}
	
}

public class Assignment2 { //main class

	public static void main(String[] args) { //main method
		Scanner sc = new Scanner(System.in);
		double totalCost=0;
		int totalCopies = 0; //variables for total sale calculation
		System.out.println("Vendor side"); //vendor side
		book[] b= new book[2]; //data of 2 books 
		magazine[] m = new magazine[2]; //data of 2 magazines
		for(int i=0;i<2;i++) { //get data of books
			b[i]=new book(); 
			System.out.println("Enter data of book number "+(i+1));
			b[i].getdata();
		}
		for(int i=0;i<2;i++) { //get data of magazines
			m[i]=new magazine();
			System.out.println("Enter data of magazine number "+(i+1));
			m[i].getdata();
		}
		System.out.println("\nEnd of Vendor side \n\nClient side starts here "); //purchase for client
		System.out.println("\n\nWelcome to publications\nWhat would you like to purchase today?");
		System.out.println("1.Books\n2.Magazines");
		int choice = sc.nextInt();
		do { //do while for at least 1 purchase
			switch(choice) { //option to buy either book or magazine
			case 1:
				System.out.println("Enter which book you want");
				for(int i=0;i<2;i++) {
					System.out.println((i+1)+". "+b[i].title);
					b[i].saleCopy();
				}
			    choice = sc.nextInt();
			    if(choice>0&&choice<3) {
			    	b[choice-1].orderCopies();
			    	totalCopies = totalCopies + b[choice-1].order;
			    	totalCost = totalCost + b[choice-1].purchaseCost;			    	
			    }else {
			    	System.out.println("Invalid input");
			    }
			    break;
			case 2:
				System.out.println("Enter which magazine you want");
				for(int i=0;i<2;i++) {
					System.out.println((i+1)+". "+m[i].title);
					m[i].saleCopy();
				}
				choice = sc.nextInt();
			    if(choice>0&&choice<3) {
			    	m[choice-1].currentIssue();
			    	m[choice-1].receiveIssue();
			    	m[choice-1].orderQty();
			    	totalCopies = totalCopies + m[choice-1].order;
			    	totalCost = totalCost + m[choice-1].purchaseCost;			    	
			    }else {
			    	System.out.println("Invalid input");
			    }
				break;
			case 3:
				System.out.println("Invalid input");
				break;
				
			}
			System.out.println("Do you wish to continue?");
			System.out.println("1.Books\n2.Magazines\nPress any other number to exit");
			choice = sc.nextInt(); //for multiple purchases/exit
			
		}while(choice==1||choice==2);
		
		System.out.println("You have purchased a total of "+totalCopies+" copies/quantity worth "+totalCost);
		System.out.println("Thank you for shopping with us"); //final bill display
		
		
	}

}
